<script>
	import Header from "../../lib/Header.svelte";
	import Navigations from "../../lib/Navigitions.svelte";
	import Section from "../../lib/Section.svelte"
	import Footer from "../../lib/Footer.svelte";
</script>
<!--
		Google font:
	   'Do Hyeon', sans-serif;
	   'East Sea Dokdo', cursive;
	   'Hi Melody', cursive;
	   'Stylish', sans-serif;
	   'Noto Sans KR',sans-serif;
 -->
<svelte:head>
	<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=East+Sea+Dokdo&family=Hi+Melody&family=Noto+Sans+KR:wght@400&family=Stylish&display=swap"
	rel="stylesheet"
	/>
	<title>Under repair Lab</title>
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