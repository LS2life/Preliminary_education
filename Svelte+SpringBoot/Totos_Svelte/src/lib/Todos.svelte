<script>
import {flip} from "svelte/animate"
import { crossfade, fade, fly } from "svelte/transition";
import { onMount } from "svelte";

 // const 초기값을 변경할 수 없는 변수, const 상수
// 
const [send, receive]=crossfade({
	duration:500,
	fallback:fade
})

let todos=[
	// { id: 1, done: false,description: "wirte some docs"},

]

const endpoint="http://localhost:8080/todos"
onMount(async function(){
	const res=await fetch(endpoint+"?sort=id,desc")
	const data=await res.json()
	// console.log(data)
	// console.log(data._embedded.todos)
	todos=data._embedded.todos
})

async function toggleDone(todo){
	// console.log(todo)
	todo.done=!todo.done
	await fetch(endpoint+"/"+todo.id,{
		method:"PATCH",
		headers:{
			"Content-Type":"application/json"
		},
		body:JSON.stringify({
			done:todo.done
		})
	})
}

// let uid=todos.length+1
async function add(event){
	// console.log(event.key)
	if(event.key!=="Enter") return

		// id:uid++,
	const todo={ done:false, description:event.target.value }

	await fetch(endpoint,{ method:"POST", headers:{
			"Content-Type":"application/json"
		}, body:JSON.stringify({ done:todo.done, description:todo.description })
	})

	todos=[todo,...todos]
	event.target.value=""
}

async function remove(todo){ 
	await fetch(endpoint+"/"+todo.id,{ method:"DELETE"})
	todos=todos.filter(t=>t!==todo)
}
</script>


<div class="board">
	<h1 transition:fade>Todos App</h1>
	<input
		class="new-todo"
		placeholder="What needs to be done?"
		on:keydown="{add}"
		transition:fade
	>
	<div class="left" transition:fly={{x:-100}}>
		<h2 >todo</h2>
		{#each todos.filter(t=>!t.done) as todo (todo.id)}
		<label
			in:receive="{{key:todo.id}}"
			out:send="{{key:todo.id}}"
			animate:flip
		>
			<input 
			type=checkbox 
			bind:checked={todo.done}
			on:click="{()=>toggleDone(todo)}">
			{todo.description}
			<button on:click="{()=>remove(todo)}">x</button>
		</label>
		{/each}
	</div>
	<div class="right" transition:fly={{x:100}}>
		<h2>done</h2>
		{#each todos.filter(t=>t.done) as todo (todo.id)}
		<label
			in:receive="{{key:todo.id}}"
			out:send="{{key:todo.id}}" 
			animate:flip
		>
			<input 
			type=checkbox 
			bind:checked={todo.done}
			on:click="{()=>toggleDone(todo)}">
			{todo.description}
			<button on:click="{()=>remove(todo)}">x</button>
		</label>
		{/each}
	</div>
</div>



<style>
	.new-todo {
		border: 1px solid red;
		font-size: 1.4em;
		width: 100%;
		margin: 2em 0 1em 0;
	}

	.board {
		border: 1px solid yellow;
		max-width: 36em;
		margin: 0 auto;
	}

	.board > input{
		border: 1px solid green;
		width: 95%;
		height: 30px;
	}

	.board > h1{
		border: 1px solid blue;
		text-align: center;
		font-size: 4em;
		font-weight: 400;
	}

	.left, .right {
		border: 1px solid orange;
		text-align: center;
		float: left;
		width: 50%;
		padding: 0 1em 0 0;
		box-sizing: border-box;
	}

	h2 {
		border: 1px solid purple;
		font-size: 2em;
		font-weight: 200;
		user-select: none;
	}

	label {
		border: 1px solid pink;
		top: 0;
		left: 0;
		display: block;
		font-size: 1em;
		line-height: 1;
		padding: 0.5em;
		margin: 0 auto 0.5em auto;
		border-radius: 2px;
		background-color: #eee;
		user-select: none;
	}

	input { margin: 0 }

	.left label {
		background-color: rgb(180,240,100);
	}

	button {
		float: right;
		height: 1em;
		box-sizing: border-box;
		padding: 0 0.5em;
		line-height: 1;
		background-color: transparent;
		border: none;
		color: rgb(170,30,30);
		opacity: 0;
		transition: opacity 0.2s;
	}

	label:hover button {
		border: 1px solid white;
		opacity: 1;
	}
</style>