<script>
	import { page } from '$app/stores';
	import Home from '../images/git_spider.svg';
	import Github from '../images/github.svg';
  import InfoTech from './Nav_Infotech.svelte'
	let url=""
</script>

<nav>
  <div class="corner" class:active={$page.url.pathname ==='/'}>
    <a href="/">
      <img src={ Home } alt="GitHub Blog" title="GitHub Blog Home"/>
    </a>
  </div>

  <nav>
    <svg viewBox="0 0 2 3" aria-hidden="true">
      <path d="M0,0 L1,2 C1.5,3 1.5,3 2,3 L2,0 Z" />
    </svg>
    <ul>
	    <li class:active={$page.url.pathname === '/blog/infotech'}>
		    <a href='/blog/infotech'>InfoTech</a>
	    </li>
      <li class:active={$page.url.pathname === '/blog/cosmos'}>
		    <a href='/blog/cosmos'>Cosmos</a>
	    </li>
      <li class:active={$page.url.pathname === '/blog/engineering'}>
        <a href='/blog/engineering'>Engineering</a>
	    </li>
	    <li class:active={$page.url.pathname === '/blog/language'}>
		    <a href='/blog/language'>Language</a>
	    </li>
      <li class:active={$page.url.pathname === '/blog/scific'}>
        <a href="/blog/scific">SciFic</a>
	    </li>
      <li class:active={$page.url.pathname === '/blog/etc'}>
		    <a href="/blog/etc">etC</a>
	    </li>
	    <!--
			  {#each blog as {id, name}, i}
			  <li class:active={$page.url.pathname === {name}}>
				<Link to={id} href={name}>{id}</Link>
			  </li>
			  {/each}
      -->
    </ul>

    <svg viewBox="0 0 2 3" aria-hidden="true">
      <path d="M0,0 L0,3 C0.5,3 0.5,3 1,2 L2,0 Z" />
    </svg>
  </nav>

  <div class="corner">
    <a href="https://github.com/ls2life">
      <img src={Github} alt="GitHub" title="GitHub"/>
    </a>
  </div>
</nav>


<style>
  .corner {
    width: 3em;
    height: 3em;
  }

  .corner a {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 100%;
  }

  .corner img {
	border: 1px solid red;

	width: 2.5em;
    height: 2.5em;
    object-fit: contain;
  }

  nav {
    display: flex;
    justify-content: center;
    --background: rgba(255, 255, 255, 0.7);
    justify-content: space-between;
  }

  svg {
    width: 2em;
    height: 3em;
    display: block;
  }

  path {
    fill: var(--background);
  }

  ul {
	border: 1px solid red;

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
	border: 1px solid red;

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
    text-transform: uppercase;
    letter-spacing: 0.1em;
    text-decoration: none;
    transition: color 0.2s linear;
  }
</style>