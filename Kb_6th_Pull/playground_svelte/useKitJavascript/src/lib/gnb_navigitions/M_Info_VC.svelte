<script>
	import { fly} from 'svelte/transition';
	import { page } from '$app/stores';
</script>

<nav in:fly="{{ x: -100, duration: 500, delay: 500}}" out:fly="{{ x: 100}}">
		<ul>
			<li class:active={$page.url.pathname === '/blog/infotech/vc/github'}>
				<a href='/blog/infotech/vc/github'>GitHub</a>
			</li>
		</ul>
</nav>


<style>
  nav {
    display: flex;
    align-items: center;
    justify-content: center;
    --background: rgba(230, 230, 230, 0.7);
  }


  ul {
    position: relative;
    padding: 0;
    margin: 0;
    height: 3em;
    display: flex;
    justify-content: center;
    align-items: center;
    list-style: none;
    background: var(--background);
    background-size: contain;
  }

  li {
    border: 1px solid slategray;

    position: relative;
    height: 100%;
  }

  li.active::before {
    --size: 6px;
    content: '';
    width: 0;
    height: 0;
    position: absolute;
    top: 0;
    left: calc(50% - var(--size));
    border: var(--size) solid transparent;
    border-top: var(--size) solid var(--color-theme-1);
  }

  a {
    color: var(--color-theme-1);
    text-decoration: inherit;
  }
  a:hover {
    text-decoration: underline;
  }

  nav a {
    display: flex;
    height: 100%;
    align-items: center;
    padding: 0 0.5rem;
    color: var(--color-text);
    font-weight: 700;
    font-size: 1rem;
    letter-spacing: 0.1em;
    text-decoration: none;
    transition: color 0.2s linear;
  }
</style>