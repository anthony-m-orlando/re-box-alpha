<template>
  <div class="rpgui-content rpgui-container framed">
    <header-vue />
    <navigation-vue />
    <new-journey-form-vue />
  </div>
    
</template>

<script>
import HeaderVue from '../components/Header.vue';
import NavigationVue from '../components/Navigation.vue';
import NewJourneyFormVue from '../components/NewJourneyForm.vue';


export default {
  components: {
    HeaderVue,
    NavigationVue,
    NewJourneyFormVue
  }
};
</script>

<style scoped>
html {
    width: 100vw;
    height: 100vh;
}

</style>