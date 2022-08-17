<script>
	import { slide } from 'svelte/transition';
    import Nav1 from './main_nav_category/M_Nav_Category.svelte'

let active= false;
const isActive=()=>{
    active = !active
}

</script>



<nav>

<button transition:slide on:click={isActive}>=</button>
{#if active}
    <Nav1 />
{/if}

</nav>



<style>
    nav {
        border: 1px solid red;

        position: sticky;
        top: 0;
    }
</style>