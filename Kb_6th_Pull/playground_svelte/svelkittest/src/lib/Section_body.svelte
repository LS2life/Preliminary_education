<script >
	import { page } from '$app/stores';
	/** @type {import('./$type').PageData}*/
	export let data;
</script >

<nav>
	<a href="/">Home</a>
	<a href="/about">About</a>
	<a href="/settings">Settings</a>
</nav>
<h1>Settings</h1>

<div class="submenu">
		<a href="/settings/{data.section.slug}">{data.section.title}</a>
</div>
<slot></slot>

<!--{#each end_view as {id, name}, i}-->
<!--	<div class:active={$page.url.pathname === {name}}>-->
<!--	</div>-->
<!--{/each}-->


<style >

</style >