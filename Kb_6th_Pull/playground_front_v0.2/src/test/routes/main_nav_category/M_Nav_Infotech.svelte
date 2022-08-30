<script>
    import { fly } from "svelte/transition";
    import { Router, Link, Route } from "svelte-routing";

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
    let isActive = () => {
        active = !active;
    };
</script>

<div>
    {#if active}
        <div class="mMainMenu" transition:fly={{ duration: 700, x: 200 }}>
            {#each mNavCategory as { id, name }, i}
                <span>
                    <button>
                        <Link to={id} on:click={isActive}>{name}</Link>
                    </button>
                </span>
            {/each}
        </div>
    {/if}
</div>

<style>
</style>
