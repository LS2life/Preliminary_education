<script>
	import { fly } from 'svelte/transition';
    import { Router, Link, Route } from "svelte-routing";
    import Java from "../routes/Language_Java.svelte"
    import JavaScript from "../routes/Language_JavaScript.svelte"
    import Python from "../routes/Language_Python.svelte"
    import Ubuntu from "../routes/Linux_Ubuntu.svelte"
    import Markdown from "../routes/Markdown_md.svelte"
    import Html5 from "../routes/Markup_Html.svelte"
    import CSS3 from "../routes/Stylesheet_css.svelte"
    import About from "../routes/About.svelte";

    export let url="";
    let visible_first_nav=true;
    let visible_second_nav= true;
    let visible_third_nav= true;


// pass는 pipe 없음
    let languageAdd = [
        { id: 'java',       name: 'Java',       pass: {Java}},
        { id: 'javaScript', name: 'JavaScript', pass: {JavaScript}},
        { id: 'python',     name: 'Python',     pass: {Python}},
        { id: 'ubuntu',     name: 'Ubuntu',     pass: {Ubuntu}},
        { id: 'markdown',   name: 'Markdown',   pass: {Markdown}},
        { id: 'html5',      name: 'Html5',      pass: {Html5}},
        { id: 'CSS3',       name: 'CSS3',       pass: {CSS3}},
        { id: 'about',      name: 'About',      pass: {About}},
    ];

    let mainMenuAdd = [
        { id: 'codename', name: 'Code_Name'},
        { id: 'framework', name: 'Framework'},
        { id: 'dbms', name: 'DBMS'},
        { id: 'vc', name: 'VC'},
        { id: 'os', name: 'OS'},
        { id: 'etc', name: 'Etc.'},
    ]
</script>


<nav>

<div id="second">
    {#each mainMenuAdd as {id, name}, i}
        <span>
            {name}
        </span>
    {/each}
    <input type="checkbox" bind:checked={visible_third_nav}>
</div>

<div>
    <Router {url}>
        {#if visible_third_nav}
            {#each languageAdd as {id, name}, i}
                <span id="main_nav_text" transition:fly>
                    <Link to="{id}">{name}</Link>
                </span>
            {/each}
        {/if}
    </Router>
</div>

</nav>

<style>
    nav {
        border: 1px solid red;

        position: sticky;
        top: 0;


    }
    div {
        border: 1px solid lawngreen;
        margin: 10px;

    }
    span {
        border: 1px solid lawngreen;

        padding: 1vmin;
        display: inlinex;
        /* margin-left: auto; */
        font-size: 2.5vmin;
        max-width: 1280px;
        width: 100%; 
    }

</style>