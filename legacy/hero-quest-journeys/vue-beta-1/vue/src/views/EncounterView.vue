<template>
    <div class="rpgui-content rpgui-container framed" id="encounter">
       <div v-for="cell in gridCells" :key="cell.x + '-' + cell.y" class="grid-cell">
            <img v-if="cell.icon != null" :key="cell.id" :src="cell.icon" :class="cell.class" />
       </div>
    </div>
</template>

<script>
export default {
    data(){
       return {
            gridCells: [],
            enemies: [
                {
                    id: 0,
                    name: 'Goblin',
                    icon: '/img/icons/monster-icons/goblin.png',
                    class: 'enemy',
                    currentX: 10,
                    currentY: 10
                },
                {
                    id: 1,
                    name: 'Goblin',
                    icon: '/img/icons/monster-icons/goblin.png',
                    class: 'enemy',
                    currentX: 11,
                    currentY: 10
                }
            ]
        }
    },
    methods: {
        navigate(route){
            this.$router.push(route);
        }
    },
    mounted(){
        let goblinCount = 0;
        for (let i = 0; i < 20; i++) {
            for (let j = 0; j < 20; j++) {
                if ((i==10 && j==10) || (i==10 && j==11)){
                    this.gridCells.push({x: i, y: j, id: goblinCount, name: 'Goblin', class: 'enemy', icon: '/img/icons/monster-icons/goblin.png'});
                    goblinCount++;
                } else if ((i==10 && j==19)) {
                     this.gridCells.push({x: i, y: j, id: goblinCount, name: 'Barbarian',class: 'hero', icon: '/img/icons/hero-icons/barbarian.png'});
                } else {
                    this.gridCells.push({x: i, y: j});
                }
            }
        }
    }
}
</script>



<style scoped>

#encounter {
    display: grid;
    grid-template-columns: 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5%;
    grid-template-rows: 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5% 5%;
    height: 875px;
    width: 875px;
    justify-content: center;
    background-image: url("/img/maps/campaign-0/encounter-0.png");
    background-size: contain;  
}

.grid-cell { 
   display: flex;
   border: 1px solid rgba(0, 0, 0, 0.193); 
   justify-content: center;
   align-items: center;
}

.enemy {
    border: 2px solid red; 
    border-radius: 50%;
    background-color: black;
}

.hero {
    border: 2px solid blue; 
    border-radius: 50%;
    background-color: black;
}
</style>

