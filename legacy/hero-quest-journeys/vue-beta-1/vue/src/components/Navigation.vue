<template>
    <div id="nav-buttons" class="rpgui-container framed">
        <button id="new-journey" class="rpgui-button" v-on:click="this.navigate('new-journey')">New Journey</button>
        <button id="load-journey" class="rpgui-button"  v-on:click="navigate('load-journey')">Load Journey</button>
        <button id="load-journey" class="rpgui-button" v-on:click="navigate('logout')">Log Out</button>
    </div>
</template>

<script>

export default {
    data(){
       
    },
    methods: {
        navigate(route){
            this.$router.push(route);
        }
    }
}
</script>

<style scoped>
#nav-buttons {
    position: relative;
    display: flex;
    justify-content: space-around;
    align-items: center;
}
</style>