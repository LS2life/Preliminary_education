<script>
  let name = "";
</script>

<p>{name || "입력한 댓글은 여기에 표시됩니다."}!</p>

<div>
  <span>
    <input class="reply_user" type="text" />
    <input class="reply_password" type="password" />
  </span>
  <div class="reply">
    <input bind:value={name} placeholder="댓글은 언제나 환영입니다." />
    <button on:click />
  </div>
</div>

<style>
  input {
    font-size: 1.2em;
  }
</style>
