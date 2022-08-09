# Svelte + Vite

## Tutorial

## 기본

## 1. 

- world를 name으로 변수 선언, h1 tag 의 world를  Curly Brackets로 변경.
- .toUPperCase() = 소문자 -> 대문자
- App.svelte

```javascript
<script>
    let name = 'world';
</script>
<h1>Hello world!</h1>  
<h1>Hello {name}!</h1>  
<h1>Hello {name.toUPperCase()}!</h1>  
```
<br>

## 2.

- src={src} 부분을 {src}로 약칭 사용가능. 

```javascript
<script>
    let src = '/tutorial/image.gif';
    let name = 'rick Astley';
</script>

<img src={src} alt="strange Image" />
<img {src} alt="{name} Image>
```
<br>

## 3.

- style Tag내 p element의 style 추가

```javascript
<p>This is a paragraph.</p>
<style>
	p {
		color: purple;
		font-family: 'Comic Sans MS', cursive;
		font-size: 2em;
	}
</style>
```
<br>

## 4.

- 다른 파일의 구성요소 가져오기

`Nested.svelte` -> `App.svelte`

- script Tag 내 import 선언

```javascript
<script>
	import Nested from './Nested.svelte';
</script>
```

- Tag로 불러 옮김. 첫글자 대문자와 Slash 주의.
`<Nested/>`


```javascript
<script>
    import Nested from './Nested.svelte';
</script>
<p>This is a paragraph.</p>
<Nested/>

<style>
	p {
		color: purple;
		font-family: 'Comic Sans MS', cursive;
		font-size: 2em;
	}
</style>
```
<br>

## 5.

- 변수 출력시 렌더링을 먼저 해서 내보도록 하는 태그

```javascript
<script>
	let string = `this string contains some <strong>HTML!!!</strong>`;
</script>

<p>{string}</p>
<p>{@html string}</p>
```
<br>

## 반응성

## 1. 할당

- 동적 버튼 이벤트 시스템

```javascript
<script>
	let count = 0;

	function incrementCount() {
		// event handler code goes here
	}
</script>

<button>
	Clicked {count} {count === 1 ? 'time' : 'times'}
</button>
```

- 버튼 클릭시 카운트 변경 요소 삽입.  
```javascript
<script>
	let count = 0;

	function incrementCount() {
        count += 1;
	}
</script>

<button on:click={incrementCount}>
	Clicked {count} {count === 1 ? 'time' : 'times'}
</button>
```
<br>

## 2. 선언

- 반응성 선언의 변수를 동기화.
- $: 를 사용하여 count 에 직접 반응하는 count * 2를 doubled라는 변수에 넣을 수 있습니다.
- 다른위치에서 {doubled}로 선언 가능.

```javascript
<script>
	let count = 0;
	$: doubled = count * 2;

	function handleClick() {
		count += 1;
	}
</script>

<button on:click={handleClick}>
	Clicked {count} {count === 1 ? 'time' : 'times'}
</button>

<p>{count} doubled is {doubled}</p>
```
<br>

## 3. 상태

- script내부에  
`$: console.log('the count is ' + count);`  
이딴걸 쓰면 카운트가 올라갈때마다 팝업창이 뜬다.
- 그룹으로 묶어서 사용할 수 도 있다.

```javascript
$: {
	console.log('the count is ' + count);
	alert('I SAID THE COUNT IS ' + count);
}
```

- 특정 값에서 만 팝업창이 뜨도록 할 수 도 있다. 

```javascript
$: if (count >= 10) {
	alert('count is dangerously high!');
	count = 9;
}
```
<br>

## 4. 배열 및 객체 업데이트

- 팩토리얼값 만들기

```javascript
function addNumber() {
	numbers.push(numbers.length + 1);
	numbers = numbers;
}
```

- 위 값을 아래처럼 간결하게 작성할 수 있다.

```javascript
function addNumber() {
	numbers = [...numbers, numbers.length + 1];
}
```
