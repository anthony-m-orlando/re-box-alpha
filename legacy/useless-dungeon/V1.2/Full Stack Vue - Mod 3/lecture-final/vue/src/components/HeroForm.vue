<template>
<div class="aside-component">
  <h1>Character Sheet</h1>
  <h2>{{ this.$store.state.currentGame }}</h2>
  <form v-on:submit.prevent="submitForm">
    <div class="form-group">
      <label for="name">Name:</label>
      <input id="name" type="text" class="form-control" v-model="editHero.name" autocomplete="off" />
    </div>
    <div class="form-group">
      <label for="profession">Profession:</label>
      <select id="profession" class="form-control" v-model="this.editHero.profession.professionId">
        <option v-for="profession in this.professions" v-bind:key="profession.professionId" :value="profession.professionId">{{ profession.professionName }}</option>
      </select>
    </div>
    <div class="form-group">
      <label>Health:</label>
      <label>{{ this.editHero.health }}</label>
    </div>
    <div class="form-group">
      <label>Defense:</label>
      <label>{{ this.editHero.defense }}</label>
    </div>
    <div class="form-group">
      <label>Attack:</label>
      <label>{{ this.editHero.attack }}</label>
    </div>
    <div v-show="!this.$store.state.currentGame">
      <button class="btn btn-submit" v-on:click="selectHero()">Enter The Dungeon</button>
      <button class="btn btn-submit" disabled>Save Changes</button>
      <button class="btn btn-cancel" v-on:click="cancelForm()">Cancel</button>
      
    </div>
    <div v-show="this.$store.state.currentGame">
      <button class="btn btn-submit" v-on:click="attack()">Attack</button>
      <button class="btn btn-submit" v-on:click="leaveRoom()">Leave</button>
      <button class="btn btn-cancel" v-on:click="anything()">Try Anything!</button>
    </div>
  </form>
  </div>
</template>

<script>
import HeroService from '../services/HeroService'

export default {
    data() {
     return {
         editHero: {},
         selected: "",
         professions: [],
         roomCounter:0
      }   
    },
    methods: {
        getProfessionList(){
          HeroService.getProfessionList()
          .then(response => {
            this.professions = response.data;
          })
          .catch(error =>{
            console.log(error);
          })
        },
        cancelForm(){
          this.$store.state.editHero = null;
        },
        selectHero(){
          this.$store.state.selectedHero = this.editHero;
          //this.$store.state.editHero = null;
          this.$store.state.messages.unshift(`DM:> ` + this.editHero.name + ` will enter the Dungeon!`);
          this.$store.state.messages.unshift('DM:> Select New Game or Load Save from the Options Menu.');
          
        },
        leaveRoom(){
          this.$store.commit('NEXT_ROOM');
        },
        attack(){
          this.$store.commit('ATTACK');
        },
        anything(){
          this.$store.commit('ANYTHING');
        }
    },
    created(){
      this.getProfessionList();
      this.professions = HeroService.getProfessionList();
      this.editHero = this.$store.state.editHero;
      this.selected = this.$store.state.editHero.profession.professionId;
    }
}
</script>


