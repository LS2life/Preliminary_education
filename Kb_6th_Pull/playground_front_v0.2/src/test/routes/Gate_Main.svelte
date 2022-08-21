<script>
	import Main_Section_Body from './Main_Section_Body.svelte';
	import Main_Section_Header from './Main_Section_Header.svelte';
	import M_Nav_Category from './main_nav_category/M_Nav_Category.svelte';
    import Wellcome from "../view/Wellcome.svelte"
    import Header from "./Main_Header.svelte"
    import Section from "./Main_Section.svelte"
    import Navigations from "./Main_Navigitions.svelte"
    import Aside from "./Main_Aside.svelte"
    import Footer from "./Main_Footer.svelte"
    import MNavSub1 from './main_nav_category/M_Nav_sub1.svelte';

</script>


<!-- Use annotation of vscode plugin "Colorful Comments" -->
<!--
    * Sementic
    
    * 가능한 각 Tag의 하위범위내에서만 수정.

    // Wellcome view
    * header
    * navigation
     // aside
    * section
         // section_header
         // section bocy
    * footer

-->

<!--// <Wellcome /> -->

<Header />

<Navigations/>
    <!-- <M_Nav_Category /> -->
    <!-- <MNavSub1 /> -->

<!--// <Aside /> -->

<Section />
    <!-- <Main_Section_Header /> -->
    <!-- <Main_Section_Body /> -->

<Footer />

