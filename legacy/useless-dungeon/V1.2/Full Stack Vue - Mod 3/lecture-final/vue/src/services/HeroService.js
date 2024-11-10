import axios from 'axios';

export default {

    getCharacters(){
        return axios.get('/hero/myheroes')
    },

    getProfessionList() {
        return axios.get('/hero/professions')
    }
}