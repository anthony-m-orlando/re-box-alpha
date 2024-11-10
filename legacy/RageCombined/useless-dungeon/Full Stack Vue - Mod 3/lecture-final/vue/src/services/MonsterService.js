import axios from 'axios';

export default {

    getMonsters(id){
        return axios.get(`/monster/`)
    }
}