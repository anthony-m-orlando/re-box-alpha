<template>
    <div id="text" class = "main-text">
        <p v-for="message in this.messages" v-bind:key="message">{{ message }}</p>
    </div>
</template>

<script>

export default {
    data() {
     return {
         selectedHero: {},
         messages: []
      }   
    },  
    created(){
        this.$store.state.messages.push('DM:> Welcome to the Dungeon....');
        this.$store.state.messages.unshift('DM:> Choose a Character');
        this.messages = this.$store.state.messages;
    }
}
</script>

<style scoped>

.main-text {
    background-color: blue;
    border: white;
    border-style: groove;
    border-radius: 5px;
    font-family: 'Press Start 2P';
    overflow-y: scroll;
}
</style>


