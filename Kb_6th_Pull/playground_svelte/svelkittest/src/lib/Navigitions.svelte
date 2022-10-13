<script>
  import NavMain from './navigitions_branch/Nav_Main.svelte'
</script>

<NavMain />

<div class="Box">
  <slot >
    <!-- optional fallback -->
    <h1>슬롯</h1>
  </slot>
</div>
