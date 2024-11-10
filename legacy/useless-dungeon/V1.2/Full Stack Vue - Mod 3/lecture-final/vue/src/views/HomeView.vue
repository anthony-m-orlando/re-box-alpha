<template>
  <div id="container" class="home-page">
        <header>
            <header-vue />
        </header>
        
        <nav>
            <game-options-vue />
            <monster-card-vue />
        </nav>

        <main>
            <div id = "main-image">
                <main-viewer-vue />
            </div>
            <div id = "main-text">
                <text-output-vue />
            </div>
        </main>

        <aside>
           <character-list-vue />
           <hero-form v-if="this.$store.state.editHero" />
        </aside>

        <footer>
            &copy;2023 Useless Enterprises
        </footer>
    </div>
</template>

<script>
import HeaderVue from '../components/Header.vue';
import GameOptionsVue from '../components/GameOptions.vue';
import CharacterListVue from '../components/CharacterList.vue';
import MainViewerVue from '../components/MainViewer.vue';
import TextOutputVue from '../components/TextOutput.vue';
import HeroForm from '../components/HeroForm.vue';
import MonsterCardVue from '../components/MonsterCard.vue';

export default {
  components: {
    HeaderVue,
    GameOptionsVue,
    CharacterListVue,
    MainViewerVue,
    TextOutputVue,
    HeroForm,
    MonsterCardVue
  }
};
</script>

<style scoped>

header {
    grid-area: header;
}

nav {
    grid-area: nav;
}


aside {
    grid-area: aside;
}

footer {
    grid-area: footer;
}

#container {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
    grid-template-areas:
        "header header header"
        "nav main aside"
        "footer footer footer"
    ;
}

.main-image{
    height: 85vh;
}

.main-text{
    height: 15vh;
}
</style>
