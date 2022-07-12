<script>
    import src from "../../assets/image.gif"
    import Nested from "./Nested.svelte"

    let name="world"
    // import Nested from "./Nested.svelte";
    let dancerName="Rick Astley"
    let string=`this string contains some <strong>HTML!!!</strong>`
    
    let count=0
    function incrementCount(){
        count+=1
    }
</script>

<button on:click={incrementCount}>
    Clicked {count} {count<=1?"time":"times"}
</button>

<p>{@html string}</p>

<!-- <h1>Hello World!</h1> -->
<h1>Hello {name.toUpperCase()}!</h1>
<!-- <img src={src} alt="A man dances."/> -->
<img {src} alt="{dancerName} dances."/>

<p>This is a paragraph.</p>
<Nested/>

<style>
    p{
        color:purple;
        font-family:"Comic sans MS",cursive;
        font-size: 2em;
    }
</style>
