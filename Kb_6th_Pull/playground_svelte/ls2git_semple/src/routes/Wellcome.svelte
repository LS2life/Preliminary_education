<script>
  import {Link} from "svelte-routing"
  import GateWay from "./GateWay.svelte";
  import Vitelogo from "../../public/vite.svg";
  import Sveltelogo from "../assets/svelte.svg";
  import GitHublogo from "../assets/git_spaider.png"
  import GitBloglogo from "../assets/alphabet_B.svg"
  let url = ""
</script>

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
    <a href ="https://github.com/LS2life" target="_blank">
      <img src={GitHublogo} class="logo github" alt="GitHub Logo" title="GitHub" />
    </a>
    <!-- <a href ="https://ls2life.github.io/ls2git/{GateWay}" target="_self"> -->
    <!-- <a href ={GateWay} target="_self"> -->
    <!--<a href ="./GateWay.svelte" target="_self">-->
    <Link href="/GateWay" target="_self">
      <img src={GitBloglogo} class="logo gitblog" alt="GitHub Blog Logo" title="Github Blog">
    </Link>
  </div>

  <p>
    Check out <a href="https://github.com/sveltejs/kit#readme" target="_blank" >
      SvelteKit</a>, the official Svelte app framework powered by Vite!
  </p>

</main>

<style>
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
