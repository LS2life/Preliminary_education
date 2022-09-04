<script>
    import { Link, Router, Route } from "svelte-routing";
    import { slide, fly } from "svelte/transition";

    let url = "";

    let codeName = [
        { id: "java", name: "Java" },
        { id: "javaScript", name: "JavaScript" },
        { id: "python", name: "Python" },
        { id: "ubuntu", name: "Ubuntu" },
        { id: "markdown", name: "Markdown" },
        { id: "html5", name: "Html5" },
        { id: "CSS3", name: "CSS3" },
        { id: "about", name: "About" },
    ];
</script>

<div transition:fly={{ duration: 700, x: 200 }}>
    {#each codeName as { id, name }, i}
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
