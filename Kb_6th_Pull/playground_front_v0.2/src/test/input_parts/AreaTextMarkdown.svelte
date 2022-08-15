<script>
	import { marked } from 'marked';
    import { text } from 'svelte/internal';
    let text = `markdowm 형식 `

</script>

<p> {text} </p>
<textarea bind:value={text} placeholder="enter text"></textarea>

<style>
    textarea { width: 100%; height: 200px;}
</style>