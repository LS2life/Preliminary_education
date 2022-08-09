# Svelte + Vite

## Homepage

`https://svelte.dev/`

<br />

## svelte project 생성

```console
npm create vite@latest my-app -- --template svelte
cd my-app
npm install
npm run dev
```
<br />

## Routing 설치

```console
$ npm install --save svelte-routing
```
<br />

## index.html

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Vite + Svelte</title>
  </head>

  <body>
    <!-- 바디 태그 내 div id에 app 추가 -->
    <div id="app"></div>
    <script type="module" src="/src/main.js"></script>
  </body>
</html>
```
<br />

## main.js

```javascript
// css 임포트
import './app.css'
// App 을 main에 삽입
import App from './App.svelte'

// target: document~ 추가
const app = new App({ target: document.getElementById('app') })

export default app
```
<br />

# App.svelte

```javascript
<script>
    <!-- routing 삽입 -->
	import { Router, Link, Route } from "svelte-routing"
    <!-- 홈으로 사용할 페이지 임포트 -->
	import Home from "./Test/Routes/Home.svelte";
    <!-- About  페이지 임포트 -->
	import About from "./Test/Routes/About.svelte";
	
	export let url = "";
</script>

<Router url="{url}">
	<nav>
		<Link to="/">Home</Link>
		<Link to="about">About</Link>
	</nav>
	<div>
		<Route path="/"><Home /></Route>
		<Route path="about" component={About}/>
	</div>
</Router>

<style>

</style>
```