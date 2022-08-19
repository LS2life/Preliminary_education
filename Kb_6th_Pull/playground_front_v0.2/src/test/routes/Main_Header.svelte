<script>
    import MNavCategory from "../routes/main_nav_category/M_Nav_Category.svelte";

    let active = false;
    const isActive=()=>{active = !active}
</script>
<header readonly>
    <div>
        <h1>A|∀ & T|ㄱ & i|! & m|m & E|∃</h1>
        <h2>CQ*3 DEHL E. N. AS QSA EX VA*2 TNX*2 AR.</h2>
    </div>
</header >

<style>
    header {
        border: 1px solid yellow;

        display:flex;
       
        width: 100%;
        max-width: 1280px;

    }

    div { 
        border: 1px solid red;

        margin: auto;
    }

    h2 {

        border: 1px solid yellow;
        font-size: 2.7vmin;
    }

</style>