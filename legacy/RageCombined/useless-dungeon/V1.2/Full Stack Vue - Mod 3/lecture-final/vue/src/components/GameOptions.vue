<template>
    <div id="aside-options" class ="aside-component">
        <div id="options-header">
            <h1>Options</h1>
        </div>
        <div v-on:click="loadSettings()" id="settings-link">
            <p>Settings</p>
        </div>
        <div v-on:click="newGame()" id="new-game-link">
            <p>New Game</p>
        </div>
        <div v-on:click="loadSave()" id="load-save-link">
            <p>Load Save</p>
        </div>
    </div>
</template>

<script>
export default {
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
      loadSettings(){
          alert('Coming Soon!');
      }
    }
}
</script>

<style scoped>

#options-header {
    grid-area: options-header;
}

#settings-link{
    cursor:url('../styles/8bitpoint.png'), auto;
    grid-area: settings-link;
}

#new-game-link{
    cursor:url('../styles/8bitpoint.png'), auto;
    grid-area: new-game-link;
    
}

#load-save-link{
    cursor:url('../styles/8bitpoint.png'), auto;
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