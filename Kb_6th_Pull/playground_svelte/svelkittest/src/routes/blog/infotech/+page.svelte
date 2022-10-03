<script >
import { page } from '$app/stores'
</script >

<nav>
<!--  <svg viewBox="0 0 2 3" aria-hidden="true">-->
<!--    <path d="M0,0 L1,2 C1.5,3 1.5,3 2,3 L2,0 Z" />-->
<!--  </svg>-->
  <div class:active={$page.url.pathname.startsWith('/infotech')}>
    <ul>
      <li class:active={$page.url.pathname.startsWith('/infotech')}>
        <a href="/infotech">InfoTech</a>
      </li>
      <li class:active={$page.url.pathname === '/cosmos'}>
        <a href="/cosmos">Cosmos</a>
      </li>
      <li class:active={$page.url.pathname === '/engineering'}>
        <a href="/engineering">Engineering</a>
      </li>
      <li class:active={$page.url.pathname === '/language'}>
        <a href="/language">Language</a>
      </li>
      <li class:active={$page.url.pathname === '/scific'}>
        <a href="/scific">SciFic</a>
      </li>
      <li class:active={$page.url.pathname === '/etc'}>
        <a href="/etc">etC</a>
      </li>
    </ul>
  </div>
<!--  <svg viewBox="0 0 2 3" aria-hidden="true">-->
<!--    <path d="M0,0 L0,3 C0.5,3 0.5,3 1,2 L2,0 Z" />-->
<!--  </svg>-->
</nav>

<style >

</style >