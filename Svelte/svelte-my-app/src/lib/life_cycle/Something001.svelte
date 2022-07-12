<script>
    import Something002 from "./Something002.svelte";

    let toggle=false
</script>
<h1>
    Something001
</h1>
<button on:click={()=>toggle=!toggle}>
    Toggle
</button>
{#if toggle}
    <Something002/>
{/if}