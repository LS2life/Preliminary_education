<script>
    import { Router, Link, Route } from "svelte-routing";
    import Java from "../view/main_nav_codename/Language_Java.svelte"
    import JavaScript from "../view/main_nav_codename/Language_JavaScript.svelte"
    import Python from "../view/main_nav_codename/Language_Python.svelte"
    import Ubuntu from "../view/main_nav_codename/Linux_Ubuntu.svelte"
    import Markdown from "../view/main_nav_codename/Markdown_md.svelte"
    import Html5 from "../view/main_nav_codename/Markup_Html.svelte"
    import CSS3 from "../view/main_nav_codename/Stylesheet_css.svelte"
    import About from "../view/main_nav_codename/About.svelte";
    import ATM from "../input_parts/AreaTextMarkdown.svelte"

    export let url="";
</script>


<section>
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

</Router>

</section>



<style>
    section{
        border: 3px solid pink;
    }
</style>