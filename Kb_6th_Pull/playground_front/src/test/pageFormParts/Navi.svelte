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

<label>
    <input type="checkbox" bind:checked={visible}>
    visible
</label>

{#if visible}
<Router {url}>
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
<ul transition:slide>
    <li> <Link to="java">Java</Link> </li>
    <li> <Link to="javaScript">JavaScript</Link> </li>
    <li> <Link to="python">Pytnon</Link> </li>
    <li> <Link to="ubuntu">Ubuntu</Link> </li>
    <li> <Link to="markdown">Markdown</Link> </li>
    <li> <Link to="html5">Html5</Link> </li>
    <li> <Link to="css3">CSS3</Link> </li>
    <li> <Link to="about">About</Link> </li>
</ul>
</Router>

{/if}
<!-- <Router {url}>
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
    <nav class="navbar navbar-light navbar-expand-lg" style="background-color:#ffc6b3">
        <div class="container">
            <a class="navbar-brand" href="/">
                <img src="#" alt="Svelte Icon" height="30px">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <Link class="navbar-nav active"aria-current="page" to="java">Java</Link>
                    <Link class="navbar-nav" to="javaScript">JavaScript</Link>
                    <Link class="navbar-nav" to="python">Pytnon</Link>
                    <Link class="navbar-nav" to="ubuntu">Ubuntu</Link>
                    <Link class="navbar-nav" to="markdown">Markdown</Link>
                    <Link class="navbar-nav" to="html5">Html5</Link>
                    <Link class="navbar-nav" to="about">About</Link>
                </ul>
            </div>
        </div>
    </nav>
</Router> -->