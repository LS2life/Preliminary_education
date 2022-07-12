<script>
    import logo from '../../assets/svelte.png'
    import danceMan from "../../assets/image.gif"
    
    let name="Svelte"
    
    let danceManName="Rick Astley"
    let htmlName="<span style='color:red;'>Svelte</span>"

    let count = 0
    const increment = () => {
        count += 1
    }
    /* vue의 watch,computed */
    // let sum=count*2
    $: sum=count*2

    $: if(count>5){
        alert("Count는 5보다 클수 없습니다.")
        count=5
    }
</script>

<img class="imgLogo" src={logo} alt="Svelte Logo" />
<h1>Hello world!</h1>

<h1>Home Component</h1>
<h2>Hello {name}!</h2>

<img src={danceMan} alt="A Dance Man"/>
<img src={danceMan} alt="{danceManName} dances."/>

<h2>Hello {@html htmlName}</h2>

<input 
    type="button" 
    value="Clicks: {count} Sum:{sum}"
    on:click="{increment}"
/>

<style>
  h1 {
    color: #ff3e00;
    text-transform: uppercase;
    font-size: 4rem;
    font-weight: 100;
    line-height: 1.1;
    margin: 2rem auto;
    /* max-width: 14rem; */
  }
  h2 {
    color: #ff3e00;
    font-size: 3rem;
    font-weight: 80;
    line-height: 1.1;
    margin: 2rem auto;
  }
  input[type=button] {
    font-family: inherit;
    font-size: inherit;
    padding: 1em 2em;
    color: #ff3e00;
    background-color: rgba(255, 62, 0, 0.1);
    border-radius: 2em;
    border: 2px solid rgba(255, 62, 0, 0);
    outline: none;
    width: 200px;
    font-variant-numeric: tabular-nums;
    cursor: pointer;
  }
  :root {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen,
      Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  }

  .imgLogo {
    height: 16rem;
    width: 16rem;
  }

  h1 {
    color: #ff3e00;
    text-transform: uppercase;
    font-size: 4rem;
    font-weight: 100;
    line-height: 1.1;
    margin: 2rem auto;
    max-width: 14rem;
  }

</style>