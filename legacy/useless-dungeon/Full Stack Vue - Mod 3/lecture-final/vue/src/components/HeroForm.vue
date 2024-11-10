<template>
<div class="nes-container is-rounded is-dark">
  <h>Character Sheet</h>
  <form v-on:submit.prevent="submitForm">
    <div class="form-group">
      <input id="name" type="text" class="form-control" v-model="editHero.name" placeholder = "Name" autocomplete="off" />
    </div>
    <div class="form-group">
      <label for="profession">Profession:</label>
      <select id="profession" class="form-control" v-on:change="changeProfession" v-model="this.selectedProfession">
        <option :value="this.selectedProfession" disabled selected>{{ this.selectedProfession.professionName }}</option>
        <option v-for="profession in this.professions" v-bind:key="profession" :value="profession">{{ profession.professionName }}</option>
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
      <button class="nes-btn is-primary" v-on:click="selectHero()">Enter The Dungeon</button>
      <button class="nes-btn is-primary" v-on:click="saveHero()">Save Changes</button>
      <button class="nes-btn is-primary" v-on:click="cancelForm()">Cancel</button>
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
         roomCounter:0,
         selectedProfession: null
      }   
    },
    methods: {
      changeProfession() { 
        this.editHero.profession = this.selectedProfession;
        this.editHero.health = this.selectedProfession.startingHealth;
        this.editHero.defense = this.selectedProfession.startingDefense;
        this.editHero.attack = this.selectedProfession.startingAttack;
      },
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
        this.$store.state.messages.unshift(`DM:> ` + this.editHero.name + ` will enter the Dungeon!`);
        this.$store.state.messages.unshift('DM:> Select New Game or Load Save from the Options Menu.');
      },
      saveHero(){
        if (this.editHero.id == 0) {
          this.editHero = HeroService.addCharacter(this.editHero);
          this.getHeroes();
        } else {
          HeroService.updateCharacter(this.editHero);
        }
        this.cancelForm();
      },
      getHeroes(){
          HeroService.getCharacters()
              .then(response => {
                  this.$store.state.heroes = response.data;
                  alert('Heroes Updated');
              })
                .catch(error => {
                    console.log(error);
              })
      }
    },
    created(){
      this.getProfessionList();
      this.editHero = this.$store.state.editHero;
      this.selectedProfession = this.$store.state.editHero.profession;
    }
}
</script>


