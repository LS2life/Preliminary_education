<script>
  import {Router,Link,Route} from "svelte-routing";
  import Home from "./routes/Home.svelte";
  import About from "./routes/About.svelte";

  export let url="";
</script>

<h1>Hello Svelte</h1>

<Router url={url}>
  <nav>
    <Link to="/">Home</Link>
    <Link to="about">About</Link>
  </nav>
  <div>
    <Route path="/"><Home/></Route>
    <Route path="about" component={About}></Route>
  </div>
</Router>


<style>

</style>
