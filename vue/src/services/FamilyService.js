import axios from "axios";

export default {
    createFamily(familyName){
        axios.post(`/addfamily/${familyName}`);
    },
    addUserToFamily(familyName, user){
         axios.post(`/addfamilymember/${user}`);
    }
}