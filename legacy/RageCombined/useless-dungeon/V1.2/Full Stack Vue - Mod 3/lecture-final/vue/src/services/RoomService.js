import axios from 'axios';

export default {

    getRooms(){
        return axios.get('/room')
    }
}