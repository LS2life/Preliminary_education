<script>
    let name="World"
    function changeName(){
        name="Svelte"
    }

    let count=0
    function incrementCount(){
        count=count+1
    }
    //watch, computed
    $: doubled=count*2
    //랜더링되는 기준 데이터 바인딩 된 식별자에 새로운 값이 대입
</script>
<div>
    <p>{count} doubled is {doubled}</p>
    <button on:click={incrementCount}>
        <!--
            times count>1 
            time count===1
        -->
        Clicked {count} {count===1?"time":"times"}
    </button>
</div>

<button on:click={changeName}>Change Name</button>

<h1>Hello {name}!</h1>
<h1>Reactivity</h1>