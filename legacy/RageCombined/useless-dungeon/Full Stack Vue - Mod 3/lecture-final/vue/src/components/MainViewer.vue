<template>
    <div id="main" v-bind:style="{ backgroundImage: 'url(' + this.imageUrl + ')' }">
        <div id="game-options" v-show="this.$store.state.currentGame">
            <button class="nes-btn is-primary" v-on:click="attack()">Attack</button>
            <button class="nes-btn is-primary" v-on:click="anything()">Try Anything!</button>
            <button class="nes-btn is-primary" v-on:click="leaveRoom()">Leave</button>
        </div>
        <div id="monster-image" v-if="this.$store.state.currentMonster">
            <img v-if="this.$store.state.currentMonster.name==='Velociraptor'" class="image" v-bind:src="'http://127.0.0.1:5500/images/monsters/raptor.png'" />  
            <img v-if="this.$store.state.currentMonster.name==='Cyclops'" class="image" v-bind:src="'http://127.0.0.1:5500/images/monsters/cyclops.png'" />  
            <img v-if="this.$store.state.currentMonster.name==='The Gelatinous Cube'" class="image" v-bind:src="'http://127.0.0.1:5500/images/monsters/cube.png'" />
        </div>
    </div>
</template>

<script>
import roomService from '../services/RoomService'

export default {
    data(){
       
    },
    methods: {
        getRooms(){
            roomService.getRooms()
                .then(response => {
                    this.$store.state.rooms = response.data;
                })
                 .catch(error => {
                     console.log(error);
                })
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
    computed: {
        imageUrl() {
            if(!this.$store.state.currentRoom.id==0){
                return 'http://127.0.0.1:5500/images/scenes/scene_' + this.$store.state.currentRoom.id + '.png';
            } else {
                return 'http://127.0.0.1:5500/images/scenes/scene_0.png';
            }
        }
    },
    created(){
        this.getRooms();
    }
};
</script>


<style scoped>

#main {
    display: flex;
    flex-direction: column;
    grid-area: main;
    border: white;
    border-style: groove;
    border-radius: 5px;
    height: 60vh;
    background-size: cover;
    background-repeat: no-repeat;
}


#game-options {
    display: flex;
    justify-content: space-between;
}

#monster-image {
    margin-top: auto;
}

</style>