<script>
// @ts-nocheck

    import { Router, Link, Route } from "svelte-routing";
    import Java from "../routes/Language_Java.svelte";
    import JavaScript from "../routes/Language_JavaScript.svelte"
    import About from "../routes/About.svelte";

    export let url = "";
</script>

<Router {url}>
    <div>
        <Route path="java" component={Java}/>
        <Route path="javaScript" component={JavaScript}/>
        <Route path="about" component={About}/>
    </div>
    <nav>
        <Link to="java">Java</Link>
        <Link to="javaScript">JavaScript</Link>
        <Link to="about">About</Link>
    </nav>
</Router>
