<template>
    <div id="monster-profile">
        <div id="monster-title">
            <h2>Monster Name: {{ this.$store.state.viewEnemy.name }}</h2>
        </div>
        <div id="close-button" >
                <button v-on:click="closeView()" class="btn-danger">X</button>
        </div>
        <div id="monster-stats-core">
            <div id="monster-core" v-if="this.viewTab == 0">
                <h4>Core Stats</h4>
                <h5>Hit Points: {{ this.$store.state.viewEnemy.hitPoints }}</h5>
                <h5>Hit Dice: {{ this.$store.state.viewEnemy.hitDice }}</h5>
                <h5>Armor Class: {{ this.$store.state.viewEnemy.armorClass }}</h5>
                <h5>Armor Type: {{ this.$store.state.viewEnemy.armorType }} </h5>
                <h5>Size: {{ this.$store.state.viewEnemy.size }}</h5>
                <h5>Type: {{ this.$store.state.viewEnemy.creatureType }}</h5>
                <h5>Subtype: {{ this.$store.state.viewEnemy.creatureSubType }}</h5>
                <h5>Alignment: {{ this.$store.state.viewEnemy.alignment }}</h5>
                <h5>Speed: {{ this.$store.state.viewEnemy.speed }}</h5>
                <h5>Challenge Rating: {{ this.$store.state.viewEnemy.challengeRating }}</h5>
                
            </div>
            <div id="monster-abilities" v-if="this.viewTab == 1">
                <h4>Abilities</h4>
                <table>
                    <thead>
                        <tr>
                        <th>Ability</th>
                        <th>Score</th>
                        <th>Modifier</th>
                        <th>Save</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        <td>Strength</td>
                        <td>{{ this.$store.state.viewEnemy.strength }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.strength) }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.strength) + getCreatureSave('Strength') }}</td>
                        </tr>
                        <tr>
                        <td>Dexterity</td>
                        <td>{{ this.$store.state.viewEnemy.dexterity }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.dexterity) }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.dexterity) + getCreatureSave('Dexterity') }}</td>
                        </tr>
                        <tr>
                        <td>Constitution</td>   
                        <td>{{ this.$store.state.viewEnemy.constitution }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.constitution) }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.constitution) + getCreatureSave('Constitution') }}</td>
                        </tr>
                        <tr>
                        <td>Intelligence</td>
                        <td>{{ this.$store.state.viewEnemy.intelligence }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.intelligence) }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.intelligence) +  getCreatureSave('Intelligence') }}</td>
                        </tr>
                        <tr>
                        <td>Wisdom</td>
                        <td>{{ this.$store.state.viewEnemy.wisdom }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.wisdom) }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.wisdom) + getCreatureSave('Wisdom') }}</td>
                        </tr>
                        <tr>
                        <td>Charisma</td>
                        <td>{{ this.$store.state.viewEnemy.charisma }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.charisma) }}</td>
                        <td>{{ getModifier(this.$store.state.viewEnemy.charisma) + getCreatureSave('Charisma') }}</td>
                        </tr>
                    </tbody>
                </table>
            </div>

             <div id="monster-skills-core" v-if="this.viewTab == 2">
                <h4>Skills</h4>
                <table>
                    <thead>
                        <tr>
                        <th>Skill</th>
                        <th>Ability</th>
                        <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="skill in skillList" :key="skill.id">
                        <td>{{ skill.name }}</td>
                        <td>{{ skill.abilityScore }}</td>
                        <td>{{ getSkillModifier(skill.name) }}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div id="monster-abilities-actions" v-if="this.viewTab == 3">
                <h4>Actions</h4>
                <table>
                    <thead>
                        <tr>
                            <th>Type</th>
                            <th>Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="action in this.$store.state.viewEnemy.actions" :key="action.id">
                            <td>{{ action.actionType }}</td>
                            <td>{{ action.actionDescription }}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
             <div id="monster-abilities-traits" v-if="this.viewTab == 4">
                <h4>Traits and Languages</h4>
                <div v-for="trait in this.$store.state.viewEnemy.traits" :key="trait.traitId">
                    <h5>Trait: {{ trait.description }}</h5>
                </div>
                <div v-for="language in this.$store.state.viewEnemy.languages" :key="language.languageId">
                    <h5>Language: {{ language.name }}</h5>
                </div>
            </div>
         </div>

        <div id="monster-image-profile">
            <img v-bind:src="`src/assets/icons/monsters/${this.$store.state.viewEnemy.imageName}`" alt="Card example image">
        </div>
        <div id="tab-buttons">
            <button v-on:click="changeViewTab()">Next--></button>    
        </div>
    </div>
