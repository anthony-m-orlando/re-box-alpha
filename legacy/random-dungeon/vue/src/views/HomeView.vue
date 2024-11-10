<template>
  <div id="home-view" class="home">

    <header id="main-header">
       <title-vue />
    </header>

    <nav id = "options">
      <options-vue />
    </nav>

    <aside id="hero-list">
       <hero-list-vue />
    </aside>

    <main id="table-top">
        <main-content-vue />
    </main>

  </div>

</template>

<script>
//Components
import TitleVue from '../components/Title.vue';
import OptionsVue from '../components/Options.vue';
import MainContentVue from '../components/Dungeon.vue';
import HeroListVue from '../components/HeroList.vue';



export default {
  components: {
    TitleVue,
    OptionsVue,
    MainContentVue,
    HeroListVue
  },
  created(){
    this.$store.dispatch('loadHeroes');
    this.$store.dispatch('loadCreatures');
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=MedievalSharp&display=swap');


  #main-header {
    grid-area: main-header;
    height: 10vh;
  }


  #hero-list {
    grid-area: hero-list;
    height: 25vh;
  }

  #table-top {
    grid-area: table-top;
    height: 75vh;
  }  
  
  #options {
    grid-area: options;
    height: 10vh;
  }

  
  #home-view {
    display: grid;
    grid-template-columns: 2fr 1fr;
    grid-template-areas:
      "main-header options"
      "table-top table-top"
      "hero-list hero-list";
      font-family: "MedievalSharp", cursive;  
  }

</style>