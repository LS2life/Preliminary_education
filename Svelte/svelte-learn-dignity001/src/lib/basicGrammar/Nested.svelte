<script>
    export let name
    /* 조건 렌더링 */
    let count = 0
    const increment = () => {
        count += 1
    }
    let arrData=[
        {name:"name1",city:"city1"},
        {name:"name2",city:"city2"},
        {name:"name3",city:"city3"},
    ]
</script>
<div>
    <h1 class="display-1">Nested Component</h1>
    <h1 class="display-2">{name}</h1>
    <input 
    type="button" 
    value="Clicks1: {count}"
    on:click="{increment}"
    />
    {#if count>3}
    <h1>3보다 큽니다</h1>
    {:else}
    <h1>3보다 작습니다</h1>
    {/if}
    
    <table>
        {#each arrData as {name,city},i}
        <tr>
            <td>{i}</td>
            <td>{name}</td>
            <td>{city}</td>
        </tr>
        {/each}
    </table>
</div>
<style>
    table{
        margin-left:auto;
        margin-right:auto;
    }
</style>