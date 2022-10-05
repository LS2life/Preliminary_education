<script >
	import { Link, Route, Router } from 'svelte-routing'

	// infotech
		// codename
	import Java from '../routes/blog/infotech/codename/java/+page.svelte'
	import JavaScript from '../routes/blog/infotech/codename/javascript/+page.svelte'
	import Python from '../routes/blog/infotech/codename/python/+page.svelte'
	import Markdown from '../routes/blog/infotech/codename/markdown/+page.svelte'
	import Html5 from '../routes/blog/infotech/codename/html5/+page.svelte'
	import CSS3 from '../routes/blog/infotech/codename/css3/+page.svelte'

		// dbms
	import Dbms from '../routes/blog/infotech/dbms/+page.svelte'

		// framework
	import Framework from '../routes/blog/infotech/framework/+page.svelte'

		// os
	import Ubuntu from '../routes/blog/infotech/os/ubuntu/+page.svelte'

		// vc
	import Vc from '../routes/blog/infotech/vc/+page.svelte'

	// cosmos
	import Cosmos from '../routes/blog/cosmos/+page.svelte'

	// engineering
	import Engineering from '../routes/blog/engineering/+page.svelte'

	// language
	import USEnglish from '../routes/blog/language/english/+page.svelte'
	import Deutsche from '../routes/blog/language/deutsche/+page.svelte'
	import Espanol from '../routes/blog/language/espanol/+page.svelte'
	import Francais from '../routes/blog/language/francais/+page.svelte'
	import Pyccknn from '../routes/blog/language/pyccknn/+page.svelte'

	// scific
	import SciFic from '../routes/blog/scific/+page.svelte'

	// etc
	import etC from '../routes/blog/etc/+page.svelte'

	let end_view = [
		{ id: "java",         name: Java },
		{ id: "javaScript",   name: JavaScript },
		{ id: "python",       name: Python },
		{ id: "ubuntu",       name: Ubuntu },
		{ id: "markdown",     name: Markdown },
		{ id: "html5",        name: Html5 },
		{ id: "css3",         name: CSS3 },
		{ id: "cosmos",       name: Cosmos },
		{ id: "engineering",  name: Engineering },
		{ id: "usenglish",    name: USEnglish },
		{ id: "dasdeutsche",  name: Deutsche },
		{ id: "espanol",      name: Espanol },
		{ id: "francais",     name: Francais },
		{ id: "pyccknn",      name: Pyccknn },
		{ id: "scific",       name: SciFic },
		{ id: "etc",          name: etC },
		{ id: 'dbms',         name: Dbms },
		{ id: 'framework',    name: Framework},
		{ id: 'vc',           name: Vc},
		//{ id: '', name: },
	];

	export let url = "";
</script >


<Router {url}>
	{#each end_view as { id, name }}
		<Route path={id} component={name} />

		<!-- <Route path="java" component={Java}/>
			  <Route path="javaScript" component={JavaScript}/>
			  <Route path="python" component={Python}/>
			  <Route path="ubuntu" component={Ubuntu}/>
			  <Route path="markdown" component={Markdown}/>
			  <Route path="html5" component={Html5}/>
			  <Route path="css3" component={CSS3}/>
			  <Route path="about" component={About}/> -->
	{/each}

	<!-- <div>
			<Route path="framework" component={framework}/>
		</div> -->
</Router>

<hr />












<!--{#each end_view as {id, name}, i}-->
<!--	<div class:active={$page.url.pathname === {name}}>-->
<!--	</div>-->
<!--{/each}-->


<style >

</style >