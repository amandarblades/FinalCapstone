import axios from "axios";

export default {
    createFamily(familyName){
        axios.get(`/addfamily/${familyName}`)
    }
}