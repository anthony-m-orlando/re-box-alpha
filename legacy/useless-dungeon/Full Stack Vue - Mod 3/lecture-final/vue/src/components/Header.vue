<template>
     <div class = "head-banner">
        <h1>Welcome to the Useless Dungeon!</h1>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
            <label class="text">0</label>
        </router-link>
    </div>
</template>

<style scoped>
.head-banner {
    font-family: 'Press Start 2P', sans-serif;
    color: white;
    display: flex;
    align-items: center;
    justify-content: space-between;
    text-align: center;
}

.text {
    font-family: 'Press Start 2P', sans-serif;
    color: white;
}
</style>