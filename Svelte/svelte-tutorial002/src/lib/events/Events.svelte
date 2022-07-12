<script>
import Inner from "./Inner.svelte"

let m={x:0,y:0}

function handleMousemove(event){
    m.x=event.clientX
    m.y=event.clientY
}
function handleClick(){
    alert("no more alerts")
}
function handleMessage(event){
    alert(event.detail.text)
}

function currentTarget(e) {
    console.log(e.currentTarget);
}
</script>

<a href="https://hdevstudy.tistory.com" target="_blank" on:click|preventDefault={currentTarget}>
    HoYa's Tistory Blog
</a>

<button on:click|stopPropagation={handleClick}>
    Don't Click Me
</button>

<Inner on:message={handleMessage}/>

<button on:click|once={handleClick}>
    Click Me
</button>

<div on:mousemove="{e=>m={x:e.clientX,y:e.clientY}}">
    The mouse position is {m.x}x{m.y}
</div>

<div on:mousemove="{handleMousemove}">
    The mouse position is {m.x}x{m.y}
</div>

<h1>Events</h1>

<style>
    div {
        border: 1px solid black;
        width: 400px;
        height: 300px;
    }
</style>