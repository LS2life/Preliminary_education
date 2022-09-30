import adapter from '@sveltejs/adapter-static';

/** @type {import('@sveltejs/kit').Config} */
const config = {
	kit: {
		adapter: adapter({
			fallback: '200.html',
			trailingSlash: 'always',
			pages: 'build',
			assets: 'build'
		})
	}
};

export default config;