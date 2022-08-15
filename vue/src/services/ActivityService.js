import axios from 'axios';

export default {

  postActivity(activity) {
    return axios.post(`/addactivity`, activity);
  },
  getChildActivities(username){
       return axios.get(`/getchildactivities`, username);
  },
  getFamilyActivities(){
       return axios.get(`/getfamilyactivities`);
  }
}