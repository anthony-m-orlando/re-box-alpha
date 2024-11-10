<template>
    <div id= "aside-character" class="nes-container is-rounded is-dark">
        <div id="characters-header">
            <h1>Characters</h1>
        </div>
       <div v-for="hero in this.$store.state.heroes" v-bind:key="hero">
           <p><hero-label-vue :hero=hero /></p>
       </div>
       <div id="characters-header">
        <button type="button" class="nes-btn is-primary" id="newCharacterButton" v-on:click="newHero()">
           New Hero
        </button>
        </div>
    </div>
</template>

<script>
import heroService from '../services/HeroService';
import HeroLabelVue from './HeroLabel.vue';


export default {
    components: {
            HeroLabelVue
    },
    methods: {
        getHeroes(){
            heroService.getCharacters()
                .then(response => {
                    this.$store.state.heroes = response.data;
                })
                 .catch(error => {
                     console.log(error);
                })
        },
        newHero() {
             this.$store.commit('NEW_HERO');
        }
    },
    created(){
        this.getHeroes();
    }
}
</script>


<style scoped>

.characters-header {
    grid-area: character-header;
}

#aside-character {
    display: grid;
    grid-template-rows: 2;
    grid-template-areas:
        "character-header"
        "characters-details"
    ;
    gap: 10px;
}
</style>