<script>
import {afterUpdate, beforeUpdate, onDestroy, onMount, tick} from "svelte"
onMount(()=>{
    console.log("onMount Called")
})
onDestroy(()=>{
    console.log("onDestroy Called")
})
beforeUpdate(()=>{
    console.log("beforeUpdate Called")
})
afterUpdate(()=>{
    console.log("afterUpdate Called")
})
let name="World"
function changeName(){
    name="Svelte"
    console.log("Name Changed")
}
async function changeNameAfter(){
    name="Aweasome Svelte"
    await tick()
    const h3=document.querySelector("h3")
    console.log("h1:",h3.textContent)
}
</script>

<button on:click="{changeNameAfter}">
    Change Name After
</button>

<h2>Lifecycle2</h2>

<h3>Hello {name}!</h3>
<button on:click="{changeName}">
    Change name
</button>