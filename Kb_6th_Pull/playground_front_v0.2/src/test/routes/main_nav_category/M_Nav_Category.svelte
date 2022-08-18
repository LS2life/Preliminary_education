<script>
	import { Link,Router } from "svelte-routing";
import { element } from "svelte/internal";
	import { fly, scale, crossfade, fade, blur, slide } from 'svelte/transition';


    export let url="";

// pass는 pipe 없음
    let codeName = [
                { id: 'java',       name: 'Java'       }, 
                { id: 'javaScript', name: 'JavaScript' }, 
                { id: 'python',     name: 'Python'    },     
                { id: 'ubuntu',     name: 'Ubuntu'     },    
                { id: 'markdown',   name: 'Markdown'   }, 
                { id: 'html5',      name: 'Html5'      },   
                { id: 'CSS3',       name: 'CSS3'       },   
                { id: 'about',      name: 'About'      }, 
            ];

    let InfoTech = [
        { $: codeName,   name: 'CodeName'       },
        { id: 'framework',  name: 'Framework'},
        { id: 'dbms',       name: 'DBMS'     },
        { id: 'vc',         name: 'VC'       },
        { id: 'os',         name: 'OS'       },
        { id: 'etc',        name: 'Etc.'     },
    ]

    const mNavCategory = [
        { $: InfoTech,   name: 'InfoTech'  },
        { id: 'cosmos',     name: 'Cosmos'     },
        { id: 'engineering',name: 'Engineering'},
        { id: 'language',   name: 'Language'   },
        { id: 'scific',     name: 'SciFic'     },
        { id: 'etc',        name: 'etC.'       },
    ]
    
    let active = false;
    let active2 = false;
    let active3 = false;
    const isActive = () => { active = !active };
    const isActive2 = () => { active2 = !active2 };
    const isActive3 = () => { active3 = !active3 };

</script>


<Router {url}>

<div>
    <!-- ! Main menu folding +,-표시 따로 -->
    <!-- 
        {#if active}
            <button on:click={isActive} >-</button>
        {:else}
            <button on:click={isActive} >+</button>
        {/if}
    -->

    <!-- 
        Todo : Button > Main menu folding +,- 표시 lifecycle afterUpdate 적용할 것. 
        Todo : 메뉴 확장시 모션 딜레이 줄것.
    -->
    {#if active}
        {#each mNavCategory as {id, name}, i}
            <span 
                on:focus 
                on:mouseover={isActive2} 
                transition:fly="{{
                    delay:500,
                    duration:1000,
                    x:90
                }}" 
            >
                <Link to="{id}">{name}</Link>
            </span>
        {/each}
        
        <button on:click={isActive} >-</button>
        
        <!-- <button on:click={isActive} >{active === true ? '-' : '+' }</button> -->

    {:else}
        <button on:click={isActive} >+</button>
        <!-- <button on:click={isActive} >{active === false ? '+' : '-' }</button> -->

    {/if}
</div>    

<div>
{#if active2 && active}
    {#each InfoTech as {id, name}, i}
        <span on:focus on:mouseover={isActive3} transition:slide="{{delay:1000}}">
            <Link to="{id}">{name}</Link>

        </span>
    {/each}
{/if}
</div>

<div>
{#if active3 && active2 && active}
    {#each codeName as {id, name}, i}
        <span transition:slide>
            <Link to="{id}">{name}</Link>
        </span>
    {/each}
{/if}
</div>
</Router>


<style>

    div {
        border: 1px solid lawngreen;

        display: inline-table ;
        margin: 10px;
    }

    span {
        border: 1px solid lawngreen;

        padding: 1vmin;
        display: inlinex;
        font-size: 2.5vmin;
        max-width: 1280px;
        width: 100%; 
    }

    span:hover {
        background-color: aqua;
    }

</style>