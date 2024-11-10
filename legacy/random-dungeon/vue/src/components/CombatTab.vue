<template>
    <div v-if="this.mode==='initiative'">
        <form>
            <div v-for="(hero) in this.$store.state.heroes" v-bind:key="hero">
                <label v-bind:for=hero.id >{{ hero.name }}: Initiative Roll</label>
                <input type="text" v-bind:id=hero.id name="hero1" v-model="hero.initiative">
            </div>
            <input v-on:click="startCombat()" type="submit" value="Submit">
        </form>
    </div>
    <div v-if="this.mode==='combat'">
        <div v-for="initiative in this.$store.state.initiativeList" v-bind:key="initiative">
            <h3>{{ initiative.name }}</h3>
            <p>{{ initiative.initiative }}</p>
        </div>
    </div>
    
</template>

<script>
export default {
    name: 'Combat',
    data() {
        return {
            mode: 'initiative',
            message: 'Hello from Combat!',
        };
    },
    methods: {
        startCombat(){
            this.mode = 'combat';
            this.$store.dispatch('startCombat');
        }
    }
};

</script>

<style scoped>

</style>