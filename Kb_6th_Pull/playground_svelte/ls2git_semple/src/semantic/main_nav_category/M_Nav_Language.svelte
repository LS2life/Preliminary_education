<script>
    import { Link, Router, Route } from "svelte-routing";
    import { slide, fly } from "svelte/transition";
    import Mname from "./M_Nav_Info_CodeName.svelte";

    let url = "";

    const Language = [
        { id: "das_deutsche", name: "Deutsche" },
        { id: "english", name: "English" },
        { id: "espanol", name: "Espanol" },
        { id: "francais", name: "Francais" },
        { id: "pyccknn", name: "Pyccknn" },
        // { id: '', name: '' },
    ];
</script>

<div transition:fly={{ duration: 700, x: 200 }}>
    {#each Language as { id, name }, i}
        <button>
            <Link to={id}>{name}</Link>
        </button>
    {/each}
</div>

<style>
    button {
        font-family: "Noto Sans KR", sans-serif;
        border: none;
        color: #000;
        font-size: 2.5vmin;
        margin-left: 0.2em;
        margin-right: 0.2em;
    }
</style>
