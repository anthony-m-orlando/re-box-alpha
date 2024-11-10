<template>

    <label>Enemies in the Dungeon</label>
    <div class="row" style="width: 15rem;" v-for="(enemy, index) in this.$store.state.combatants" v-bind:key="enemy">
        <div class="collapsible">
            <input v-bind:id="'collapsible-enemy-' + index" type="checkbox" name="collapsible">
            <label v-bind:for="'collapsible-enemy-' + index">{{index+1}} {{ enemy.name }} -- {{enemy.creatureSubType}}</label>
            <div class="collapsible-body">
                <div class="monster-form">
                    <div class="monster-status-input">
                        <select>
                            <option>Alive</option> 
                            <option>Unconscious</option>     
                            <option>Dead</option>    
                            <option>--Conditions--</option>
                            <option>Blinded</option>  
                            <option>Charmed</option>
                            <option>Deafened</option>
                            <option>Frightened</option>  
                            <option>Grappled</option>
                            <option>Invisible</option>    
                            <option>Incapacitated</option>   
                            <option>Paralyzed</option>    
                            <option>Petrified</option>    
                            <option>Poisoned</option>    
                            <option>Prone</option>    
                            <option>Restrained</option>    
                            <option>Stunned</option>    
                        </select>
                    </div>
                    <div class="monster-attack-button">
                        <button class="btn-small" v-on:click="promptForDamage(index)">
                            <img src="src/assets/icons/controls/attack.png" />
                        </button>
                    </div>
                    <div class="monster-heal-button">
                        <button class="btn-small" v-on:click="promptForHeal(index)">
                            <img src="src/assets/icons/controls/heal.png" />
                        </button>
                    </div>
                
                </div>                
                <div class="card" style="width: 20rem;">                    
                    <div class="card-body">
                        <div class="monster-card">    
                            <div class="monster-health">
                                <h4 class="card-title">HP - {{ enemy.hitPoints }}</h4>
                            </div>
                            <div class="monster-ac">
                                <h4 class="card-title">AC - {{ enemy.armorClass }} </h4>
                            </div>
                            <div class="monster-pic">
                                <p><img v-bind:src="`src/assets/icons/monsters/${enemy.imageName}`" class="float-right" alt="Card example image"></p>
                            </div>
                            <div>
                                <button v-on:click="viewEnemy(enemy.creatureId)">View Details</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

        
        
  
</template>

<script>
    import eventService from '../services/EventService';
        export default {
            data(){
                return {
                    damageInput : false
                }
            },
        methods: {
                promptForDamage(index){
                    let damage = prompt("enter damage:");
                    this.$store.state.enemies[index].hitPoints -=damage;                
                },
                promptForHeal(index){
                    let healing = prompt("enter hit points to restore:");
                    this.$store.state.enemies[index].hitPoints +=healing;                
                },
                viewEnemy(index){
                    this.$store.state.viewEnemyIndex = index;
                    this.getEnemyByID();
                },
                getEnemyByID(){
                    eventService.getCreatureById(this.$store.state.viewEnemyIndex)
                        .then(response => {
                            this.$store.state.viewEnemy = response.data;
                        })
                        .catch(error => {
                            console.log(error);
                        })
                }
        }
    }            
    </script>
    
    <style scoped>
        .monster-form{
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            grid-template-areas: 
                "status attack heal"
        }
        .monster-status-input{
            grid-area: status;
            align-self: end;
            justify-self: center;
        }
        .monster-attack-button{
            grid-area: attack;
            align-self: end;
            justify-self: center;
        }
        .monster-heal-button{
            grid-area: heal;
            align-self: end;
            justify-self: center;
        }

        .monster-card {
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            grid-template-areas: 
                "monster-health monster-ac monster-pic"
                "monster-stats monster-stats monster-stats "
        }

        .monster-health{
            grid-area: monster-health;
        }

        .monster-ac {
            grid-area: monster-ac;
        }

        .monster-pic {
            grid-area: monster-pic;
        }

        #monster-stats{
            grid-area: monster-stats;
        }
    </style>