<script>
    import MenuSlide from './Menu_slide.svelte';
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
import { xlink_attr } from 'svelte/internal';


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

<h1>이게 될까?</h1>


<label id="main_slide">
    <input type="checkbox" bind:checked={visible}>
    visible
</label>

<!-- <button on:click={}></button> -->

<Router {url}>
    {#if visible}
    <div id="slide_menu" transition:fly="{{x: 90}}">
        {#each AutoAdd as {id, name}, i}
            <Link  to="{id}">{name}</Link><br>
        {/each}
    </div>
{/if}
<div>
    <Route path="java" component={Java}/>
    <Route path="javaScript" component={JavaScript}/>
    <Route path="python" component={Python}/>
    <Route path="ubuntu" component={Ubuntu}/>
    <Route path="markdown" component={Markdown}/>
    <Route path="html5" component={Html5}/>
    <Route path="css3" component={CSS3}/>
    <Route path="about" component={About}/>
</div>
</Router>


<style>
#main_slide {
    border: 1px solid blue;

    position: fixed;
    top: 0;
    right: 0;
    width: 20vw;
    padding: 10px;

}

#slide_menu, #main_slide {
    border: 1px solid blue;

    position: fixed;
    height: 100vh;
    width: 20vw;
    top: 0px;
    right: 0;
    text-align: left;
    font-size: 1.22em;
    padding: 10px;
}
</style>