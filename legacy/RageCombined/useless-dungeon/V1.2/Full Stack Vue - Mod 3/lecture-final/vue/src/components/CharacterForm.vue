<template>
    <form v-on:submit.prevent="submitForm">
        <div class="form-group">
            <label for="name">Title:</label>
            <input id="name" type="text" class="form-control" v-model="character.title" autocomplete="off" />
       </div>
        <div class="form-group">
            <label for="name">Profession:</label>
            <input id="profession" type="text" class="form-control" v-model="character.profession" autocomplete="off" />
       </div>
    </form>
</template>