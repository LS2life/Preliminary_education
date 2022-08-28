<script>
  import { Link, Router } from "svelte-routing";
  import { fly, scale, crossfade, fade, blur, slide } from "svelte/transition";

  export let url = "";

  // pass는 pipe 없음
  let codeName = [
    { id: "java", name: "Java" },
    { id: "javaScript", name: "JavaScript" },
    { id: "python", name: "Python" },
    { id: "ubuntu", name: "Ubuntu" },
    { id: "markdown", name: "Markdown" },
    { id: "html5", name: "Html5" },
    { id: "CSS3", name: "CSS3" },
    { id: "about", name: "About" },
  ];

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

  let InfoTech = [
    { $: codeName, name: "CodeName" },
    { $: framework, name: "Framework" },
    { $: dbms, name: "DBMS" },
    { $: vc, name: "VC" },
    { $: os, name: "OS" },
    { $: F_etc, name: "Etc." },
  ];

  let Cosmos = [{ id: "cosmos", name: "Cosmos" }];

  let engineering = [{ id: "engineering", name: "Engineering" }];

  let Language = [
    { id: "usenglish", name: "USEnglish" },
    { id: "dasdeutsche", name: "Deutsche" },
    { id: "espanol", name: "Espanol" },
    { id: "francais", name: "Francais" },
    { id: "pyccknn", name: "Pyccknn" },
  ];

  let SciFic = [{ id: "ironman", name: "Ironman" }];

  let etC = [{ id: "etC", name: "etC" }];

  let mNavCategory = [
    { id: "infotech", name: "InfoTech" },
    { id: "cosmos", name: "Cosmos" },
    { id: "engineering", name: "Engineering" },
    { id: "language", name: "Language" },
    { id: "scific", name: "SciFic" },
    { id: "etc", name: "etC." },
  ];

  let active = false;
  let active2 = false;
  let active3 = false;

  const isActive = () => {
    active = !active;
  };
  const isActive2 = () => {
    active2 = !active2;
  };
  const isActive3 = () => {
    active3 = !active3;
  };

  function sda() {
    if (active && active2) {
      return true;
    } else {
      return false;
    }
  }
  function reply_click(id) {
    this.id = id;
    alert(id);
  }
</script>

<!-- 
	Todo :submenu를 표준 switch로 사용 [...{grup}] 구문 사용해볼 것.
-->

<Router {url}>
  <div class="mMenuContainer">
    <div class="mMenuList">
      {#if active}
        <div class="mMainMenu" transition:fly={{ duration: 700, x: 200 }}>
          {#each mNavCategory as { id, name }, i}
            <span>
              <Link to={id} on:click={isActive2}><button>{name}</button></Link>
              <!-- <Link to={id} on:click={reply_click}>{name}</Link> -->
            </span>
          {/each}
        </div>
      {/if}

      <!--
				on:focus on:mouseover 구문 in: animation 안먹힘. 
				out: animarion 정상동작
				on:mouseover 사용시 lifecycle 또는 Delay 적용 필요.
			  -->
      {#if active && active2}
        <div class="mMainMenu">
          {#each InfoTech as { id, name }, i}
            <span class="mMainMenuFold" transition:slide>
              <Link to={id} on:click={isActive3}><button>{name}</button></Link>
            </span>
          {/each}
        </div>
      {/if}

      {#if active && active3}
        <div class="mMainMenu">
          {#each codeName as { id, name }, i}
            <span class="mMainMenuFold" transition:slide>
              <Link to={id}><button>{name}</button></Link>
            </span>
          {/each}
        </div>
      {/if}
    </div>

    <div>
      {#if active}
        <button class="mMenuFoldButt" on:click={isActive}>-</button>
      {:else}
        <button class="mMenuFoldButt" on:click={isActive}>+</button>
      {/if}
    </div>
  </div>
</Router>

<style>
  .mMenuContainer {
    display: flex;
    justify-content: end;
  }

  .mMainMenu {
    font-size: 2.5vmin;
    padding: 0.2em;
  }

  .mMenuFoldButt {
    border: 1px solid red;
    /* margin: 0.1em; */
    font-size: 3vmin;
  }

  div {
    border: 1px solid lawngreen;
  }

  span {
    max-width: 1280px;
    width: 100%;
    margin: 0.1em;
  }
</style>
