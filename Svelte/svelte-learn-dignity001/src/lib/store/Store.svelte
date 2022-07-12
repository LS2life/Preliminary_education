<script>
    import {setContext} from "svelte"
    import StoreSub from "./StoreSub.svelte"

    setContext("name2","Svelte")

    /* 
        writable store - 쓰기가 가능한 스토어
        readable store - 읽기
        derived store - 기존 스토어를 가지고 새로운 스토어를 생성
    */

    import {writable} from "svelte/store"
    import StoreWithJs from "./StoreWithJs.svelte"
   const count=writable(0)
   const updateCount=()=>{
       count.update(n=>n+1)
   }
   count.subscribe(v=>{
    console.log(v)
   })
//    count.set(1)

   let active=true
   const isActive=()=>{
    active=!active
   }
</script>

<h1>Store</h1>

<button type="button" on:click={updateCount}>Counts: {$count}</button>

<StoreSub/>
<button on:click={isActive}>Toggle StoreWithJs</button>
{#if active}
<StoreWithJs/>
{/if}