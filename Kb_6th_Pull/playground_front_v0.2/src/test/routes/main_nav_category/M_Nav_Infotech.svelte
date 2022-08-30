
<script>
	import { fly } from 'svelte/transition';
    import {Router, Link, Route} from 'svelte-routing';

    let mNavCategory = [
        { id: "infotech", name: "InfoTech" },
        { id: "cosmos", name: "Cosmos" },
        { id: "engineering", name: "Engineering" },
        { id: "language", name: "Language" },
        { id: "scific", name: "SciFic" },
        { id: "etc", name: "etC." },
    ];

    let url = "";
    let active = false;
    let isActive = () =>{active = !active}
</script>

<div>
    {#if active}
    <div class="mMainMenu" transition:fly={{ duration: 700, x: 200 }}>
        {#each mNavCategory as { id, name }, i}
        <span>
            <Link to={id} on:click={isActive}><button>{name}</button></Link>
            <!-- <Link to={id} on:click={reply_click}>{name}</Link> -->
        </span>
        {/each}
    </div>
    {/if}
</div>



<style>

</style>