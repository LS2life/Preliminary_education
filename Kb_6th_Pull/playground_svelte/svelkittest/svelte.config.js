import adapter from '@sveltejs/adapter-static';

// const dev = process.env.NODE_ENV === 'development';

/**_ @type {import('@sveltejs/kit').Config} */
const config = {
	kit: {
		adapter: adapter({
			fallback: '200.html',
			trailingSlash: 'always',
			pages: 'build',
			assets: 'build',
			precompress: false
		}),
		prerender: { entries: [] },
		trailingSlash: 'always'
	}
};

export default config;
