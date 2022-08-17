<script>
    import Header from "./Main_Header.svelte"
    import Section from "./Main_Section.svelte"
    import Navigations from "./Main_Navigitions.svelte"
    import Aside from "./Main_Aside.svelte"
    import Footer from "./Main_Footer.svelte"
</script>


<!-- Use annotation of vscode plugin "Colorful Comments" -->
<!--
    * Sementic
    
    * 가능한 각 Tag의 하위범위내에서만 수정.

    * header
    * navigation
     // aside
    * section
         //section_header
    * aside
    * footer

-->
<Header />
<Navigations/>
<Section />
<Aside />
<Footer />

