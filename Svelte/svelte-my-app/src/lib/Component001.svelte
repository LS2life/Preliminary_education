<script>
    import Fruits from './Fruits.svelte'

    let fruits=["Apple","Banana","Cherry","Orange","Mango"]
</script>

<h1>Component001</h1>

<!-- <Fruits fruits={fruits}/> -->
<Fruits {fruits}/>
<Fruits {fruits} reverse/>
<Fruits {fruits} slice="-2"/>
<Fruits {fruits} slice="0, 3"/>
