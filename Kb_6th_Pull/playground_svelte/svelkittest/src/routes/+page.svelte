<script>
	// import {Link} from "svelte-routing"
	// import GateWay from "./blog/GateWay.svelte";
  import Header from '../lib/Header.svelte';
  import Footer from "../lib/Footer.svelte";
  import '../styles.css';
	import {page} from '$app/stores'
	import Vitelogo from "../assets/vite.svg";
	import Sveltelogo from "../assets/svelte.svg";
	import GitHublogo from "../assets/git_spaider.png"
	import GitBloglogo from "../assets/alphabet_B.svg"
	let url = ""
</script>

<div class="app">
  <Header />

  <main>
    <div class="config">
      <a href="https://vitejs.dev" target="_blank">
        <img src={Vitelogo} class="logo vite" alt="Vite Logo" title="Vite" />
      </a>
      <a href="https://svelte.dev" target="_blank">
        <img src={Sveltelogo} class="logo svelte" alt="Svelte Logo" title="Svelte" />
      </a>
      <h3>Made by</h3><h1>Vite + Svelte</h1>
    </div>
    <div>
      <ul>
        <li>
          <a href ="https://github.com/LS2life" target="_blank">
            <img src={GitHublogo} class="logo github" alt="GitHub Logo" title="GitHub" />
          </a>
        </li>
        <li class:active={$page.url.pathname === '/about' } >
          <!--		<a href ="https://ls2life.github.io/ls2git/blog/GateWay" target="_self">-->
          <a href="/about">
            <img  src={GitBloglogo} class="logo gitblog" alt="GitHub Blog Logo" title="Github Blog">
          </a>
        </li>
      </ul>
    </div>

    <p>
      Check out <a href="https://github.com/sveltejs/kit#readme" target="_blank" >
      SvelteKit</a>, the official Svelte app framework powered by Vite!
    </p>
  </main>

  <Footer />
</div>

<style>
  .app {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
  }

  main {
    flex: 1;
    display: flex;
    flex-direction: column;
    padding: 1rem;
    width: 100%;
    max-width: 64rem;
    margin: 0 auto;
    box-sizing: border-box;
  }

	.config {
		border: 2px solid darkgray;
		border-radius: 3em;

	}
	.logo.vite, .logo.svelte {
		height: 6em;
		padding: 2em;
		will-change: filter;
	}
	.logo.github, .logo.gitblog {
		height: 7em;
		padding: 1em;
		will-change: filter;
	}
	.logo:hover {
		filter: drop-shadow(0 0 2em #646cffaa);
	}
	.logo.svelte:hover {
		filter: drop-shadow(0 0 2em #ff3e00aa);
	}
	.logo.github:hover {
		filter: drop-shadow(0 0 2em #ff0000aa);
	}
	.logo.gitblog:hover {
		filter: drop-shadow(0 0 2em #00c3ffbe);
	}
</style>



<!--
<script>
	import Counter from './Counter.svelte';
	import welcome from '$lib/images/svelte-welcome.webp';
	import welcome_fallback from '$lib/images/svelte-welcome.png';
</script>

<svelte:head>
	<title>Home</title>
	<meta name="description" content="Svelte demo app" />
</svelte:head>

<section>
	<h1>
		<span class="welcome">
			<picture>
				<source srcset={welcome} type="image/webp" />
				<img src={welcome_fallback} alt="Welcome" />
			</picture>
		</span>

		to your new<br />SvelteKit app
	</h1>

	<h2>
		try editing <strong>src/routes/+page.svelte</strong>
	</h2>

	<Counter />
</section>

<style>
	section {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		flex: 0.6;
	}

	h1 {
		width: 100%;
	}

	.welcome {
		display: block;
		position: relative;
		width: 100%;
		height: 0;
		padding: 0 0 calc(100% * 495 / 2048) 0;
	}

	.welcome img {
		position: absolute;
		width: 100%;
		height: 100%;
		top: 0;
		display: block;
	}
</style>
-->