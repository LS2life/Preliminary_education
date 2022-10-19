<script>
	import { transition_in } from "svelte/internal";
    import { fade } from "svelte/transition";

    export let title='';
    export let summary='';
    export let update='';
    export let categories=''+'';
</script>

<svelte:head>
    <title>{title} | ProgrammingTIL</title>
    <meta name='description' content={summary} />
</svelte:head>

<div class='post' in:fade="{{delay:500}}" out:fade>
    <h1>{title}</h1>
    <p><time>{update}</time></p>
    <categorie>{categories}</categorie>
    <hr>
    <slot />
</div>

<style>
    .post {
        margin-left: 10%;
        margin-right: 10%;
    }

    h1 {

        font-size: 2.5em;
        font-weight: bold;
        font-family: 'Noto Serif KR', serif;

    }
    div,p {
        font-size: 1.2em;
        font-family: "Hi-Melody"; 
        line-height: 1.5;
        text-align: left;
    }

</style>