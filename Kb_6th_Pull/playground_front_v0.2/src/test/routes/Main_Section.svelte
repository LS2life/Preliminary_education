<script>
  import EtC from "./../view/main_nav_etc/etC.svelte";
  import English from "./../view/m_nav_language/English.svelte";
  import { Router, Link, Route } from "svelte-routing";
  import Java from "../view/m_nav_infotech/m_nav_info_codename/Language_Java.svelte";
  import JavaScript from "../view/m_nav_infotech/m_nav_info_codename/Language_JavaScript.svelte";
  import Python from "../view/m_nav_infotech/m_nav_info_codename/Language_Python.svelte";
  import Ubuntu from "../view/m_nav_infotech/m_nav_info_codename/Linux_Ubuntu.svelte";
  import Markdown from "../view/m_nav_infotech/m_nav_info_codename/Markdown_md.svelte";
  import Html5 from "../view/m_nav_infotech/m_nav_info_codename/Markup_Html.svelte";
  import CSS3 from "../view/m_nav_infotech/m_nav_info_codename/Stylesheet_css.svelte";
  import About from "../view/m_nav_infotech/m_nav_info_codename/About.svelte";
  import Cosmos from "../view/m_nav_cosmos/img_jamesWebb.svelte";
  import MainSectionBody from "./Main_Section_Body.svelte";
  import MainSectionHeader from "./Main_Section_Header.svelte";
  import Engineering from "../view/m_nav_engineering/Engineering.svelte";
  import USEnglish from "../view/m_nav_language/English.svelte";
  import Deutsche from "../view/m_nav_language/das_Deutsche.svelte";
  import Espanol from "../view/m_nav_language/español.svelte";
  import Francais from "../view/m_nav_language/français.svelte";
  import Pyccknn from "../view/m_nav_language/Русский.svelte";
  import SciFic from "../view/m_nav_sicfic/IronMan.svelte";
  import etC from "../view/m_nav_etc/m_etc.svelte";

  let end_view = [
    { id: "java", name: Java },
    { id: "javaScript", name: JavaScript },
    { id: "python", name: Python },
    { id: "ubuntu", name: Ubuntu },
    { id: "markdown", name: Markdown },
    { id: "html5", name: Html5 },
    { id: "css3", name: CSS3 },
    { id: "about", name: About },
    { id: "cosmos", name: Cosmos },
    { id: "engineering", name: Engineering },
    { id: "usenglish", name: USEnglish },
    { id: "dasdeutsche", name: Deutsche },
    { id: "espanol", name: Espanol },
    { id: "francais", name: Francais },
    { id: "pyccknn", name: Pyccknn },
    { id: "scific", name: SciFic },
    { id: "etc", name: etC },
    //{ id: '', name: },
  ];

  export let url = "";
</script>

<section readonly>
  <MainSectionHeader />

  <Router {url}>
    {#each end_view as { id, name }}
      <Route path={id} component={name} />

      <!-- <Route path="java" component={Java}/>
            <Route path="javaScript" component={JavaScript}/>
            <Route path="python" component={Python}/>
            <Route path="ubuntu" component={Ubuntu}/>
            <Route path="markdown" component={Markdown}/>
            <Route path="html5" component={Html5}/>
            <Route path="css3" component={CSS3}/>
            <Route path="about" component={About}/> -->
    {/each}

    <!-- <div>
            <Route path="framework" component={framework}/>
        </div> -->
  </Router>

  <MainSectionBody />
</section>

<style>
  section {
    border: 3px solid pink;
  }
</style>
