<template>
<div v-if="this.$store.state.currentMonster" class="nes-container is-rounded is-dark">
  <div id="current-monster" v-if="this.$store.state.currentMonster">
    <h1>{{ this.$store.state.currentMonster.name }} is in this Room!</h1>
    <p>Armed with: {{ this.$store.state.currentMonster.attackDescription }}</p>
     <img v-if="this.$store.state.currentMonster.name==='Velociraptor'" class="image" v-bind:src="'http://127.0.0.1:5500/images/monsters/raptor.png'" />  
     <img v-if="this.$store.state.currentMonster.name==='Cyclops'" class="image" v-bind:src="'http://127.0.0.1:5500/images/monsters/cyclops.png'" />  
     <img v-if="this.$store.state.currentMonster.name==='The Gelatinous Cube'" class="image" v-bind:src="'http://127.0.0.1:5500/images/monsters/cube.png'" />  
  </div>
</div>
</template>

<script>
import monsterService from '../services/MonsterService';


export default {
    methods: {
        getMonsters(){
            monsterService.getMonsters()
                .then(response => {
                    this.$store.state.monsters = response.data;
                })
                 .catch(error => {
                     console.log(error);
                })
        }
    },
    created(){
        this.getMonsters();
    }
}
</script>

<style scoped>
.image {
    max-height: 100px;
}
</style>