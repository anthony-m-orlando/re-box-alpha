<template>
    <div class="rpgui-content"  id="new-journey">
        <div class="rpgui-container framed" id="new-journey-form">
                <h1>New Journey</h1>
                <hr class="golden">
                <label for="journeyName">Journey Name:</label>
                <input type="text" v-model="journeyName" id="journeyName" name="journeyName">
                <hr class="golden">
                <label for="campaign">Select Campaign:</label>
                <select class="rpgui-dropdown" v-model="campaign" id="campaign" name="campaign">
                    <option value="1">Original Campaign</option>
                    <option value="2">Kellars Keep</option>
                    <option value="3">Return of the Witch Lord</option>
                </select>
                <hr class="golden">
                
                <div id="hero-selector">
                  <label for="heroes">Select Heroes:</label>
                  <select id="heroes" class="rpgui-dropdown" v-model="selectedHeroType">
                      <option value="Barbarian">Barbarian</option>
                      <option value="Dwarf">Dwarf</option>
                      <option value="Elf">Elf</option>
                      <option value="Wizard">Wizard</option>
                  </select>

                  <img title="Click to add selected hero" class = "add-button" src="/img/icons/add.png" v-on:click="addHero()" />
                </div>
                
                <hr class="golden">
                <label for="difficulty">Select Difficulty:</label>
                <select class="rpgui-dropdown" v-model="difficulty" id="difficulty" name="difficulty">
                    <option value="1">Casual</option>
                    <option value="2">Normal</option>
                    <option value="3">Hard</option>
                    <option value="4">Nightmare</option>
                </select>
                <br>
                <button class="rpgui-button" v-on:click="navigate('/map-view')">Start Journey</button>
                <button class="rpgui-button" v-on:click="navigate('/')">Cancel</button>
       </div>
       <div v-if="this.heroes.length!=0" class="rpgui-container framed" id="selected-heroes">
            <h1>Current Party</h1>
            <hr class="golden">
            <div class="hero-token" v-for="hero in this.heroes" v-bind:key="hero">
              <img v-bind:src="hero.imagePath" />
              <img title="Click to remove from party" src="/img/icons/remove.png" />
              <img title="Click to edit this hero" src="/img/icons/quill.png" />
              <p>{{hero.name}}</p>
            </div>
       </div>
    </div>
</template>


<script>
export default {
    data(){
        return {
            journeyName: '',
            campaign: '',
            selectedHeroType: null,
            heroes: [],
            difficulty: ''
        }       
    },
    methods: {
       navigate(route){
            this.$router.push(route);
        },
        addHero() {
            if(this.selectedHeroType != null){
              this.heroes.push(this.getHeroStats(this.selectedHeroType));
            }
        },
        getHeroStats(heroType) {
          
          let hero = {
            name: '',
            type: '',
            attackDice: 0,
            defendDice: 0,
            bodyPoints: 0,
            mindPoints: 0,
            moveDice: 2,
            imagePath: ''
          };

          if (heroType==='Barbarian') {
            hero.name = 'Barbarian';
            hero.type = 'Barbarian';
            hero.attackDice = 3;
            hero.defendDice = 2;
            hero.bodyPoints = 8;
            hero.mindPoints = 2;
            hero.imagePath = '/img/icons/Barbarian.png';
          }
          
          if (heroType==='Dwarf') {
            hero.name = 'Dwarf';
            hero.type = 'Dwarf';
            hero.attackDice = 2;
            hero.defendDice = 2;
            hero.bodyPoints = 7;
            hero.mindPoints = 3;
            hero.imagePath = '/img/icons/Dwarf.png';
          }

          if (heroType==='Elf') {
            hero.name = 'Elf';
            hero.type = 'Elf';
            hero.attackDice = 2;
            hero.defendDice = 2;
            hero.bodyPoints = 6;
            hero.mindPoints = 4;
            hero.imagePath = '/img/icons/Elf.png';
          }

          if (heroType==='Wizard') {
            hero.name = 'Wizard';
            hero.type = 'Wizard';
            hero.attackDice = 2;
            hero.defendDice = 2;
            hero.bodyPoints = 4;
            hero.mindPoints = 6;
            hero.imagePath = '/img/icons/Wizard.png';
          } 

          return hero;

        }
    }
}

</script>


<style scoped>

#new-journey{
  position: relative;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

 #new-journey-form {
  position: relative;
  max-height: 50vh;
}

#selected-heroes {
  position: relative;
  max-height: 50vh;
}

#campaign {
  background-color: brown;
}

#heroes {
  background-color: brown;
}

#difficulty {
  background-color: brown;
}

.hero-selector{
  display: flex;
  flex-direction: row;
  justify-items: center;
}

.hero-token {
  display: flex;
  flex-direction: row;
  justify-items: center;
  border-style: groove;
  border-color: gold;
  border-radius: 5%;
}

.add-button {
  cursor: rpgui-cursor-select;
}

</style>