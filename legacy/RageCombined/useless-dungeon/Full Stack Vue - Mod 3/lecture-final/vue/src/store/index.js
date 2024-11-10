import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      editHero: null,
      currentMonster: null,
      selectedHero: null,
      heroes:[],
      messages:[],
      currentGame: '',
      rooms:[],
      monsters:[],
      currentRoom: {id:0},
      roomCounter: null,
      gameDifficulty: 'Easy',
      emptyHero: {
          id: 0,
          name: '',
          health: 0,
          defense: 0,
          profession: {
              professionId: 0,
              professionName: '',
              startingHealth: 0,
              startingDefense: 0,
              startingAttack: 0
          },
          attack: 0
      }
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
      START_GAME(state) {
        state.currentGame = 'new';
        state.roomCounter = 0;
        state.messages.unshift('DM:> Starting New Game');
        state.currentRoom = state.rooms[state.roomCounter];
        state.currentMonster = state.monsters[state.roomCounter];
      },
      NEXT_ROOM(state){
        state.roomCounter++;
        if(state.roomCounter == 4){
          state.roomCounter = 0;
        }
        state.currentRoom = state.rooms[state.roomCounter]; 
        state.currentMonster = state.monsters[state.roomCounter];
        state.messages.unshift(`DM:> ` + state.currentRoom.description);
      },
      ATTACK(state){
        if(state.roomCounter!=0){
          state.messages.unshift(`DM:> You Attack causing:` + state.selectedHero.attack + ' damage!');
          state.messages.unshift(`DM:> ` + state.currentMonster.name + ' Attacks for ' + state.currentMonster.attack + ' damage!');
          state.messages.unshift(`DM:> You are Dead.`);
          state.messages.unshift(`DM:> Game Over.`);
        }else {
          state.messages.unshift(`DM:> You Attack the air causing:` + state.selectedHero.attack + ' damage!');
        }
      },
      ANYTHING(state){
        state.messages.unshift(`DM:> You Dance around and sing.`);
        state.messages.unshift(`DM:> ` + state.currentMonster.name + ' Attacks for ' + state.currentMonster.attack + ' damage!');
        state.messages.unshift(`DM:> You are Dead.`);
        state.messages.unshift(`DM:> Game Over.`);
      },
      NEW_HERO(state){
        state.editHero = state.emptyHero;
      }
    },
    actions:{
      newGame() {
        //this.state.messages.unshift('DM:> Starting New Game');
      }
    }
  });
  return store;
}
