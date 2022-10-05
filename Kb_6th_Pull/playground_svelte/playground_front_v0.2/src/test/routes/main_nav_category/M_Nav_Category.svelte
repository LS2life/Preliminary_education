<script>
    import { Link, Router, Route } from "svelte-routing";
    import { fly, slide } from "svelte/transition";
    import InfoTech from "./M_Nav_Infotech.svelte";
    import Language from "./M_Nav_Language.svelte";

    export let url = "";

    // pass는 pipe 없음

    let framework = [
        { id: "svelte", name: "Svelte" },
        { id: "spring5", name: "Spring5_Boot" },
        // { id:'', name:''},
    ];

    let dbms = [
        { id: "mysql", name: "MySQL" },
        // { id:'', name:''},
    ];

    let vc = [
        { id: "git", name: "Git" },
        { id: "github", name: "GitHub" },
        // { id:'', name:''},
    ];

    let os = [
        { id: "ubuntu", name: "Ubuntu" },
        { id: "windows", name: "Windows" },
        // { id:'', name:''},
    ];

    let F_etc = [
        { id: "fetc", name: "F_etC" },
        // { id:'', name:''},
    ];

    let Cosmos = [{ id: "cosmos", name: "Cosmos" }];

    let engineering = [{ id: "engineering", name: "Engineering" }];

    let SciFic = [{ id: "ironman", name: "Ironman" }];

    let etC = [{ id: "etC", name: "etC" }];

    let active = false;

    let isActive = () => {
        active = !active;
    };
</script>

<!-- 
	Todo :submenu를 표준 switch로 사용 [...{grup}] 구문 사용해볼 것.
-->

<Router {url}>
    <div>
        {#if active}
            <div transition:fly={{ duration: 700, x: 200 }}>
                <button>
                    <Link to="infotech">InfoTech</Link>
                </button>
                <button>
                    <Link to="cosmos">Cosmos</Link>
                </button>
                <button>
                    <Link to="engineering">Engineering</Link>
                </button>
                <button>
                    <Link to="language">Language</Link>
                </button>
                <button>
                    <Link to="scific">SciFic</Link>
                </button>
                <button>
                    <Link to="etc">etC</Link>
                </button>
            </div>
        {/if}

        <div>
            {#if active}
                <button on:click={isActive}>-</button>
            {:else}
                <button on:click={isActive}>+</button>
            {/if}
        </div>
    </div>

    <div transition:fly={{ duration: 700, x: 200 }}>
        <Route path="infotech" component={InfoTech} />
        <Route path="language" component={Language} />
    </div>
    <!-- <div transition:fly={{ duration: 700, x: 200 }}>
        <Route path="codename" component={CodeName} />
        <Route path="language" component={Language} />
    </div> -->
</Router>

<!-- {#each mNavCategory as { id, name }, i}
                    <span>
                        <button>
                            <Link to={id} on:click={isActive2}>{name}</Link>
                        </button>
                    </span>
                {/each} -->
<!--
				on:focus on:mouseover 구문 in: animation 안먹힘. 
				out: animarion 정상동작
				on:mouseover 사용시 lifecycle 또는 Delay 적용 필요.
			  -->

<!--
            <div>
                {#each infotech as { id, name }, i}
                    <span transition:slide>
                        <Link to={id} on:click={isActive3}><button>{name}</button></Link>
                        <Route path={id} component:{name} />
                    </span>
                {/each}
            </div>

            {#if active && active3}
                <div>
                    {#each codeName as { id, name }, i}
                        <span transition:slide>
                            <Link to={id}><button>{name}</button></Link>
                        </span>
                    {/each}
                </div>
            {/if}
        </div>

-->
<style>
    div {
        border: 1px solid lawngreen;

        display: flex;
        justify-content: end;
        padding: 0.2em;
        margin: 0.1em;
    }

    span {
        max-width: 1280px;
        width: 100%;
        margin: 0.1em;
    }
    Link {
	    text-transform: uppercase;
    }
</style>