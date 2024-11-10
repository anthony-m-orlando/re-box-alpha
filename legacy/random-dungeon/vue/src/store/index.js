import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import eventService from '../services/EventService';  
import heroService from '../services/HeroService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      heroes:[],
      events:[],
      enemies:[],
      combatants:[],
      initiativeList:[],
      traps:[],
      features:[],
      viewEnemy: null,
      viewEnemyIndex: null,
      currentHero: null,
      partyCR: 1,
      currentEnemy:{},
      currentTab: 'events',
      tabConfiguration: 'exploration',
      prompt: ''
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      NEW_GAME(){
        //Create New Game

      },
      SET_INITIATIVE(state, heroid, initiative){
        //Update Initiative
        this.state.heroes.find(hero => hero.id === heroid).initiative = initiative;
      },
      ADD_TRAP(state, trap){
        state.traps.push(trap);
      },
      NEW_ROOM() {
          //Randomly Select Event for Room
          //store.dispatch('getRandomEvent()');
      },
      NEW_HALLWAY() {
          //Randomly Select Event for Hall

      },
      SET_HEROES(state, heroes){
        state.heroes = heroes;
      },
      SET_EVENT(state, event){
        if (event.id===1){
          state.prompt = "perception-enemy";
        }
        if (event.id===2){
          state.prompt = "perception-trap";
        }
        if (event.id===3 || event.id===4){
          state.prompt = "";
          event.resolved = true;
          state.events.unshift(event);
        }
      },
      SET_ENEMIES(state, enemies){
        state.enemies = enemies;
      },
      NEW_ENEMY(state){
        let randomNumber = Math.floor(Math.random() * state.enemies.length);
        let maxNumber = state.partyCR +1;
        let enemy = state.enemies[randomNumber];
        enemy.initiative = Math.floor(Math.random() * 20);
        for (let i = 0; i < maxNumber; i++) {
            state.combatants.unshift(enemy);
            enemy.combatantType = 'enemy';
            state.initiativeList.push(enemy);
        }
        state.events.unshift({name: maxNumber + ' ' + enemy.name + 's appear!', resolved: true});
        state.prompt = "";
        state.currentTab = 'combat';
      }
    },
    actions: {
      loadHeroes({commit}){
        heroService.getCharacters().then((response) => {
           commit('SET_HEROES', response.data);
        });
      },
      getNewEvent({commit}){
        eventService.getRandomEvent().then((response) => {
          commit('SET_EVENT', response.data);
        });
      },
      loadCreatures({commit}){
        eventService.getCreaturesForDungeon().then((response) => {
          commit('SET_ENEMIES', response.data);
        });
      },
      getNewTrap({commit}){
        eventService.getRandomTrap().then((response) => {
          commit('ADD_TRAP', response.data);
        });
      },
      getRollPerception({commit}){
        if (this.state.prompt === "perception-enemy"){
          commit('NEW_ENEMY');
          this.state.prompt = "";
        }
        if (this.state.prompt === "perception-trap"){
          this.getNewTrap();
          this.state.prompt = "";
        }
      },
      startCombat({commit}){
        this.state.heroes.forEach(hero => {
          this.state.initiativeList.push(hero);
        });
      }
    }
  });
  return store;
}
