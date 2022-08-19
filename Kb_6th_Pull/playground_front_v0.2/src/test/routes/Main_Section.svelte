<script>
    import { Router, Link, Route } from "svelte-routing";
    import Java from "../view/m_nav_infotech/m_nav_info_codename/Language_Java.svelte"
    import JavaScript from "../view/m_nav_infotech/m_nav_info_codename/Language_JavaScript.svelte"
    import Python from "../view/m_nav_infotech/m_nav_info_codename/Language_Python.svelte"
    import Ubuntu from "../view/m_nav_infotech/m_nav_info_codename/Linux_Ubuntu.svelte"
    import Markdown from "../view/m_nav_infotech/m_nav_info_codename/Markdown_md.svelte"
    import Html5 from "../view/m_nav_infotech/m_nav_info_codename/Markup_Html.svelte"
    import CSS3 from "../view/m_nav_infotech/m_nav_info_codename/Stylesheet_css.svelte"
    import About from "../view/m_nav_infotech/m_nav_info_codename/About.svelte";

    let codename = [
            { id: 'java',       name: Java       }, 
            { id: 'javaScript', name: JavaScript }, 
            { id: 'python',     name: Python     },     
            { id: 'ubuntu',     name: Ubuntu     },    
            { id: 'markdown',   name: Markdown   }, 
            { id: 'html5',      name: Html5     },   
            { id: 'CSS3',       name: CSS3       },   
            { id: 'about',      name: About      }, 
        ];
    

    export let url="";
</script>


<section readonly>

    <Router {url}>

        {#each codename as {id, name}}
            <Route path="{id}" component={name} />
            
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

</section>



<style>
    section{
        border: 3px solid pink;
    }
</style>