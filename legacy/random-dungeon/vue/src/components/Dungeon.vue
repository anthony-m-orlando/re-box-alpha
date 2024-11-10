<template>
    <div class = "main-content">
        <div id="dungeon-controls">
            <dungeon-controls />
        </div>
        
        <div v-if="this.$store.state.currentHero" id="dungeon-tab-nav">
            <tab-nav />
        </div>

        <div v-if="this.$store.state.currentHero" id="dungeon-tabs">
            <div v-if="this.$store.state.currentTab=='events'">
                <event-tab-vue />
            </div>
            <div v-if="this.$store.state.currentTab=='combat'">
                <combat-tab-vue />
            </div>
            <div v-if="this.$store.state.currentTab=='features'">
                <feature-tab-vue />
            </div>
            <div v-if="this.$store.state.currentTab=='traps'">
                <trap-tab-vue />
            </div>   
            <div v-if="this.$store.state.currentTab=='enemies'"> 
                 <enemy-tab-vue />
            </div>
            
        </div>

    </div>    
   
      
   
</template>





<script>
import DungeonControls from './DungeonControls.vue'
import EnemyTabVue from './EnemyTab.vue'
import FeatureTabVue from './FeatureTab.vue'
import TabNav from './TabNav.vue'
import TrapTabVue from './TrapTab.vue'
import EventTabVue from './EventTab.vue'
import CombatTabVue from './CombatTab.vue'


export default {
    name: 'Dungeon',
    components: {
        DungeonControls,
        EnemyTabVue,
        FeatureTabVue,
        TrapTabVue,
        EventTabVue,
        CombatTabVue,
        TabNav
    },
    data() {
        return {
            message: 'Hello from Dungeon!',
        };
    },
}

</script>

<style scoped>
    .form-group{
        display: flex;
        flex-direction: row;
    }
    .form-input{
        display: block;
    }

</style>
