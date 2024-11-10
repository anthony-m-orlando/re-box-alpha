<template>
    <div id="main">
        <img  class="image" v-bind:src="'http://127.0.0.1:5500/images/scenes/scene_' + this.$store.state.currentRoom.id +'.png'">
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
        }
    },
    computed: {
        imageUrl() {
            if(!this.$store.state.currentRoom){
                return 'http://127.0.0.1:5500/images/scenes/scene_' + this.$store.state.currentRoom.id + '.png';
            }
                return 'http://127.0.0.1:5500/images/scenes/scene_0.png';
        }
    },
    created(){
        this.getRooms();
    }
};
</script>


<style scoped>

#main {
    grid-area: main;
    border: white;
    border-style: groove;
    border-radius: 5px;
}
.image {
    width: 100%;
}
</style>