<script>
  // import DayNight from "./DayNight.svelte"
  import Header from "../semantic/Main_Header.svelte";
  import Navigations from "../semantic/Main_Navigitions.svelte";
  //   import Aside from "../semantic/Main_Aside.svelte";
  import Section from "../semantic/Main_Section.svelte";
  import Footer from "../semantic/Main_Footer.svelte";
</script>

<svelte:head>
  <!-- Google font: 
        'Do Hyeon', sans-serif;
        'East Sea Dokdo', cursive;
        'Hi Melody', cursive;
        'Stylish', sans-serif;
        'Noto Sans KR',sans-serif;
    -->
  <link
    href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=East+Sea+Dokdo&family=Hi+Melody&family=Noto+Sans+KR:wght@400&family=Stylish&display=swap"
    rel="stylesheet"
  />
</svelte:head>

<!--
    * Use annotation of vscode plugin "Colorful Comments"
    * Sementic
    * 가능한 각 Tag의 하위범위내에서만 수정.

    * Wellcome view
    * GateWay
    * Header
    * Navigation
    // ㅏGategory

    //  Aside
    * Section
    // ㅏSection_header
    // ㄴSection bocy
    * Footer
-->

<Header />
<Navigations />
<!--// <Aside /> -->
<Section />
<Footer />

<style>
</style>
