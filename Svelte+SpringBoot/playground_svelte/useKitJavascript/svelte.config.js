import adapter from '@sveltejs/adapter-static';
import preprocess from 'svelte-preprocess';
import { mdsvex } from 'mdsvex';

import mdsvexConfig from './mdsvex.config.js';

/** @type {import('@sveltejs/kit').Config} */
const config = {
	extensions: ['.svelte', '.md'],
	preprocess: [preprocess(), mdsvex(mdsvexConfig)],
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
