<template>
    <div class="tab">
        <button class="tablinks" @click="openTab('events')">Events</button>
        <button v-if="this.$store.state.tabConfiguration=='combat'" class="tablinks" @click="openTab('combat')">Combat</button>
        <button class="tablinks" @click="openTab('traps')">Traps</button>
        <button class="tablinks" @click="openTab('features')">Features</button>
        <button class="tablinks" @click="openTab('enemies')">Enemies</button>
    </div>    
</template>

<script>

export default {
    data(){
        return {}
    },
    methods:{
        openTab(tabName){
            this.$store.state.currentTab = tabName;
        }
    }
}
</script>
