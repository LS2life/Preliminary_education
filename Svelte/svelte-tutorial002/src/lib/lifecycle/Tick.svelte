<script>
    import {tick} from "svelte"
    let text="Select some text and hit the tab key to toggle uppercase"

    async function handleKeydown(event){
        if(event.key !=="Tab") return
        event.preventDefault()

        const {selectionStart, selectionEnd, value}=this
        // console.log("this:",this)
        // console.log("this.value:",this.value)
        // console.log("SS:",this.selectionStart)
        // console.log("SE:",this.selectionEnd)
        const selection=value.slice(selectionStart,selectionEnd)

        const replacement=selection.toUpperCase()

        text=value.slice(0,selectionStart)+
            replacement+
            value.slice(selectionEnd)

        await tick()
		this.selectionStart = selectionStart
		this.selectionEnd = selectionEnd
    }
</script>

<style>
	textarea {
		width: 100%;
		height: 200px;
	}
</style>

<textarea value={text} on:keydown={handleKeydown}></textarea>