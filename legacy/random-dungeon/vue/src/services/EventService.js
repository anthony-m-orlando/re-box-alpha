import axios from 'axios';

export default {
    getRandomEvent(){
        return axios.get('/event/random');
    },
    getRandomEncounter() {
        return axios.get('/monster/creature/random/1/1/2');
    },
    getCreaturesForDungeon() {
        return axios.get('/monster/creature/dungeon/1/1/2');
    },
    async getRandomTrap() {
        return await axios.get('/trap/random/1/1');
    },
    getRandomFeature() {
        return axios.get('/feature/random/');
    },
    getCreatureById(id) {
        return axios.get(`/monster/${id}`);
    },
    getCreatureTurns(id) {
        return axios.get(`/monster/creature/turns/${id}`);
    }
}