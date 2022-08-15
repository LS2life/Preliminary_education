<script>
    import Header from "./Main_Header.svelte"
    import Section from "./Main_Section.svelte"
    import Navigation from "./Main_Navigition1.svelte"
    import Aside from "./Main_aside.svelte"
    import Footer from "./Main_Footer.svelte"
</script>

<!--
    Sementic
    
    가능한 각 Tag의 하위범위내에서만 수정.

    header
    navigation
    // aside
    section
        //section_header
    aside
    footer

-->

<Header />
<Navigation />
<Section />
<Aside />
<Footer />

