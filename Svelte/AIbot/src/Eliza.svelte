
	import Eliza from "elizabot"
	const eliza=new Eliza()

<div class="chat">
	<h1>Eliza</h1>

	<div class="scrollable" bind:his={div}>
		{#each comments as comment}
			<article class={comment.author}>
				<span>{comment.text}</span>
			</article>
	</div >

</div>