<script>
let user={
    loggedIn:false
}
function toggle(){
    user.loggedIn=!user.loggedIn
    console.log(user.loggedIn)
}
let x=6

let cats=[
    {id:"J---aiyznGQ",name:"Keyboard Cat"},
    {id:"X-b4CgGmhuA",name:"Maru"},
    {id:"wx5Of3X-VJw",name:"Henri The Existential Cat"},
]
</script>
<h1>The Famous Cats of YouTube</h1>
<ul>
    <!-- loop -->
    {#each cats as {id,name},i}
        <li>
            <a 
            target="_blank" 
            href="https://www.youtube.com/watch?v={id}"
            >
            {i+1}: {name}
            </a>
        </li>
    {/each}
</ul>
<ul>
    <!-- loop -->
    {#each cats as cat}
        <li>
            <a 
            target="_blank" 
            href="https://www.youtube.com/watch?v={cat.id}"
            >
            {cat.name}
            </a>
        </li>
    {/each}
</ul>

<!-- #,:,/ -->
{#if x>10}
<p>{x} is greater than 10</p>
{:else if 5>x}
<p>{x} is less than 5</p>
{:else}
<p>{x} is between 5 and 10</p>
{/if}


{#if user.loggedIn}
<button on:click="{toggle}">
    Log out
</button>
{:else}
<button on:click="{toggle}">
    Log in
</button>
{/if}

{#if !user.loggedIn}
<button on:click="{toggle}">
    Log in
</button>
{/if}
{#if user.loggedIn}
<button on:click="{toggle}">
    Log out
</button>
{/if}
<!-- 
    {#if 조건}
    {/if}
-->



<h1>Logic</h1>