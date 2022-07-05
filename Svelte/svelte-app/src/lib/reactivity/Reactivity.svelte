<script >
	let name = "Worla"
	function changeName(){
		name="Svelte"
	}

</script >

<button on:click={changeName}Change Name></button>
<h1>Hello {name}!</h1>
<h1>Reactivity</h1>