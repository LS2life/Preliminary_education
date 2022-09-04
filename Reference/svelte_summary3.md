# Svelte + Vite

## Tutorial

<br />

## Bindings :입력값의 실시간 반영

<hr>
<br />

> ## 1. Text inputs

-   일반적으로 Svelte의 데이터 흐름은 하향식입니다.
-   상위 구성 요소는 하위 구성 요소에 props를 설정할 수 있고 구성 요소는 요소에 속성을 설정할 수 있지만 그 반대는 아닙니다.
-   가끔은 그 규칙을 깨는 것이 유용합니다.
-   `<input>` 요소의 경우를 보자면 `name` 값을 event.target.value로 설정하는 on:input 이벤트 핸들러를 추가할 수 있지만 약간... 상용구입니다. 우리가 보게 되겠지만, 다른 양식 요소에서는 더욱 악화됩니다.

```javascript
<script>
	let name = 'world';
</script>

<input value={name}> --> <input bind:value={name}>

<h1>Hello {name}!</h1>
```

<br>

> ## 2. Numeric inputs

-   bind: 을 붙이면 끝

```javascript
<script>
	let a = 1끝
	let b = 2;
</script>

<label>
	<input type=number value={a} min=0 max=10>
	<input type=range value={a} min=0 max=10>
</label>
<p>{a} + {b} = {a + b}</p>

<style>
	label { display: flex }
	input, p { margin: 6px }
</style>
```

> ## 3. Checkbox inputs

```javascript
<script>
	let yes = false;
</script>

<label>
	<input type=checkbox bind:checked={yes}>
	Yes! Send me regular email spam
</label>

{#if yes}
	<p>Thank you. We will bombard your inbox and sell your personal details.</p>
{:else}
	<p>You must opt in to continue. If you're not paying, you're the product.</p>
{/if}

<button disabled={!yes}>
	Subscribe
</button>
```

<br>

> ## 4. Group inputs

```javascript
<script>
	let scoops = 1;
	let flavours = ['Mint choc chip'];

	let menu = [
		'Cookies and cream',
		'Mint choc chip',
		'Raspberry ripple'
	];

	function join(flavours) {
		if (flavours.length === 1) return flavours[0];
		return `${flavours.slice(0, -1).join(', ')} and ${flavours[flavours.length - 1]}`;
	}
</script>

<h2>Size</h2>

<label>
	<input type=radio bind:group={scoops} name="scoops" value={1}>
	One scoop
</label>

<label>
	<input type=radio bind:group={scoops} name="scoops" value={2}>
	Two scoops
</label>

<label>
	<input type=radio bind:group={scoops} name="scoops" value={3}>
	Three scoops
</label>

<h2>Flavours</h2>

{#each menu as flavour}
	<label>
		<input type=checkbox bind:group={flavours} name="flavours" value={flavour}>
		{flavour}
	</label>
{/each}

{#if flavours.length === 0}
	<p>Please select at least one flavour</p>
{:else if flavours.length > scoops}
	<p>Can't order more flavours than scoops!</p>
{:else}
	<p>
		You ordered {scoops} {scoops === 1 ? 'scoop' : 'scoops'}
		of {join(flavours)}
	</p>
{/if}
```

<br />

> ## 5. Textarea inputs

```html
<script>
    import { marked } from "marked";
    let value = `Some words are *italic*, some are **bold**`;
</script>

{@html marked(value)}

<textarea bind:value></textarea>

<style>
    textarea {
        width: 100%;
        height: 200px;
    }
</style>
```

> ## 6. File inputs

<br/>

> ## 7. Select bindings

-   비밀번호 찾기 힌트와 비슷.

```javascript
<script>
	let questions = [
		{ id: 1, text: `Where did you go to school?` },
		{ id: 2, text: `What is your mother's name?` },
		{ id: 3, text: `What is another personal fact that an attacker could easily find with Google?` }
	];

	let selected;

	let answer = '';

	function handleSubmit() {
		alert(`answered question ${selected.id} (${selected.text}) with "${answer}"`);
	}
</script>

<h2>Insecurity questions</h2>

