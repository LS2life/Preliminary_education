<script>
    import {onDestroy, onMount, beforeUpdate, afterUpdate} from "svelte"
    //async()비동기 함수
    
    let name="Something..002"
    let something1

    function moreDot(){
        name+="."
    }
    
    onMount(()=>{
        console.log("Mounted!")
        // const something=document.getElementById("something")
        // console.log(something.innerText)
        something1=document.getElementById("something")
        return ()=>{
            console.log("Destroy in mount")
        }
    })
    onDestroy(()=>{
        console.log("Before Destroy!")
        const something=document.getElementById("something")
        console.log(something.innerText)
    })

    beforeUpdate(()=>{
        console.log("Before update!")
        console.log(something1&&something1.innerText)
    })
    
    afterUpdate(()=>{
        console.log("After update!")
        console.log(something1&&something1.innerText)
    })
    /* 
        비포,애프터 함수 내에 바인딩 코드을 삽입하면
        무한루프에 빠질수 있다
    */
</script>
<!-- 
    <h2 id="something">Something002</h2>
-->
<h2 id="something" on:click={moreDot}>{name}</h2>
