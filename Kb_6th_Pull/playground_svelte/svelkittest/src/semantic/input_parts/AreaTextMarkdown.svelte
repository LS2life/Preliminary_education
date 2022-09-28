<script>
    import { slide } from 'svelte/transition'
	import { marked } from 'marked';
    import { time } from './stores.js'
    let text = ``;
    let active= false;
    const isActive=()=>{
        active = !active
    }
const formatter = new Intl.DateTimeFormat('en', {
    hour12: false,
    hour: 'numeric',
    minute: '2-digit',
    second: '2-digit',
});

// async function postAdd(event) {
//     if(event.key!=="Enter") return
//     event.target.value=""
//     const posting={ day_time:{time}, description: event.target.value }
// }

</script>

<div id=button_comment_open>
    {@html marked(text)}
</div>

<button on:click={isActive}>WritePost </button>


{#if active}
<!--todo 글 등록 -->
<button on:click={isActive}>Registation</button>
<!--todo 글 수정  -->
<button on:click={isActive}>Revise</button>

<!-- todo 영역 고정 -->
<textarea 
        transition:slide 
        bind:value={text} 
        placeholder="for markdown"
        ></textarea>

{/if}

<style>
    div {
        border: 1px solid gold;
    }

    #button_comment_open{
        min-height: 70vh;;
    }
    textarea { 
        border: 2px solid white; 
        width: 94%; height: 100px;}


</style>