<div>
	<slot name="title">타이틀</slot>
	{#if $$slots.description}
		<!-- This <hr> and slot will render only if a slot named "description" is provided. -->
		<hr>
		<slot name="description">idfke</slot>
	{/if}
</div>