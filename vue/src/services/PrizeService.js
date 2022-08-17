import axios from 'axios';

export default {
    // check variable path name
    addPrize(prize){
        return axios.post(`/addprize`, prize);
    },

    getPrizes(){
        return axios.get(`/getprizes`);
    },

    getFamilyPrizes(){
        return axios.get(`/getfamilyprizes`);
    }
}