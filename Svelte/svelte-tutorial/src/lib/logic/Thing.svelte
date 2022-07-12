<script>
    const emojis={
        //윈도우키+.->이모티콘
        apple:"🍎",
        banana:"🍌",
        carrot:"🥕",
        doughnut:"🍩",
        egg:"🥚"
    }
    export let name
    const emoji=emojis[name]
</script>

<p>
    <span>The emoji for {name} is {emoji}</span>
</p>

<style>
    p {
		margin: 0.8em 0;
	}
	span {
		display: inline-block;
		padding: 0.2em 1em 0.3em;
		text-align: center;
		border-radius: 0.2em;
		background-color: #a6f09c;
	}
</style>