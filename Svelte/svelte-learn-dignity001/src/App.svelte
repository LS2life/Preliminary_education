<script>
  import { Router, Link, Route } from "svelte-routing"
  import Counter from './lib/Counter.svelte'
  import Home from "./lib/router/Home.svelte"
  import About from "./lib/router/About.svelte"
  import Nested from "./lib/basicGrammar/Nested.svelte"
  import logo from './assets/svelte.png'
  import DataBinding from "./lib/basicGrammar/DataBinding.svelte"
  import LifeCycle from "./lib/life_cycle/LifeCycle.svelte"
  import Store from "./lib/store/Store.svelte"

  export let url = "";
  let name="Svelte"
</script>

<main class="container">
  <Router url={url}>
    <nav class="navbar navbar-light navbar-expand-lg" style="background-color:#ffc6b3">
      <div class="container">
        <a class="navbar-brand" href="/">
          <img src="{logo}" alt="Svelte Icon" height="30px">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <Link class="nav-link active" aria-current="page" to="/" >Home</Link>
            <Link class="nav-link" to="about">About</Link>
            <Link class="nav-link" to="counter">Counter</Link>
            <Link class="nav-link" to="Nested">Nested</Link>
            <Link class="nav-link" to="DataBinding">DataBinding</Link>
            <Link class="nav-link" to="LifeCycle">LifeCycle</Link>
            <Link class="nav-link" to="Store">Store</Link>
          </ul>
        </div>
      </div>
    </nav>
    
    <div>
      <Route path="/"><Home /></Route>
      <Route path="about" component={About} />
      <Route path="counter" component={Counter} />
      <Route path="Nested" component={Nested} name={name}/>
      <Route path="DataBinding" component={DataBinding}/>
      <Route path="LifeCycle" component={LifeCycle}/>
      <Route path="Store" component={Store}/>
    </div>
  </Router>

  <p>
    Visit <a href="https://svelte.dev">svelte.dev</a> to learn how to build Svelte
    apps.
  </p>

  <p>
    Check out <a href="https://github.com/sveltejs/kit#readme">SvelteKit</a> for
    the officially supported framework, also powered by Vite!
  </p>
</main>

<style>
  :root {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen,
      Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  }

  main {
    text-align: center;
    padding: 1em;
    margin: 0 auto;
  }
  
</style>
