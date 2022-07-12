<script>
import Info from "./Info.svelte"
import Nested from "./Nested.svelte"
//Props 부모 컴포넌트에서 자식 컴포넌트에 데이터 전달
const pkg={
    name:"svelte",
    version:3,
    speed:"blazing",
    website:"https://svelte.dev"
}
</script>
<h1>Props</h1>
<Nested answer={42}/>
<Nested/>
<!-- 
    <Info name={pkg.name}/>
-->
<Info {...pkg}/>