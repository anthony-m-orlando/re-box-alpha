<template>
    <div id="aside-options" class="nes-container is-rounded is-dark">
        <div id="options-header">
            <h1>Options</h1>
        </div>
       <section>
        <button type="button" id="difficultyButton" v-bind:class="getDifficultyButtonStyle" v-on:click="setDifficulty">
            {{ getDifficulty }}
        </button>
        </section>
            <div class = "nes-pointer" v-on:click="newGame()" id="new-game-link">
                <p>New Game</p>
            </div>
            <div class = "nes-pointer" v-on:click="loadSave()" id="load-save-link">
                <p>Load Save</p>
            </div>
    </div>
</template>

<script>
export default {
    data() {
     return {
         difficulty: 'Easy'
      }   
    },
    methods: {
      newGame(){
        if(this.$store.state.selectedHero) {
            this.$store.commit('START_GAME');
        }else{
            this.$store.state.messages.push('DM:> A Hero must be selected first!');
        }
      },
      loadSave(){
          alert('Coming Soon!');
      },
      setDifficulty(){
          if (this.difficulty === 'Easy') {
              this.difficulty = 'Medium';
          } else if (this.difficulty === 'Medium'){
              this.difficulty = 'Hard';
          } else {
              this.difficulty = 'Easy';
          }
          
       }
    },
    computed: {
        getDifficulty(){
            return this.difficulty;
        },
        getDifficultyButtonStyle(){
          if (this.difficulty === 'Easy') {
              return "nes-btn is-success";
          } else if (this.difficulty === 'Medium'){
              return "nes-btn is-warning";
          } else {
              return "nes-btn is-error";
          }
        }
    }
}
</script>

<style scoped>

#options-header {
    grid-area: options-header;
}

#settings-link{
    grid-area: settings-link;
}

#new-game-link{
    grid-area: new-game-link;
    
}

#load-save-link{
    grid-area: load-save-link;
}

#aside-options {
    display: grid;
    grid-template-rows: 4;
    grid-template-areas:
        "options-header"
        "settings-link"
        "new-game-link"
        "load-save-link"
    ;
    gap: 2%;
    padding-bottom: 5%;
}
</style>