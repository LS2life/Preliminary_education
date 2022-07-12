<script>
    let name="World"
    //양방향 바인딩:bind:
    let a=1
    let b=2

    let yes=false
    let mustYes=false
</script>

<label>
    <input type=checkbox bind:checked={mustYes}/>
    <p>[필수] 동의</p>
</label>
<button disabled={!mustYes}>
    Next
</button>
<label>
    <input type=checkbox bind:checked={yes}/>
    <p>[선택]마케팅 활용에 동의 하십니까?</p>
</label>
{#if yes}
<p>광고 문자나 전화를 드리겠습니다.</p>
{:else}
<p>마케팅 동의 하시면 3% 할인 쿠폰(최대 2000원 사용 가능) 드립니다</p>
{/if}
<label>
    A<input type=number bind:value={a}>
    <input type=range bind:value={a} min=0 max=10>
</label>
<label>
    B<input type=number bind:value={b}>
    <input type=range bind:value={b} min=0 max=10>
</label>
<p>{a} + {b} = {a+b}</p>
<style>
    label{ display: flex;}
    input,p{margin: 6px;}
</style>

<input bind:value={name}>
<h1>Hello {name}!</h1>

<h3>Bindings</h3>