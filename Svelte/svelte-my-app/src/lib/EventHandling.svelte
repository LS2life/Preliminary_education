<script>
    // import {onMount} from "svelte"
    let isRed=false
    // onMount(()=>{
    //     const box=document.querySelector(".box")
    //     box.addEventListener("click",()=>{
    //         isRed=!isRed
    //     })
    // })
    let name="World";
    function enter(){
        name="Enter"
    }
    function leave(){
        name="Leave"
    }
    let text=""
</script>

<h1>EventHandling</h1>
<h2>Hello {name}!</h2>
<div 
    class="{isRed?'rBox':'oBox'}"
    on:click={()=>{
        isRed=!isRed
    }}
    on:mouseenter={()=>{
        // name="Enter"
        enter()
    }}
    on:mouseleave={()=>{
        name="Leave"
    }}
>
    Box!
</div>
<h2>{text}</h2>
<input 
    type="text" 
    bind:value={text}
    on:input={(e)=>{text=e.target.value}}
/>
<input 
    type="text"
    bind:value={text}
/>
<button on:click={()=>{text="Svelte"}}>
    Click
</button>

<style>
    .oBox{
        width:300px;
        height: 150px;
        background-color: orange;
    }
    .rBox{
        width:300px;
        height: 150px;
        background-color: red;
    }
</style>