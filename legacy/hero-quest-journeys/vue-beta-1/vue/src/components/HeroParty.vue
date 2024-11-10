<template>
    <div class="rpgui-content"  id="hero-party">
        <div v-if="this.heroes.length!=0" class="rpgui-container framed" id="selected-heroes">
            <h1>Current Party</h1>
            <hr class="golden">
            <div class="hero-token" v-for="hero in this.heroes" v-bind:key="hero">
              <img v-bind:src="hero.imagePath" />
              <img title="Click to remove from party" src="/img/icons/remove.png" />
              <img title="Click to edit this hero" src="/img/icons/quill.png" />
              <p>{{hero.name}}</p>
            </div>
       </div>

    </div>
</template>

<script>
export default {
    data(){
        return {
            heroes: [
                {
                    name: 'Barbarian',
                    type: 'Barbarian',
                    attackDice: 3,
                    defendDice: 2,
                    bodyPoints: 8,
                    mindPoints: 2,
                    moveDice: 2,
                    imagePath: '/img/icons/Barbarian.png'
                },
                {
                    name: 'Dwarf',
                    type: 'Dwarf',
                    attackDice: 2,
                    defendDice: 3,
                    bodyPoints: 10,
                    mindPoints: 1,
                    moveDice: 1,
                    imagePath: '/img/icons/Dwarf.png'
                },
                {
                    name: 'Elf',
                    type: 'Elf',
                    attackDice: 2,
                    defendDice: 2,
                    bodyPoints: 6,
                    mindPoints: 4,
                    moveDice: 3,
                    imagePath: '/img/icons/Elf.png'
                },
                {
                    name: 'Wizard',
                    type: 'Wizard',
                    attackDice: 1,
                    defendDice: 1,
                    bodyPoints: 4,
                    mindPoints: 8,
                    moveDice: 2,
                    imagePath: '/img/icons/Wizard.png'
                }
            ]
        }       
    }
    }
</script>

<style scoped>
#new-journey{
  position: relative;
  display: flex;
  flex-direction: row;
  justify-content: center;
}

#selected-heroes {
  position: relative;
  max-height: 50vh;
}

#heroes {
  background-color: brown;
}

</style>