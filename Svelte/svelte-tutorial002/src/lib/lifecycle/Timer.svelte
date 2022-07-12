<script>
  import {onDestroy} from "svelte"
	export let callback;
	export let interval = 1000;

    const intervalFunc = setInterval(callback, interval);

    onDestroy(() => {
        console.log("onDestroy called")
        clearInterval(intervalFunc);
    });
</script>

<p>
	This component executes a callback every
	{interval} millisecond{interval === 1 ? '' : 's'}
</p>

<style>
	p {
		border: 1px solid blue;
		padding: 5px;
	}
</style>
