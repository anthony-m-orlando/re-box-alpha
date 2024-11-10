<template>
    <div id= "aside-character" class ="aside-component">
        <div id="characters-header">
            <h1>Characters</h1>
        </div>
       <div v-for="hero in heroes" v-bind:key="hero">
           <p><hero-label-vue :hero=hero /></p>
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
    data() {
        return {
            heroes:[]
        };
    },
    methods: {
        getHeroes(){
            heroService.getCharacters()
                .then(response => {
                    this.heroes = response.data;
                })
                 .catch(error => {
                     console.log(error);
                })
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