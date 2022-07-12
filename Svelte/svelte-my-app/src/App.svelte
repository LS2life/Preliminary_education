<script>
import logo from './assets/svelte.png'
import Component001 from './lib/Component001.svelte'
import Component from './lib/Component.svelte'
import ConditionalAndRepetitive from './lib/ConditionalAndRepetitive.svelte'
import Counter from './lib/Counter.svelte'
import DeclarativeRendering from './lib/DeclarativeRendering.svelte'
import EventHandling from './lib/EventHandling.svelte'
import Store from './lib/store/Store.svelte'
import Something001 from './lib/life_cycle/Something001.svelte'
</script>

<main>
  <img src={logo} alt="Svelte Logo" />
  <h1>Hello world!</h1>

  <Counter />
  <DeclarativeRendering/>
  <ConditionalAndRepetitive/>
  <EventHandling/>
  <Component/>
  <Component001/>
  <Store/>
  <Something001/>

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

  img {
    height: 16rem;
    width: 16rem;
  }

  h1 {
    color: #ff3e00;
    text-transform: uppercase;
    font-size: 4rem;
    font-weight: 100;
    line-height: 1.1;
    margin: 2rem auto;
    max-width: 14rem;
  }

  p {
    max-width: 14rem;
    margin: 1rem auto;
    line-height: 1.35;
  }

  @media (min-width: 480px) {
    h1 {
      max-width: none;
    }

    p {
      max-width: none;
    }
  }
</style>
