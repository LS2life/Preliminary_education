<script>
    export let todo
    export let todos

    let isEdit=false
    let title=""

    function onEdit(){
        isEdit=true
        title=todo.title
    }
    function deleteTodo(){
        $todos=$todos.filter(t=>t.id!==todo.id)
        console.log(todos)
    }
    function updateTodo(){
        todo.title=title
        offEdit()
    }
    function offEdit(){
        isEdit=false
    }
</script>

{#if isEdit}
    <div>
        <input 
            type="text"
            bind:value={title}
            on:keydown={(e)=>{
                if(e.key==="Enter"){
                    updateTodo()
                }
            }}
        />
        <button on:click={updateTodo}>
            OK
        </button>
        <button on:click={offEdit}>
            Cancel
        </button>
    </div>
{:else}
    <div>
        {todo.title}
        <button on:click={onEdit}>
            Edit
        </button>
        <button on:click={deleteTodo}>
            Delete
        </button>
    </div>
{/if}