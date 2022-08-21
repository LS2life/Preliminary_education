<script>
    import { Link, Router, Route } from "svelte-routing";
    import { fly, scale, crossfade, fade, blur, slide } from 'svelte/transition';
    export let url = ""

    let InfoTech = [
        { id: 'submenu',  name: 'SubMenu'     },
    ]

    let active = false;
    const isActive = () => { active = !active };
</script>

<Router {url}>>
    {#if active }
        <div class="mMainMenu">
        {#each InfoTech as {id, name}, i}
            <span class="mMainMenuFold" transition:slide="{{duration:1000}}">
                <Link to="{id}" on:click={isActive}>{name}</Link>
            </span>
        {/each}
        </div>
    {/if}
</Router>


<style>
.mMainMenu {
        font-size: 2.5vmin;
        padding: 0.2em;
    }


    div {
        border: 1px solid lawngreen;
    }

</style>