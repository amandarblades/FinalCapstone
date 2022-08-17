<template>
  <div>
    <h2>My Activities</h2>
    <div class="activities">
        <div class="activity" >
               <div class="activity-label">
            <div class="table-header" id="username">Username </div>
            <div class="table-header" id="minutes-read">Mins Read</div>
            <div class="table-header" id="title">Title Read</div>
            <div class="table-header" id="date-logged">Date</div>
            <div class="table-header" id="description">Format</div>
            <div class="table-header" id="notes">Notes</div>
            </div>
            <div class="activity-item">
            <activity-card v-bind:activity="activity" v-for="activity in getActivities" v-bind:key="activity.id"></activity-card>
            </div>
        </div>
    </div>
  </div>
</template>

<script>

import ActivityCard from '@/components/ActivityCard.vue'
import ActivityService from '@/services/ActivityService.js'

export default {
        name: 'activity-list',
        data(){
            return{
                activity: {
                    id: 0,
                    title: '',
                    description: '',   
                    minutesRead: 0,
                    dateLogged: '',
                    notes: '',
                    username: ''
                },
                activities: []
            }
        },
        components: {
            ActivityCard
        },
        computed: {
            getActivities() {
                return this.$store.state.activities;
            }
        },
        created(){
            ActivityService.getUserActivities()
            .then((response) => {
                this.activities = response.data;
                this.$store.commit("SET_CURRENT_ACTIVITIES", response.data);
            });
        }
}
</script>

<style scoped>
div {
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
     color: rgb(44, 44, 44)
}
.activity{
     text-align: center;
     display: flex;
     max-width: 85vw;
     border: 2px solid black;
     padding: 5px;
     background:rgb(18, 34, 63);
     overflow: auto;
     flex-wrap: wrap;
     max-height: 35vh;
     justify-content: stretch;
     
}
::-webkit-scrollbar{
     width: 10px;
     background: rgb(18, 34, 63);
}
::-webkit-scrollbar-thumb{
     border-radius: 10px;
     background: rgb(36, 58, 99);
}

/* TODO: Make into a css grid. */

#username{
     padding: 10px;
    
     border: 2px solid white;
     color: whitesmoke;
}
#minutes-read{
     padding: 10px;
   
     border: 2px solid white;
     color: whitesmoke;
}
#title{
     padding: 10px;
   
      border: 2px solid white;
      color: whitesmoke;
}
#description{
     padding: 10px;
     
      border: 2px solid white;
      color: whitesmoke;
}
#notes{
     color: whitesmoke;
     padding: 10px;
     
      border: 2px solid white;
}
#date-logged{
     
      border: 2px solid white;
      padding: 10px;
      color: whitesmoke;
}

     /* display: flex;
     border: 2px solid rgb(82, 82, 82);
     border-radius: 5px; */

.activity-label{
     display: flex;
     border: 2px solid rgb(88, 88, 88);
     border-radius: 10px;
     background-color: rgb(19, 62, 80);
     color: whitesmoke;
     width: 100%;
}
h2{
     text-align: center;
}
.activity-item{
     width: 100%;
     border: 2px solid black;
     /* padding: 10px; */
     background:#2abbb4
}
.table-header{
     width: 100vw;
    display: flex;
    justify-items: space-evenly;  
}


</style>