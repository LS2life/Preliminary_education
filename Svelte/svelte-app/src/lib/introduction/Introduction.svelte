<script>
    //data binding
    //document.getElementById("greeting").innerText="Hello Svelte"
    let name="world"
    //속성 데이터 바인딩
    //FTP workspace/svelte-tutorial/src/assets/image.gif
    //스벨트 프로젝트/src/assets/image.gif 복사
    import src from "../../assets/image.gif"
	import Nested from "./Nested.svelte"
    // console.log(src)
    let danceManName="Rick Astley"
	//컴포넌트 코드가 html 변환 렌더링(Rendering)
	//introduction/Nested svelte
	let string=`this string contains some <strong>HTML!!!</strong>`
</script>

<p>{@html string}</p>

<h1>Introduction</h1>
<h1>Hello {name.toUpperCase()}!</h1>
<img src={src} alt="{danceManName} dances."/>

<p>This is a paragraph.</p>
<Nested></Nested>