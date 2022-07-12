<script>
    let name="World"
    let a = 1;
	let b = 2;
    let numbers = [
		'own',
		'two',
		'three'
	]
	
	let getNumbers = []
	let html = '<p>Write some text!</p>'
</script>

<div
	contenteditable="true"
	bind:innerHTML="{html}"
	>
</div>
<div
	contenteditable="true"
	bind:textContent="{html}"
	>
</div>
<pre>{html}</pre>

<style>
	[contenteditable]{
		padding: 0.5em;
		border: 1px solid #eee;
		border-radius: 4px;
	}
</style>

<select multiple bind:value={getNumbers}>
	{#each numbers as number}
		<option value={number}>
			{number}
		</option>
	{/each}
</select>

<p>{getNumbers}</p>

<div>
	<input type=number bind:value={a} min=0 max=10>
	<input type=range bind:value={a} min=0 max=10>
</div>

<div>
	<input type=number bind:value={b} min=0 max=10>
	<input type=range bind:value={b} min=0 max=10>
</div>

<p>{a} + {b} = {a + b}</p>

<input bind:value={name}>
<h1>Hello {name}!</h1>

