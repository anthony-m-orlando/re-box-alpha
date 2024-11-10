<template>
    <div class="event-label" v-for="event in this.$store.state.events" v-bind:key="event">
        <div v-if="event.resolved===true">
            {{ event.name }} {{ event.id }} {{ event.resolved }}
        </div>
    </div>
</template>