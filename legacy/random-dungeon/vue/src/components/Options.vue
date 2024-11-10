<template>
    <div>
       <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">
            <label class="text">Home |</label>
        </router-link>
        <router-link v-bind:to="{ name: 'home' }">
            <label class="text">Settings |</label>
        </router-link>
        <router-link v-bind:to="{ name: 'logout' }">
            <label class="text">Logout</label>
        </router-link>
    </div>  
</template>
<style scoped>

.options-nav {
    display: flex;
    align-items: top;
    align-content: flex-end;
    border: 1px solid black;   
}

.text {
    font-size: 1.5em;
    font-family: 'MedievalSharp', cursive;
}
</style>