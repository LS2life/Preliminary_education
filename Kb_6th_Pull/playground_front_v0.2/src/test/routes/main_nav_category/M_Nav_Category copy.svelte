<script>
	import { fly, slide } from 'svelte/transition';
    import { Router, Link, Route } from "svelte-routing";


    export let url="";
    let visible_first_nav = false;
    let visible_second_nav = false;
    let visible_third_nav = false;


// pass는 pipe 없음
    // let languageAdd = [
    //     { id: 'java',       name: 'Java',       pass: {Java}},
    //     { id: 'javaScript', name: 'JavaScript', pass: {JavaScript}},
    //     { id: 'python',     name: 'Python',     pass: {Python}},
    //     { id: 'ubuntu',     name: 'Ubuntu',     pass: {Ubuntu}},
    //     { id: 'markdown',   name: 'Markdown',   pass: {Markdown}},
    //     { id: 'html5',      name: 'Html5',      pass: {Html5}},
    //     { id: 'CSS3',       name: 'CSS3',       pass: {CSS3}},
    //     { id: 'about',      name: 'About',      pass: {About}},
    // ];

    let mainInfoTech = [
        { id: 'codename', name: 'Code_Name'},
        { id: 'framework', name: 'Framework'},
        { id: 'dbms', name: 'DBMS'},
        { id: 'vc', name: 'VC'},
        { id: 'os', name: 'OS'},
        { id: 'etc', name: 'Etc.'},
    ]

    // let mNavCategory = [
    //     { id: 'it', name: 'InfoTech'},
    //     { id: 'cosmos', name: 'Cosmos'},
    //     { id: 'engineering', name: 'Engineering'},
    //     { id: 'language', name: 'Language'},
    //     { id: 'sf', name: 'SciFic'},
    //     { id: 'etc', name: 'etC.'},
    // ]
    
</script>


<div class="main_nav_category">
    <Router {url}>
    {#each mainInfoTech as {id, name}, i}
        <span transition:slide>
            <Link to="{id}">{name}</Link>
        </span>
    {/each}
    </Router>
</div>

<!-- <div class="main_nav_cate_it">
    {#each mainMenuAdd as {id, name}, i}
        <span transition:fly>
            {name}
        </span>
    {/each}
</div> -->

<!-- <div class="main_nav_cate_codename">
    <Router {url}>
        {#each languageAdd as {id, name}, i}
            <span id="main_nav_text" transition:fly>
                <Link to="{id}">{name}</Link>
            </span>
        {/each}
    </Router>
</div> -->


<style>
    nav {
        border: 1px solid red;

        position: sticky;
        top: 0;


    }
    div {
        border: 1px solid lawngreen;
        margin: 10px;

    }
    span {
        border: 1px solid lawngreen;

        padding: 1vmin;
        display: inlinex;
        /* margin-left: auto; */
        font-size: 2.5vmin;
        max-width: 1280px;
        width: 100%; 
    }

</style>