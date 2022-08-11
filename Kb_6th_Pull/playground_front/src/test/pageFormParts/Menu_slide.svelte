<script>
    import { slide } from "svelte/transition";
    import { Router, Link, Route } from "svelte-routing";
    import Java from "../routes/Language_Java.svelte";
    import JavaScript from "../routes/Language_JavaScript.svelte"
    import Python from "../routes/Language_Python.svelte"
    import Ubuntu from "../routes/Linux_Ubuntu.svelte"
    import Markdown from "../routes/Markdown_md.svelte"
    import Html5 from "../routes/Markup_Html.svelte"
    import CSS3 from "../routes/Stylesheet_css.svelte"
    import About from "../routes/About.svelte";
    import Home from "./Page_Grid.svelte"

    export let url = "";
    let visible = true;
</script>

<div id="butten_main_slide">
    <label id="main_slide">
        <input type="checkbox" bind:checked={visible}>
        visible
    </label>
</div>

<Router {url}>

{#if visible}

<div id="slide_menu" transition:slide>
    <li> <Link to="java">Java</Link> </li>
    <li> <Link to="javaScript">JavaScript</Link> </li>
    <li> <Link to="python">Pytnon</Link> </li>
    <li> <Link to="ubuntu">Ubuntu</Link> </li>
    <li> <Link to="markdown">Markdown</Link> </li>
    <li> <Link to="html5">Html5</Link> </li>
    <li> <Link to="css3">CSS3</Link> </li>
    <li> <Link to="about">About</Link> </li>
</div>

    <!-- <ul transition:slide>
        <Link to="java">Java</Link>
        <Link to="javaScript">JavaScript</Link>
        <Link to="python">Pytnon</Link>
        <Link to="ubuntu">Ubuntu</Link>
        <Link to="markdown">Markdown</Link>
        <Link to="html5">Html5</Link>
        <Link to="css3">CSS3</Link>
        <Link to="about">About</Link>
    </ul> -->
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

#slide_menu {
  border: 1px solid blue;

  position:fixed;

  width: 20vw;
  top: 0px;
  right: 0;
  text-align: left;
  font-size: 1.22em;
  padding: 10px;
}
</style>