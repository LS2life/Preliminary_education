<script>
	import { Link,Router } from "svelte-routing";
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

    let framework = [
        { id:'svelte', name:'Svelte'},
        { id:'spring5', name:'Spring5_Boot'},
        // { id:'', name:''},
    ]

    let dbms = [
        { id:'mysql', name:'MySQL'},
        // { id:'', name:''},
    ]

    let vc = [
        { id:'git', name:'Git'},
        { id:'github', name:'GitHub'},
        // { id:'', name:''},
    ]

    let os = [
        { id:'ubuntu', name:'Ubuntu'},
        { id:'windows', name:'Windows'},
        // { id:'', name:''},
    ]

    let etc = [
        { id:'fetc', name:'F_etC'},
        // { id:'', name:''},
    ]

    let InfoTech = [
        { $: codeName,   name: 'CodeName'       },
        { $: framework,  name: 'Framework'},
        { $: dbms,       name: 'DBMS'     },
        { $: vc,         name: 'VC'       },
        { $: os,         name: 'OS'       },
        { $: etc,        name: 'Etc.'     },
    ]

    let mNavCategory = [
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
<div class="mMenuContainer">
    <div class="mMenuList">
        {#if active}
            <div class="mMainMenu" transition:fly="{{duration:700, x:200}}">
                {#each mNavCategory as {id, name}, i}
                    <span>
                        <Link to="{id}" on:click={isActive2} >{name}</Link>
                    </span>
                {/each}
                    
                    <!-- <button on:click={isActive} >-</button> -->
                    
                    <!-- <button on:click={isActive} >{active === true ? '-' : '+' }</button> -->

                <!-- {:else}
                    <button on:click={isActive} >+</button> -->
                    <!-- <button on:click={isActive} >{active === false ? '+' : '-' }</button> -->
            </div>
        {/if}

        {#if active2 }
            <div class="mMainMenu">
            {#each InfoTech as {id, name}, i}
                <span class="mMainMenuFold" transition:slide="{{duration:1000}}">
                    <Link to="{id}" on:click={isActive3}>{name}</Link>
                </span>
            {/each}
            </div>
        {/if}

        {#if active3 }
            <div class="mMainMenu">
            {#each codeName as {id, name}, i}
                <span class="mMainMenuFold" transition:slide="{{duration:1000}}">
                    <Link to="{id}">{name}</Link>
                </span>
            {/each}
            </div>
        {/if}

    </div>

    <div id="mMenuFoldButt">
        <!-- ! Main menu folding +,-표시 따로 -->
            {#if active}
                <button on:click={isActive} >-</button>
            {:else}
                <button on:click={isActive} >+</button>
            {/if}
    </div>
</div>
</Router>


<style>

    .mMenuContainer{
        display: flex;
        justify-content:end;
    }

    .mMainMenu{
        font-size: 2.5vmin;
        padding: 0.2em;
    }

    #mMenuFoldButt{
        border: 1px solid red;
        margin: 0.1em;
        font-size: 1.5vmin;

    }

    div {
        border: 1px solid lawngreen;
    }

    span{
        border: 1px solid lawngreen;

        max-width: 1280px;
        width: 100%; 
        margin: 0.1em;
    }

    span:hover{
        background-color: aqua;

    }

</style>