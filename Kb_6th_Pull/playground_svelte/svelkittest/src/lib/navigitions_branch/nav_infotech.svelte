<script >
	import { page } from "$app/stores";
</script >

<nav>
	<svg viewBox="0 0 2 3" aria-hidden="true">
		<path d="M0,0 L1,2 C1.5,3 1.5,3 2,3 L2,0 Z" />
	</svg>
		<ul>
			<li class:active={$page.url.pathname === '/infotech'}>
				<a href='/infotech'>CodeName</a>
			</li>
			<li class:active={$page.url.pathname === '/cosmos'}>
				<a href='/cosmos'>DBMS</a>
				<!--		    <a href="/blog/cosmos" class="link" use:Link></a>-->
				<!--		    <Link to="cosmos" class="underline">Cosmos</Link>-->
			</li>
			<li class:active={$page.url.pathname === '/engineering'}>
				<a href='/engineering'>Framework</a>
			</li>
			<li class:active={$page.url.pathname === '/language'}>
				<a href='/language'>OS</a>
			</li>
			<li class:active={$page.url.pathname === '/scific'}>
				<a href='/scific'>VC</a>
			</li>
		</ul>
	<svg viewBox="0 0 2 3" aria-hidden="true">
		<path d="M0,0 L0,3 C0.5,3 0.5,3 1,2 L2,0 Z" />
	</svg>
</nav>
codename
dbms
framework
os
vc

<style >

</style >