<script>
    import { onDestroy } from "svelte";
    import Decrementer from "./Decrementer.svelte"
    import Incrementer from "./Incrementer.svelte"
    import Resetter from "./Resetter.svelte"
    import {count,elapsed,greeting,time,name} from "./stores.js"
    
    // let countValue
    
    // const unsubscribe=count.subscribe(value=>{
    //     countValue=value
    // })
    // onDestroy(unsubscribe)
    const formatter=new Intl.DateTimeFormat("ko",{
        hour12:true,
        hour:"numeric",
        minute:"2-digit",
        second:"2-digit"
    })
</script>

<h1>{$greeting}</h1>
<input bind:value={$name}>
<button on:click="{()=>$name+='!'}">
    Add exclamation mark!
</button>

<h1>The time is {formatter.format($time)}</h1>
<p>
    This page has been open for {$elapsed}
</p>

<h1>The count is {$count}</h1>
<Incrementer/>
<Decrementer/>
<Resetter/>