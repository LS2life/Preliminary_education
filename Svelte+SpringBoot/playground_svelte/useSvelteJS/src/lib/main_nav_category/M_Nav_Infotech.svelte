<script>
    import { Router, Link, Route } from "svelte-routing";
    import { fly } from "svelte/transition";
    import CodeName from "./M_Nav_Info_CodeName.svelte";

    let url = "";

    let InfoTech = [
        { id: "codename", name: "CodeName" },
        { id: "framework", name: "Framework" },
        { id: "dbms", name: "DBMS" },
        { id: "vc", name: "VC" },
        { id: "os", name: "OS" },
        { id: "F_etc", name: "Etc." },
        //{ id: "", name: "" },
    ];

    let codename = [
        { id: "java", name: "Java" },
        { id: "javaScript", name: "JavaScript" },
        { id: "python", name: "Python" },
        { id: "ubuntu", name: "Ubuntu" },
        { id: "markdown", name: "Markdown" },
        { id: "html5", name: "Html5" },
        { id: "CSS3", name: "CSS3" },
        { id: "about", name: "About" },
    ];
</script>

<Router {url}>
    <div transition:fly={{ duration: 700, x: 200 }}>
        {#each InfoTech as { id, name }, i}
            <button>
                <Link to={id}>{name}</Link>
            </button>
        {/each}
    </div>
    <div transition:fly={{ duration: 700, x: 200 }}>
        {#each codename as { id, name }, i}
            <Route path={id} component={name} />
        {/each}
    </div>
</Router>

<style>
    button {
        font-family: "Noto Sans KR", sans-serif;
        border: none;
        color: #000;
        font-size: 2.5vmin;
        margin-left: 0.2em;
        margin-right: 0.2em;
    }
</style>
