<script>
import Utils from "./Utils.svelte"

let open=true
let seconds=0
const toggle=()=>(open=!open)
const handleTick=()=>{seconds+=1}
</script>
<h1>Timer</h1>
<button on:click="{toggle}">
{open?"Close":"Open"} Timer
</button>
<p>
    The Timer component has been open for 
    {seconds} {seconds===1?"second":"seconds"}
</p>
{#if open}
<Utils callback={handleTick}/>
{/if}