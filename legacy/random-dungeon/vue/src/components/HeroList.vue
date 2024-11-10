<template>
    <div class="hero-list">
        <div v-on:click="setCurrentHero(index)" style="width: 15rem;" v-for="(hero, index) in this.$store.state.heroes" v-bind:key="hero">
            <div class="row flex-spaces child-borders">
            <label class="paper-btn margin" v-bind:for="'modal-hero-' + index">{{ hero.name }}</label>
            </div>
            <input class="modal-state" v-bind:id="'modal-hero-' + index" type="checkbox">
            <div class="modal">
                <label class="modal-bg" v-bind:for="'modal-hero-' + index"></label>
                <div class="modal-body">
                    <label class="btn-close" v-bind:for="'modal-hero-' + index">X</label>
                    <h4 class="modal-title">{{ hero.name }} the {{ hero.heroSpecies }}</h4>
                    <h5 class="modal-subtitle">Level {{ hero.level }} {{ hero.primary_profession_name }}</h5>
                    <p><img v-bind:src="`src/assets/icons/heroes/${hero.imageFile}`" class="float-right" alt="Card example image"></p>
                    <label v-bind:for="'modal-hero-' + index">HP:</label>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

    export default {
        data(){
            return {
                currentHero: 0
            }
        },
        methods: {
            setCurrentHero(index){
                this.currentHero = index;
                this.$store.state.currentHero = this.$store.state.heroes[index];
            }
        }
    }

</script>

<style>

.hero-list {
    display: flex;
    color: white;
    justify-content: space-around;
    align-items: flex-end;
}

.hero-label {
    border-radius: 5px;
    border: 2px solid whitesmoke;
}

</style>