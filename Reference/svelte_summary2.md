# Svelte + Vite

## Tutorial

<hr>

## props

> ## 1. props 선언

-   props = properties(속성)
-   다른파일과 연결, 교류, 다른파일의 결과값을 가지고온다.  
    `App.svelte` -> `Nested.svelte`
-   Nested.svelte 파일에서 answer 값이 필요하다

```javascript
<script>
	export let answer='a mystery';
</script>

<p>The answer is {answer}</p>
```

-   App.svelte파일에 Nested 파일을 가져와서 answer값만 되돌려 줌.

```javascript
<script>
import Nested from './Nested.svelte';
</script>

<Nested answer={42}/>
<Nested/>
```

-   기본값은 특별한 answer값이 없을때 출력된다.

<br/>
<hr>

> ## 2. spread props

-   패키지로 모아서 한번에 뿌릴 수 있음.
-   `info.svelte` 파일이 내용을 보여주는 페이지 일때,

```javascript
<script>
	export let name;
	export let version;
	export let speed;
	export let website;
</script>

<p>
	The <code>{name}</code> package is {speed} fast.
	Download version {version}
    from <a href="https://www.npmjs.com/package/{name}">npm</a>
	and <a href={website}>learn more here</a>
</p>
```

-   `App.svelte` 에서 info에 필요한 변수들 name, version 등을 패키지로 만듦.
-   원래라면 info로 보내는 태그에 변수들을 모두 지정해야하지만 그냥 패키지로 보내기 가능.  
    ~~`<Info name={pkg.name} version={pkg.version} speed={pkg.speed} website={pkg.website}/>`~~

```javascript
<script>
	import Info from './Info.svelte';

	const pkg = {
		name: 'svelte',
		version: 3,
		speed: 'blazing',
		website: 'https://svelte.dev'
	};
</script>

<Info {...pkg}/>
```

<br/>
<hr>

## Logic (논리)

> ## 1. if block

-   조건부여 가능 {~일때, ~아닐때} 처럼.
-   이게 뭔코드야??

```javascript
<script>
	let user = { loggedIn: false };

	function toggle() {
		user.loggedIn = !user.loggedIn;
	}
</script>

<button on:click={toggle}>
	Log out
</button>

<button on:click={toggle}>
	Log in
</button>
```

-   아무튼 조건에 따라 하나의 상태로 사용가능.
-   #은 블록의 시작을 선언,  
    :은 블록의 연속을 ,
    /은 블록의 종료를 선언한다.

```javascript
<script>
	let user = { loggedIn: false };

	function toggle() {
		user.loggedIn = !user.loggedIn;
	}
</script>

{#if user.loggedIn}
	<button on:click={toggle}>
		Log out
	</button>
{:else}
	<button on:click={toggle}>
		Log in
	</button>
{/if}
```

-   이걸로 else if 구문을 만들 수 있다.

```javascript
<script>
	let x = 7;
</script>

{#if x > 10}
	<p>{x} is greater than 10</p>
{:else if 5 > x}
	<p>{x} is less than 5</p>
{:else}
	<p>{x} is between 5 and 10</p>
{/if}
```

<br>

> ## 3. each block

-   each는 각각의 라는 뜻.
-   cach문 안의 내용을 반복

```javascript
<script>
	let cats = [
		{ id: 'J---aiyznGQ', name: 'Keyboard Cat' },
		{ id: 'z_AbfPXTKms', name: 'Maru' },
		{ id: 'OUtn3pvWmpg', name: 'Henri The Existential Cat' }
	];
</script>

<h1>The Famous Cats of YouTube</h1>

<ul>
	{#each cats as { id, name }, i}
		<li>
            <a target="_blank" href="https://www.youtube.com/watch?v={id}">
                {i + 1}: {name}
            </a>
        </li>
	{/each}
</ul>
```

<br>

> ## 4. 키값을 각 블록에 입력시키기

-   값이 들어올때 까지 대기  
    `{#await promise}`  
    `{:then number}`  
    `{:catch error}`  
    `{/await}`

```javascript
<script>
	async function getRandomNumber() {
		const res = await fetch(`/tutorial/random-number`);
		const text = await res.text();

		if (res.ok) {
			return text;
		} else {
			throw new Error(text);
		}
	}

	let promise = getRandomNumber();

	function handleClick() {
		promise = getRandomNumber();
	}
</script>

<button on:click={handleClick}>
	generate random number
</button>

{#await promise}
	<p>...waiting</p>
{:then number}
	<p>The number is {number}</p>
{:catch error}
	<p style="color: red">{error.message}</p>
{/await}
```

<br>

> ## 5. DOM 이벤트

-   on: 을 사용하여 이벤트 생성 가능.
-   mousemove는 마우스 포인터위치 반환.

```javascript
<script>
	let m = { x: 0, y: 0 };

	function handleMousemove(event) {
		m.x = event.clientX;
		m.y = event.clientY;
	}
</script>

<div on:mousemove={handleMousemove}>
	The mouse position is {m.x} x {m.y}
</div>

<style>
	div { width: 100%; height: 100%; }
</style>
```

-   function값을 인라인으로 바로 사용가능.

```javascript
<script>
	let m = { x: 0, y: 0 };

	function handleMousemove(event) {
		m.x = event.clientX;
		m.y = event.clientY;
	}
</script>

<div on:mousemove={handleMousemove}>
	The mouse position is {m.x} x {m.y}
</div>

<style>
	div { width: 100%; height: 100%; }
</style>
```

<br>

> ## 6. 기능 수정

-   실행 기능을 약간 수정할 수있다.
-   기능 뒤에 | 파이프를 넣고 수정 기능을 넣으면 된다.
-   |기능|기능|기능 처럼 기능을 이어붙일 수 있다.

```javascript
<button on:click|once={handleClick}>
	Click me
</button>
```

-   수정 목록 - preventDefault 동작실행 방지. - stopPropagation 부모태그로 이벤트 전파 방지. - passive 터치|휠 이벤트의 퍼포먼스 향상. - nopassive passive를 false로 셋팅. - capture 이벤트 캡쳐 - once 이벤트를 한번만 호출 - self - trusted
    <br>

> ## 7. component events??

<br>

> ## 8. event forwarding(이벤트 전달)

-   `App.svelte` -> `Inner.svelte`
-   버튼이벤트를 전달하고자 한다면

```javascript
<button>
Click me
</button>

<button on:click>
Click me
</button>
```

<br>
