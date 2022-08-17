import axios from "axios";

export default {
    createFamily(familyName){
        return axios.post(`/addfamily/${familyName}`);
    },
    addMemberToFamily(user){
        return axios.post(`/addfamilymember/${user}`);
    },
    getFamily(){
        return axios.get('/getfamilyusers');
    },
    getUserValidation(user){
        return axios.get(`/sysUsers/${user}`);
    },
    getFamilyName(){
         return axios.get(`/getfamilyname`);
    }
}