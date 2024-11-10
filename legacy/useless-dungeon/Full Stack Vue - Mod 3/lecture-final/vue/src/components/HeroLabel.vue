<template>
    <div id="characters-details">
        <div class="character-name nes-pointer" v-on:click="showEditHero()">
            {{ hero.name }}
        </div>
        <div class="character-profession">
            {{ hero.profession.professionName }}
        </div>
        <div class="character-image">
            <img v-bind:src="this.heroUrl">    
        </div>
    </div>
</template>

<script>
export default {
    props: ['hero'],
    data(){
       return{
          heroUrl: "http://127.0.0.1:5500/images/characters/character_profile_" + this.hero.id + "_.png"
       }; 
    },
    methods: {
      showEditHero(){
        this.$store.state.editHero = this.hero;
      }
    }
}
</script>

<style scoped>

#characters-details{
    grid-area: characters-details;
    display: grid;
    grid-template-columns:  1fr 1fr 1fr;
    grid-template-areas:
        "character-name character-profession character-image"
    ;
     gap: 10px;
}


</style>