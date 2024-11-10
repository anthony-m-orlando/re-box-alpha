<template>
    <div class="rpgui-content rpgui-container framed-golden" id="login">
    <header-vue />
    <navigation-vue />
    <div class="rpgui-container framed-golden" id="login-form">
      <form v-on:submit.prevent="login">
        <h1 id="sign-in-message">Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <button class="rpgui-button" v-on:click="login()" type="button">Sign in</button>
        <p>
        <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
      </form>
    </div>
  </div>
</template>

<script>
import HeaderVue from '../components/Header.vue';
import NavigationVue from '../components/Navigation.vue';
import authService from "../services/AuthService";

export default {
  components: {
    HeaderVue,
    NavigationVue
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
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


#login {
  position: relative;
  display: flex;
  flex-direction: column;
  height: 100vh;
  margin: 0;
  padding: 0;
}

#login-form {
  position: relative;
  align-self: center;
  width: 50vw;
}

.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}

#sign-in-message{
  color: gold;
  font-size: 2.5rem;
  font-family: "MedievalSharp", cursive;
  font-weight: 800;
  text-shadow: 2px 2px rgb(219, 47, 47);
}

label{
  color: gold;
  font-size: 1.5rem;
  font-family: "MedievalSharp", cursive;
  font-weight: 800;
  text-shadow: 2px 2px rgb(219, 47, 47);
}

#username{
  width: 100%;
  height: 2rem;
  font-size: 1.5rem;
  font-family: "MedievalSharp", cursive;
  font-weight: 800;
  text-shadow: 2px 2px rgb(219, 47, 47);
}

</style>