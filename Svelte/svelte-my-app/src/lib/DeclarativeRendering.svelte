<script>
    /* 
        ; 생략 가능
        선언적 렌더링 {} 
    */
    let name="World!"
    let age=85
    /* 
        반응성: 데이터가 갱신되면 화면이 갱신(리액티비티)
        데이터에 새로운 값이 할당되면 반응성이 발동
    */
    // setTimeout(()=>{
    //     name="Svelte"
    //     age=36
    // },3000)
    function assign(){
        name="Svelte!"
        age=36
    }
</script>

<h1>DeclarativeRendering</h1>
<h1>Hello {name}</h1>
<!-- <h2 class="active"> -->
<h2 class={age<85?"active":""}>
    {age}
</h2>
<div>
    <!-- "" 생략 가능 -->
    <img src="" alt="{name}" />
</div>
<!-- 단방향 바인딩 -->
<input type="text" value={name} />
<!-- 양방향 바인딩 -->
<input type="text" bind:value={name} />
<button on:click={assign}>
    Assign
</button>

<!-- 
    style 가능
    다른 파일에는 영향 없음
-->
<style>
    h1 {
        color:red;
    }
    .active{
        color:blue;
    }
</style>