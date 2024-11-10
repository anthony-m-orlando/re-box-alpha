import axios from 'axios';

export default {
    getCharacters(){
        return axios.get('/hero')
    },
    getAllSkills(){
        return axios.get('/hero/skills/all')
    }

}