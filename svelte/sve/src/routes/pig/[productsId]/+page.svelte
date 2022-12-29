<script>
    export let data;
    console.log(data);
    const { products } = data;
</script>

<h1>show</h1>
<h2>{products.title}</h2>
<p>{products.description}</p>
<p>${products.price.toFixed(2)}</p>
<!-- {#each products as product}
    <h2>
        <a href="/pig/{product.id}" >{product.title}</a>
    </h2>
    <p>{product.description}</p>
{/each} -->