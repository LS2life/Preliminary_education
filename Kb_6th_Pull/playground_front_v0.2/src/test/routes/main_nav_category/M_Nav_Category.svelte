<script>
	import { fly, slide } from 'svelte/transition';
    import { Router, Link, Route } from "svelte-routing";
    import Java from "../../view/main_nav_codename/Language_Java.svelte"
    import JavaScript from "../../view/main_nav_codename/Language_JavaScript.svelte"
    import Python from "../../view/main_nav_codename/Language_Python.svelte"
    import Ubuntu from "../../view/main_nav_codename/Linux_Ubuntu.svelte"
    import Markdown from "../../view/main_nav_codename/Markdown_md.svelte"
    import Html5 from "../../view/main_nav_codename/Markup_Html.svelte"
    import CSS3 from "../../view/main_nav_codename/Stylesheet_css.svelte"
    import About from "../../view/main_nav_codename/About.svelte";
    import ATM from "../../input_parts/AreaTextMarkdown.svelte"
    export let url="";
    let visible_first_nav = false;
    let visible_second_nav = false;
    let visible_third_nav = false;


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

    let mainInfoTech = [
        { id: 'codename', name: 'Code_Name'},
        { id: 'framework', name: 'Framework'},
        { id: 'dbms', name: 'DBMS'},
        { id: 'vc', name: 'VC'},
        { id: 'os', name: 'OS'},
        { id: 'etc', name: 'Etc.'},
    ]

    let mNavCategory = [
        { id: 'it', name: 'InfoTech'},
        { id: 'cosmos', name: 'Cosmos'},
        { id: 'engineering', name: 'Engineering'},
        { id: 'language', name: 'Language'},
        { id: 'sf', name: 'SciFic'},
        { id: 'etc', name: 'etC.'},
    ]
    

</script>


<Router {url}>

<div>
    {#each mNavCategory as {id, name}, i}
        <span transition:slide>
            <Link to="{id}">{name}</Link>
        </span>
    {/each}
</div>

<div>
    {#each mainInfoTech as {id, name}, i}
        <span transition:fly>
            <Link to="{id}">{name}</Link>
        </span>
    {/each}
</div>

<div>
    {#each languageAdd as {id, name}, i}
        <span transition:fly>
            <Link to="{id}">{name}</Link>
        </span>
    {/each}
</div>


</Router>

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
        font-size: 2.5vmin;
        max-width: 1280px;
        width: 100%; 
    }

</style>