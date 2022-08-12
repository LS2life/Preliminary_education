<script>
	import { slide } from 'svelte/transition';
    import { Router, Link, Route } from "svelte-routing";
    import Java from "../routes/Language_Java.svelte"
    import JavaScript from "../routes/Language_JavaScript.svelte"
    import Python from "../routes/Language_Python.svelte"
    import Ubuntu from "../routes/Linux_Ubuntu.svelte"
    import Markdown from "../routes/Markdown_md.svelte"
    import Html5 from "../routes/Markup_Html.svelte"
    import CSS3 from "../routes/Stylesheet_css.svelte"
    import About from "../routes/About.svelte";

// pass는 pipe 없음
    let AutoAdd = [
        { id: 'java', name: 'Java', pass: {Java}},
        { id: 'javaScript', name: 'JavaScript', pass: {JavaScript}},
        { id: 'python', name: 'Python', pass: {Python}},
        { id: 'ubuntu', name: 'Ubuntu', pass: {Ubuntu}},
        { id: 'markdown', name: 'Markdown', pass: {Markdown}},
        { id: 'html5', name: 'Html5', pass: {Html5}},
        { id: 'CSS3', name: 'CSS3', pass: {CSS3}},
        { id: 'about', name: 'About', pass: {About}},
    ];
    export let url="";
    let visible= true;
</script>

<!-- <button on:click={}></button> -->

<div id="main_nav">
    <Router {url}>
        {#if visible}
        <nav id="slide_menu" transition:slide>
            {#each AutoAdd as {id, name}, i}
                <Link  to="{id}">{name}</Link>
            {/each}
        </nav>
        {/if}
        <label >
            visible
            <input type="checkbox" bind:checked={visible}>
        </label>
    </Router>
</div>

<style>
    label {
        border: 1px solid lawngreen;
    }
    #main_nav {
        border: 1px solid lawngreen;

        display: inline-flex;
        position: sticky;
        top: 0;
        left: 0;
        align-items: center;
        text-align: center;
        padding: 15px;
        font-size: 1.5em;

    }
</style>