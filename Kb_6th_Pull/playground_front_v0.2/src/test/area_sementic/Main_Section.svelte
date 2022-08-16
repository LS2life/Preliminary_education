<script>
    import { Router, Link, Route } from "svelte-routing";
    import Java from "../routes/Language_Java.svelte"
    import JavaScript from "../routes/Language_JavaScript.svelte"
    import Python from "../routes/Language_Python.svelte"
    import Ubuntu from "../routes/Linux_Ubuntu.svelte"
    import Markdown from "../routes/Markdown_md.svelte"
    import Html5 from "../routes/Markup_Html.svelte"
    import CSS3 from "../routes/Stylesheet_css.svelte"
    import About from "../routes/About.svelte";
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