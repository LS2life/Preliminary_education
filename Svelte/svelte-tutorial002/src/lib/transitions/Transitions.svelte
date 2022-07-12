<script>
import { fade,fly } from 'svelte/transition'
let visible=true
let status="waiting..."
</script>

<label>
    <input type="checkbox" bind:checked="{visible}">
    visible
</label>
<p>status:{status}</p>
{#if visible}
    <p 
        transition:fly={{y:200,duration:2000}}
        on:introstart="{()=>status='intro started'}"
        on:outrostart="{()=>status='outro started'}"
        on:introend="{()=>status='intro ended'}"
        on:outroend="{()=>status='outro ended'}"
    >
        Flies in and out
    </p>
{/if}

{#if visible}
<p in:fly={{y:200,duration:2000}} out:fade>
    Flies in and out
</p>
{/if}

{#if visible}
<p transition:fly={{x:300,y:200,duration:2000}}>
    Flies in and out
</p>
{/if}

{#if visible}
<p transition:fade>
    Fades in and out
</p>
{/if}
