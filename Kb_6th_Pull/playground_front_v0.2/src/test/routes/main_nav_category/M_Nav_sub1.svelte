<script>
  import { Link, Router, Route } from "svelte-routing";
  import { fly, scale, crossfade, fade, blur, slide } from "svelte/transition";
  export let url = "";
  export let fold;
  export let id;
  export let name;

  let active = false;
  const isActive = () => {
    active = !active;
  };
</script>

<!-- 이렇게는 왜 안될까? -->

<Router {url}>
  {#if active}
    <div class="mMainMenu">
      {#each { fold } as { id, name }, i}
        <span class="mMainMenuFold" transition:slide={{ duration: 1000 }}>
          <Link to={id} on:click={isActive}>{name}</Link>
        </span>
      {/each}
    </div>
  {/if}
</Router>

<style>
  .mMainMenu {
    font-size: 2.5vmin;
    padding: 0.2em;
  }

  div {
    border: 1px solid lawngreen;
  }
</style>
