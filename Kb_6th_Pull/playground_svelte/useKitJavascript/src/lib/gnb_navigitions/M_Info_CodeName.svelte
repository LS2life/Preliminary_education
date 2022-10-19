<script>
	import { fly} from 'svelte/transition';
	import { page } from '$app/stores';
</script>

<nav in:fly="{{ x: -100, duration: 500, delay: 500}}" out:fly="{{ x: 100}}">
		<ul>
			<li class:active={$page.url.pathname === '/blog/infotech/codename/html5'}>
				<a href='/blog/infotech/codename/html5'>HTML5</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/codename/css3'}>
				<a href='/blog/infotech/codename/css3'>CSS3</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/codename/javascript'}>
				<a href='/blog/infotech/codename/javascript'>Javascript</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/codename/java'}>
				<a href='/blog/infotech/codename/java'>Java</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/codename/python'}>
				<a href='/blog/infotech/codename/python'>Python</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/codename/markdown'}>
				<a href='/blog/infotech/codename/markdown'>Markdown</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/codename/cpp'}>
				<a href='/blog/infotech/codename/cpp'>C,C++</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/codename/csharp'}>
				<a href='/blog/infotech/codename/csharp'>C#</a>
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
    border: 1px solid darkgreen;

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