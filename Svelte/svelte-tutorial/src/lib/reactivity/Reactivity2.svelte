<script>
//$: reactive 반응성
let count=0
function handleClick(){
    count +=1
}
// $: console.log("the count is "+count)
// $:{
//     console.log("the count is "+count)
//     alert("I SAID THE COUNT IS "+count)
// }
$:if(count>=10){
    alert("count is dangerously high!")
    count=9
}
let numbers=[1,2,3,4]
//join<->split
$: sum=numbers.reduce((t,n)=>t+n,0)
//0+1=1->t=1, 1+2=3=>t=3
function addNumber(){
    numbers=[...numbers,numbers.length+1]
    // numbers.push(numbers.length+1)
}
</script>
<p>{numbers.join(" + ")} = {sum}</p>
<button on:click={addNumber}>
    Add a number
</button>

<button on:click={handleClick}>
    Clicked {count} {count===1?"time":"times"}
</button>

<h1>Reactivity2</h1>