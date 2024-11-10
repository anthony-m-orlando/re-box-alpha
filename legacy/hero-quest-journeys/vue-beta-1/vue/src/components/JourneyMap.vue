<template>
    <div class="rpgui-content"  id="encounter">
        <div class="rpgui-container framed" id="encounter-navigator">
            <div class="encounter-item" v-for="encounter in encounters" v-bind:key="encounter.id">
                <input v-model="encounter.status" class="rpgui-checkbox" type="checkbox"><label> {{ encounter.name}}</label>
            </div>
        </div>
        <div class="rpgui-container framed" id="encounter-viewer">
            <div id="trail-map">
                <img id="travel-path-image" src="/img/maps/campaign-0/travel-0-1.jpg">
                <button id="new-journey" class="rpgui-button" v-on:click="this.navigate('encounter-view')">Start Encounter</button>
            </div>
        </div>
    </div>
</template>



<script>

export default {

    data(){
        return{
            encounters: [
                {
                    id: 0,
                    name: 'Tutorial Part One',
                    description: 'After several hours on the road, the heroes come across something interesting...',
                    img: '/img/maps/campaign-0/travel-0-1.jpg',
                    status: 'true'
                },
                {
                    id: 1,
                    name: 'Tutorial Part Two',
                    description: 'On the road back from the Tomb, the heroes are ambushed by scouts for the Blackvenom Tribe!',
                    img: '/img/maps/campaign-0/travel-0-2.jpg',
                    status: 'false'
                },
                {
                    id: 2,
                    name: 'Journey to the Lair of the Orcs',
                    description: 'On the road back from the Tomb, the heroes are ambushed by scouts for the Blackvenom Tribe!',
                    img: '/img/maps/campaign-0/travel-0-2.jpg',
                    status: 'false'
                },
                 {
                    id: 3,
                    name: 'Returning with Sir Ragnar',
                    description: 'On the road back from the Tomb, the heroes are ambushed by scouts for the Blackvenom Tribe!',
                    img: '/img/maps/campaign-0/travel-0-2.jpg',
                    status: 'false'
                }
            ]
        }
    },
    methods: {
     navigate(route){
            this.$router.push(route);
        }
    },
    mounted(){
        
    }
}
</script>

<style scoped>

#encounter {
    position: relative;
    display: flex;
    flex-direction: column;
    justify-content:flex-start;
    align-items: center;
    margin: 0;
    padding: 0;
}

#encounter-navigator{
     position: relative;
     display: flex;
     justify-content: space-around;
     width: 99vw;
}

.encounter-item {
    margin-right: 1rem;
    border: 1px solid gold;
}


#encounter-viewer {
    position: relative;
    width: 99vw;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: row;
    justify-content: center;
}

#travel-path-image {
  max-height: 44vh;
}



#trail-map {
    position: relative;
    max-width: 80vw;
}

</style>