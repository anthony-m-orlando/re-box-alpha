<template>
<div class="aside-component">
  <div id="current-monster" v-if="this.$store.state.currentMonster">
    <h1>{{ this.$store.state.currentMonster.name }} is in this Room!</h1>
    <p>Armed with: {{ this.$store.state.currentMonster.attackDescription }}</p>
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