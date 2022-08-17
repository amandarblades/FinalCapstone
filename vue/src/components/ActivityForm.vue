<template>
  <!-- <div class="container"> <img src="libraryCard.png" alt="Library Card" class="form-img"> -->
  <div class="container">
       <h2>Log your minutes!</h2>
     <div class="form-container">
    <form v-on:submit.prevent="submitForm" class="activityForm" >
         <label for="title">What did you read?</label>
        <input type="text" placeholder="Book Title" name="current-book" id="current-book" v-model="activity.title"/>
        <label for="minutes">Minutes read: </label>
        <input type="number" placeholder="Number read" name="minutes" id="logged-minutes" v-model="activity.minutesRead"/>
        <label for="date-completed">Date Completed: </label>
        <input type="date" name="date-completed" id="date-completed" v-model="activity.dateCompleted"/>
        <label for="read-type">How did you read?</label>
        <select name="read-type" id="type" v-model="activity.description">
          <option value="" disabled selected>Please Select Type</option>
          <option value="Audiobook">Audiobook</option>
          <option value="Digital">Digital</option>
          <option value="Paper">Paper</option>
          <option value="Read-Aloud(Reader)">Read-Aloud(Reader)</option>
          <option value="Read-Aloud(Listener)">Read-Aloud(Listener)</option>
          <option value="Other">Other</option>
        </select>
        <label for="notes"></label>
        <input type="text" placeholder="Enter any notes (Optional)" name="notes" id="notes" v-model="activity.notes" />
        <!-- <button type="submit">Log it!</button> -->
        <input type="submit">
        <input type="reset">
    </form>
    </div>
  </div>
</template>

<script>
import ActivityService from '@/services/ActivityService.js';
import BookList from '@/components/BookList.vue'

export default {
  name: "add-activity",
  data() {
    return {
      activity: {
        title: "",
        description: "",
        minutesRead: 0,
        dateCompleted: '',
        notes: "",
        username: "",
      },
    };
  },
  computed:{
       options: () => BookList,
  },
  methods: {
    submitForm() {
      const newActivity = {
        title: this.activity.title,
        description: this.activity.description,
        minutesRead: this.activity.minutesRead,
        dateCompleted: this.dateCompleted,
        notes: this.activity.notes
      };
       window.alert("Activity Saved!"),
       window.location.reload();
       ActivityService.postActivity(newActivity).then((response) => {
        this.$store.commit("SET_ACTIVITY", response.data);
      });
    },
  },
};
</script>

<style scoped>
form > div > h2 {
  color: black;
}

form > div > h5 {
  color: black;
  margin-bottom: 0px;
}

.container{
     background-image: src="favThumbnailBW.png" alt="Bookworm Logo";
     display: flex;
     justify-content: center;
     align-items: center;
     flex-direction: column;
     margin-left: 25px;
     margin-right: 25px;
}

.form-container{
     display: flex;
     flex-direction: column;
     border: 2px solid black;
     
     text-align: center;
     padding: 15px;
     background-image: src('libraryCard.png');
}
.activity-form{
     position: absolute;
     z-index: 1;     
}

*{
     box-sizing:border-box;
}
input[type=text], 
input[type=number],
#notes{
     width: 90%;
     padding: 15px;
     border: 1px solid rgba(226, 223, 206, 0.767);
     border-radius: 4px;
     resize: vertical;
}
#date-completed, 
select{
     margin-top: 10px;
     margin-bottom: 10px;
     width: 30%;
     padding: 15px;
      border: 1px solid rgba(226, 223, 206, 0.767);
     border-radius: 4px;
     resize: vertical;
 }   

label {
     padding: 12px; 
     display: inline-block;
}
input[type=submit],
input[type=reset] {
      font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 10px;
  width: 20%;
  position: relative;
  transition: opacity 0.3s linear 0s;
  background-color: rgb(19, 62, 80);
 margin: 10px;
}

input[type=submit]:hover,
input[type=reset]:hover 
{
     transform: skewX(-20deg);
     transition: 0.7s;
}
.form-container{
     border-radius: 5px;
     background-color: rgba(226, 223, 206, 0.767);
}

h2{
     margin: 30px;
}

</style>