</template>


<script>
import HeroService from '../services/HeroService';

export default {
    data() {
        return {
            skillList: [],
            viewTab: 0
        }
    },
    methods: {
        changeViewTab() {
            this.viewTab++;
            if (this.viewTab > 4) {
                this.viewTab = 0;
            }
        },
        closeView(){
            this.$store.state.viewEnemy = null;
            this.$store.state.viewEnemyIndex = null;
        },
        getCreatureSave(ability) {
            const filter = ability;
            let result = 0;
            if (this.$store.state.viewEnemy.saves.length > 0) {
                    for (let i = 0; i < this.$store.state.viewEnemy.saves.length; i++) {
                        if (this.$store.state.viewEnemy.saves[i].ability === filter) {
                            result += this.$store.state.viewEnemy.saves[i].modifier;
                        } 
                    }
            }
            return result;
        },
        getModifier(score) {
            if (score === 1) {
                return -5;
            } else if (score === 2 || score === 3) {
                return -4;
            } else if (score === 4 || score === 5) {
                return -3;
            } else if (score === 6 || score === 7) {
                return -2;
            } else if (score === 8 || score === 9) {
                return -1;
            } else if (score === 10 || score === 11) {
                return 0;
            } else if (score === 12 || score === 13) {
                return 1;
            } else if (score === 14 || score === 15) {
                return 2;
            } else if (score === 16 || score === 17) {
                return 3;
            } else if (score === 18 || score === 19) {
                return 4;
            } else if (score === 20 || score === 21) {
                return 5;
            } else if (score === 22 || score === 23) {
                return 6;
            } else if (score === 24 || score === 25) {
                return 7;
            } else if (score === 26 || score === 27) {
                return 8;
            } else if (score === 28 || score === 29) {
                return 9;
            } else if (score === 30) {
                return 10;
            }
        },
        getAllSkills() {
            HeroService.getAllSkills()
                .then(response => {
                    this.skillList = response.data;
                })
                .catch(error => {
                    console.log(error);
                });
        },
        getSkillModifier(skill) {
            let result = 0;
            let ability = '';
            if (this.$store.state.viewEnemy.proficiencies.length > 0) {
                for (let i = 0; i < this.$store.state.viewEnemy.proficiencies.length; i++) {
                    if (this.$store.state.viewEnemy.proficiencies[i].skill.name === skill) {
                        result += this.$store.state.viewEnemy.proficiencies[i].modifier;
                    }
                    
                }
            }
            ability = this.skillList.find(x => x.name === skill).abilityScore;
            if (ability == 'Strength') {
                result += this.getModifier(this.$store.state.viewEnemy.strength);
            } else if (ability == 'Dexterity') {
                result += this.getModifier(this.$store.state.viewEnemy.dexterity);
            } else if (ability == 'Constitution') {
                result += this.getModifier(this.$store.state.viewEnemy.constitution);
            } else if (ability == 'Intelligence') {
                result += this.getModifier(this.$store.state.viewEnemy.intelligence);
            } else if (ability == 'Wisdom') {
                result += this.getModifier(this.$store.state.viewEnemy.wisdom);
            } else if (ability == 'Charisma') {
                result += this.getModifier(this.$store.state.viewEnemy.charisma);
            }
            
            
            return result;
        }
    },
    mounted () {
        this.getAllSkills();
    }
}
</script>

<style scoped>
        #monster-profile {
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            grid-template-areas: 
                "monster-title monster-title close-button"
                "monster-stats-core monster-stats-core monster-image-profile";
            background-color: #f3f3f3;
        }
        #monster-title {
            grid-area: monster-title;
            align-self: end;
            justify-self: center;   
            display: flex;
        }
        #close-button {
            align-self: start;
            justify-self: end;
            grid-area: close-button;
        }
        #monster-stats-core {
            grid-area: monster-stats-core;
        }
        #monster-abilities-saves {
            grid-area: monster-abilities-saves;
            align-self: end;
            justify-self: center;
        }
        #monster-image-profile {
            grid-area: monster-image-profile;
            display: flex;
            align-self: start;
            justify-self: end;
        }
        #monster-skills-core {
            grid-area: monster-skills-core;
            
        }
</style>