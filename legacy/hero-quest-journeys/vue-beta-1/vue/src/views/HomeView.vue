<template>
  <div id="home-view" class="rpgui-content rpgui-container framed">
    <header-vue />
    <navigation-vue />
    <front-cover-vue />
  </div>
</template>

<script>
import HeaderVue from '../components/Header.vue';
import NavigationVue from '../components/Navigation.vue';
import FrontCoverVue from '../components/FrontCover.vue';

export default {
  components: {
    HeaderVue,
    NavigationVue,
    FrontCoverVue
  }
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

#home-view {
    margin: 0;
    padding: 0;
}
</style>