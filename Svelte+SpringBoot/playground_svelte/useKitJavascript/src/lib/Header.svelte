<script>
	import { page } from '$app/stores';
</script>

<!--
<div class="corner" class:active={$page.url.pathname ==='/'}>
  <a href="/">
    <img src={ Home } alt="GitHub Blog" title="GitHub Blog Home"/>
  </a>
</div>
-->
<header>
  <spen class:active={$page.url.pathname === '/blog'}>
    <a href="/blog">
      <h1>A|∀ & T|ㄱ & i|! & m|m & E|∃</h1>
    </a>
    <h2>CQ*3 DEHL E. N. AS QSA EX VA*2 TNX*2 AR.</h2>
  </spen>
</header>

<style>
  a {
    color: var(--color-text);
    text-decoration: inherit;
  }
  
  header {
    border: 1px solid darkslategray;
    display: flex;
    line-height: 40px;
    text-align: center;
  }

  spen {
    width: 100%;
  }

  h1 {
    font-family: "East Sea Dokdo", cursive;
    font-size: 10vmin;
    line-height: 1.1;
  }
  h2 {
    border: 1px solid darkcyan;
    font-family: "Stylish", sans-serif;
    font-size: 3.5vmin;
    place-items: center;
  }
</style>