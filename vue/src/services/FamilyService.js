import axios from "axios";

export default {
    createFamily(familyName){
        axios.post(`/addfamily/${familyName}`);
    },
    addMemberToFamily(user){
         axios.post(`/addfamilymember/${user}`);
    },
    getFamily(){
         axios.get(`/getfamilyusers`);
    }
}