<form on:submit|preventDefault={handleSubmit}>
	<select bind:value={selected} on:change="{() => answer = ''}">
		{#each questions as question}
			<option value={question}>
				{question.text}
			</option>
		{/each}
	</select>

	<input bind:value={answer}>

	<button disabled={!answer} type=submit>
		Submit
	</button>
</form>

<p>selected question {selected ? selected.id : '[waiting...]'}</p>

<style>
	input {
		display: block;
		width: 500px;
		max-width: 100%;
	}
</style>
```

> ## 8. Select multiple

-   다중선택

```javascript
<script>
	let scoops = 1;
	let flavours = ['Mint choc chip'];

	let menu = [
		'Cookies and cream',
		'Mint choc chip',
		'Raspberry ripple'
	];

	function join(flavours) {
		if (flavours.length === 1) return flavours[0];
		return `${flavours.slice(0, -1).join(', ')} and ${flavours[flavours.length - 1]}`;
	}
</script>

<h2>Size</h2>

<label>
	<input type=radio bind:group={scoops} value={1}>
	One scoop
</label>

<label>
	<input type=radio bind:group={scoops} value={2}>
	Two scoops
</label>

<label>
	<input type=radio bind:group={scoops} value={3}>
	Three scoops
</label>

<h2>Flavours</h2>

<select multiple bind:value={flavours}>
	{#each menu as flavour}
		<option value={flavour}>
			{flavour}
		</option>
	{/each}
</select>

{#if flavours.length === 0}
	<p>Please select at least one flavour</p>
{:else if flavours.length > scoops}
	<p>Can't order more flavours than scoops!</p>
{:else}
	<p>
		You ordered {scoops} {scoops === 1 ? 'scoop' : 'scoops'}
		of {join(flavours)}
	</p>
{/if}
```

-   즉석 콘텐츠 편집

```javascript
<script>
	let html = '<p>Write some text!</p>';
</script>

<div
	contenteditable="true"
	bind:innerHTML={html}
></div>

<pre>{html}</pre>

<style>
	[contenteditable] {
		padding: 0.5em;
		border: 1px solid #eee;
		border-radius: 4px;
	}
</style>
```

> ## 9. Each block bindings

-   블록의 속성 즉시 편집.

```javascript
<script>
	let todos = [
		{ done: false, text: 'finish Svelte tutorial' },
		{ done: false, text: 'build an app' },
		{ done: false, text: 'world domination' }
	];

	function add() {
		todos = todos.concat({ done: false, text: '' });
	}

	function clear() {
		todos = todos.filter(t => !t.done);
	}

	$: remaining = todos.filter(t => !t.done).length;
</script>

<h1>Todos</h1>

{#each todos as todo}
	<div class:done={todo.done}>
		<input
			type=checkbox
			bind:checked={todo.done}
		>

		<input
			placeholder="What needs to be done?"
			bind:value={todo.text}
		>
	</div>
{/each}

<p>{remaining} remaining</p>

<button on:click={add}>
	Add new
</button>

<button on:click={clear}>
	Clear completed
</button>

<style>
	.done {
		opacity: 0.4;
	}
</style>
```

> ## 10. Media elements

<br/>

> ## 11. Dimensions

-   텍스트 및 지정한 요소의 크기 변경.

```javascript
<script>
	let w;
	let h;
	let size = 42;
	let text = 'edit me';
</script>

<input type=range bind:value={size}>
<input bind:value={text}>

<p>size: {w}px x {h}px</p>

<div bind:clientWidth={w} bind:clientHeight={h}>
	<span style="font-size: {size}px">{text}</span>
</div>

<style>
	input { display: block; }
	div { display: inline-block; }
	span { word-break: break-all; }
</style>
```

> ## 12. bind:this={canvas}

```javascript
<script>
	import { onMount } from 'svelte';

	let canvas;

	onMount(() => {
		const ctx = canvas.getContext('2d');
		let frame = requestAnimationFrame(loop);

		function loop(t) {
			frame = requestAnimationFrame(loop);

			const imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);

			for (let p = 0; p < imageData.data.length; p += 4) {
				const i = p / 4;
				const x = i % canvas.width;
				const y = i / canvas.width >>> 0;

				const r = 64 + (128 * x / canvas.width) + (64 * Math.sin(t / 1000));
				const g = 64 + (128 * y / canvas.height) + (64 * Math.cos(t / 1000));
				const b = 128;

				imageData.data[p + 0] = r;
				imageData.data[p + 1] = g;
				imageData.data[p + 2] = b;
				imageData.data[p + 3] = 255;
			}

			ctx.putImageData(imageData, 0, 0);
		}

		return () => {
			cancelAnimationFrame(frame);
		};
	});
</script>

<canvas
	bind:this={canvas}
	width={32}
	height={32}
></canvas>

<style>
	canvas {
		width: 100%;
		height: 100%;
		background-color: #666;
		-webkit-mask: url(/svelte-logo-mask.svg) 50% 50% no-repeat;
		mask: url(/svelte-logo-mask.svg) 50% 50% no-repeat;
	}
</style>
```

> ## 13. Component bindings
