<script>
import Thing from "./Thing.svelte"

    let user={loggedIn:false}

    function toggle(){
        user.loggedIn=!user.loggedIn
    }

    let x=11

    let cats=[
        {id:"J---aiyznGQ",name:"keyboard Cat"},
        {id:"z_AbfPXTKms",name:"Maru"},
        {id:"OUtn3pvWmpg",name:"Henri The Existential Cat"},
    ]

    let things=[
        {id:1,name:"apple"},
        {id:2,name:"banana"},
        {id:3,name:"carrot"},
        {id:4,name:"doughnut"},
        {id:5,name:"egg"},
    ]

    function handleClick(){
        things=things.slice(1)
    }

    async function getRandomNuber(){
        const res=await fetch(`https:svelte.dev/tutorial/random-number`)
        const text=await res.text()

        if(res.ok){
            return text
        }else{
            throw new Error(text)
        }
    }
    let promise=getRandomNuber()

    function reGetRandomNuber(){
        promise= getRandomNuber()
    }
</script>
<div>
    <button on:click="{reGetRandomNuber}">
        generate random number
    </button>
    {#await promise}
        <p>...waiting</p>
    {:then number} 
        <p>The number is {number}</p>
    {:catch error}
        <p style="color:red">{error.message}</p>
    {/await}
</div>
    
<button on:click="{handleClick}">
    Remove first thing
</button>

{#each things as thing (thing.id)}
    <Thing name={thing.name}/>
{/each}

<h1>The famous Cats of YouTube</h1>
<ul>
    {#each cats as {id,name},i}
        <li>
            <a target="_black" href="https://www.youtube.com/watch?v={id}">
                {i+1}: {name}
            </a>
        </li>
    {/each}
    {#each cats as cat,i}
        <li>
            <a target="_black" href="https://www.youtube.com/watch?v={cat.id}">
                {i+1}: {cat.name}
            </a>
        </li>
    {/each}
</ul>

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
    <button on:click={toggle}>
        Log in
    </button>
{/if}