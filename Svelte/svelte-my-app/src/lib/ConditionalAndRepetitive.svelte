<script>
    let name="world"
    /* 조건문 */
    let toggle=false
    if(toggle){

    }else{

    }
    /* 
        #시작 /끝내기 :중간
    */
   /* 반복문 */
   let fruits=["Apple","Banana","Cherry","Orange","Mango"]
   function deleteFruit(){
    fruits.pop()
    fruits=fruits
   }
</script>

<h1>ConditionalAndRepetitive</h1>
{#if toggle}
    <h1>Hello {name}!</h1>
{:else}
    <div>No name!</div>
{/if}
<button on:click={()=>{
    toggle=!toggle
    }}>
    Toggle
</button>

<ul>
    {#each fruits as fruit}
        <li>{fruit}</li>
    {/each}
</ul>
<button on:click={deleteFruit}>
    Eat it!
</button>