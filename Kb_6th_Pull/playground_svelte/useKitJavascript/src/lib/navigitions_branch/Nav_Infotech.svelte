<script >
// @ts-nocheck
	import { page } from "$app/stores";
</script >

<nav>
	<svg viewBox="0 0 2 3" aria-hidden="true">
		<path d="M0,0 L1,2 C1.5,3 1.5,3 2,3 L2,0 Z" />
	</svg>
		<ul>
			<li class:active={$page.url.pathname === '/blog/infotech/codename'}>
				<a href='blog/infotech/codename'>CodeName</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/dbms'}>
				<a href='/blog/infotech/dbms'>DBMS</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/framework'}>
				 <a href='/blog/infotech/framework'>Framework</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/os'}>
				<a href='/blog/infotech/os'>OS</a>
			</li>
			<li class:active={$page.url.pathname === '/blog/infotech/vc'}>
				<a href='/blog/infotech/vc'>VC</a>
			</li>
		</ul>
	<svg viewBox="0 0 2 3" aria-hidden="true">
		<path d="M0,0 L0,3 C0.5,3 0.5,3 1,2 L2,0 Z" />
	</svg>
</nav>

<style >

</style >