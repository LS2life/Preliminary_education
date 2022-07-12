<script>
    let name=""
    let yes=true
    let options=[
        {
            v:1,
            t:"Seoul"
        },
        {
            v:2,
            t:"Busan"
        },
        {
            v:3,
            t:"Jeju"
        },
    ]
    let selectedOption=1
</script>

<!-- 양뱡향 바인딩 -->
<input type="text" bind:value={name} />
<p>Hello {name}</p>

<label><input type="checkbox" bind:checked={yes} />체크박스테스트</label>

{#if yes}
    <p>Yes</p>
{:else}
    <p>No</p>
{/if}

<select bind:value={selectedOption}>
    {#each options as option}
        <option value={option.v}>{option.t}</option>
    {/each}
</select>

<p>Selected option is:{selectedOption}</p>