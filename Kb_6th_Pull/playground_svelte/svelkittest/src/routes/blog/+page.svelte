<script>
  import Header from "../../lib/Header.svelte";
  import Navigations from "../../lib/Navigitions.svelte";
  import Section from "../../lib/Section.svelte"
  import Footer from "../../lib/Footer.svelte";

  // import M_Nav_Category from "./main_nav_category/M_Nav_Category.svelte";
  // import Aside from "./Main_Aside.svelte";
  //
  // import Section from "./Main_Section.svelte";
  // import Main_Section_Body from "./Main_Section_Body.svelte";
  // import Main_Section_Header from "./Main_Section_Header.svelte";
  //
  // import MNavSub1 from "./main_nav_category/M_Nav_sub1.svelte";
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

<!-- Use annotation of vscode plugin "Colorful Comments" -->
<!--
    * Sementic
    * 가능한 각 Tag의 하위범위내에서만 수정.
    * Wellcome view
    * header
    * navigation
     // aside
    * section
         // section_header
         // section body
    * footer
-->

<Header />
<Navigations />
<!--// <Aside /> -->
<Section/>
<Footer />

<style>
</style>