import axios from "axios";

export default {
    createFamily(familyName){
        axios.get(`/addfamily/${familyName}`)
    },
    addUserToFamily(familyName, user){
         axios.post(`addfamily/${familyName}/${user}`)
    }
}