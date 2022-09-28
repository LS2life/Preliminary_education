// import { defineConfig } from "vite";

// // https://vitejs.dev/config/
// export default defineConfig({
//   base: "ls2git/",
//   plugins: [svelte()],
// });

import { sveltekit } from "@sveltejs/kit/vite";

/** @type {import('vite').UserConfig} */
const config = {
  plugins: [sveltekit()],
};

export default config;
