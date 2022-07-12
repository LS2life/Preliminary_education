<script>
    import { onDestroy } from "svelte";
    import {count} from "./store.js"

    const updateCount=()=>{
        count.update(n=>n+1)
    }

    const unsubscribe=count.subscribe(v=>{
        console.log(v)
    })

    onDestroy(unsubscribe)
</script>
<h2>Store With Js</h2>
<button on:click={updateCount}>Click</button>
<p>count: {$count}</p>