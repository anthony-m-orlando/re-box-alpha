<template>
  <div id="map-view" class="rpgui-content rpgui-container framed">
    <header-vue />
    <navigation-vue />
    <world-map-vue v-if="this.viewMode=='world'" />
    <encounter-map-vue v-if="this.viewMode=='encounter'" />
  </div>
</template>

<script>
import HeaderVue from '../components/Header.vue';
import NavigationVue from '../components/Navigation.vue';
import WorldMapVue from '../components/WorldMap.vue';
import EncounterMapVue from '../components/JourneyMap.vue';

export default {
  components: {
    HeaderVue,
    NavigationVue,
    WorldMapVue,
    EncounterMapVue
  },
  data() {
    return {
      viewMode: 'encounter'
    };
  },
};
</script>

<style scoped>
html {
    width: 100vw;
    height: 100vh;
}

body {
    margin: 0;
    padding: 0;
}

#map-view {
    margin: 0;
    padding: 0;
}
</style>