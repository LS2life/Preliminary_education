<script>
    let size=1
    let flavours=[
        "마카다미아"
    ]
    let sizeType=[
        "싱글 레귤러",
        "더블 레귤러",
        "파인트"
    ]

    let menu=[
        "마카다미아",
        "피카피카 피카츄",
        "메롱멜론"
    ]
    // console.log(menu.join("---"))
    function getFlavours(flavours){
        if(flavours.length===1) return flavours[0]
        return `${flavours.slice(0,-1).join(", ")} 
            그리고 ${flavours[flavours.length-1]}`
    }
</script>

<h1>GroupInputs</h1>
<h2>Size</h2>
<label>
    <input type=radio bind:group={size} name="size" value={1}>
    싱글 레귤러
</label>
<label>
    <input type=radio bind:group={size} name="size" value={2}>
    더블 레귤러
</label>
<label>
    <input type=radio bind:group={size} name="size" value={3}>
    파인트
</label>

<h2>Flavours</h2>
{#each menu as flavour}
<label>
    <input 
        type=checkbox
        bind:group="{flavours}"
        name="flavours"
        value={flavour}
    />
    {flavour}
</label>
{/each}
{#if flavours.length===0}
<p> 최소한 한개의 맛은 선택해 주세요.</p>
{:else if flavours.length>size}
<p>사이즈보다 크게 맛을 더 선택 할순 없습니다.</p>
{:else}
<p>
    주문하신 것은 {sizeType[size-1]} 이고
    선택한 맛은 {getFlavours(flavours)}
    입니다.
</p>
<button>주문하기</button>
{/if}

