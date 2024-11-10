<template>
    <div v-if="this.$store.state.currentHero">
        <h3 v-if="this.$store.state.currentHero">
            Current Hero: {{ this.$store.state.currentHero.name }}
        </h3>
        <div v-if="this.$store.state.prompt===''">
            <button v-on:click="getNewEvent()">New Room</button>
            <button v-on:click="getNewEvent()">New Hall Section</button>
        </div>
        <div v-if="this.$store.state.prompt==='perception-enemy'">
            {{ this.$store.state.currentHero.name }} Roll for Perception: 
            <input type="text" v-model="this.$store.state.currentHero.perception" />
            <button v-on:click="getRollPerception('perception-enemy')">Roll</button>
        </div>
    </div>
    <div  v-if="!this.$store.state.currentHero">
        Click a Hero From the List below to indicate who is taking the action.
    </div>
</template>

<script>
    export default {
        methods: {
            getNewEvent(){
                this.$store.dispatch('getNewEvent');
            },
            getRollPerception(perceptionType){
                this.$store.dispatch('getRollPerception');
            }
        }
    }
</script>
