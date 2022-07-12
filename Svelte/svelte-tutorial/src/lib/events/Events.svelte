<script>
import { prevent_default } from "svelte/internal";

    let m={x:0,y:0}

    function handleMousemove(event){
        // console.log(event)
        m.x=event.clientX;
        m.y=event.clientY;
    }

    function handleClick(){
        alert("no more alers")
    }
</script>

<a href="svelte.dev" on:click|preventDefault>
    Svelte Homepage
</a>

<button disabled>
    Click me2
</button>

<button on:click|once="{handleClick}">
    Click me
</button>

<div on:mousemove="{e=>m={x:e.clientX,y:e.clientY}}">
    The mouse positon is {m.x} x {m.y}
</div>
<div on:mousemove="{handleMousemove}">
    The mouse positon is {m.x} x {m.y}
</div>

<h3>Events</h3>

<style>
    div{
        width: 100%;
        height: 500px;
        border: 1px solid black;
    }
</style>

