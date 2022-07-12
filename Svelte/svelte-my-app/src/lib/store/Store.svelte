<script>
    import {storeName} from "./store.js"
    import Parent from "./Parent.svelte"
    let name="world"
    // console.log(storeName)
    // console.log($storeName)
    $storeName=name
</script>

<h1>Store</h1>
<h2>Hello {name}!</h2>
<Parent/>