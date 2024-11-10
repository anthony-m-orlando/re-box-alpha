import axios from 'axios';

export default {

    getCharacters(){
        return axios.get('/hero/myheroes')
    },

    getProfessionList() {
        return axios.get('/hero/professions')
    },

    addCharacter(hero){
        return axios.post('/hero', hero)
    },

    updateCharacter(hero){
        return axios.put('/hero', hero)
    }
}