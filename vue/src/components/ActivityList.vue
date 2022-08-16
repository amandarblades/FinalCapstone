<template>
  <div>
    <h2>My Activities</h2>
    <div class="activities">
        <div class="activity" >
            
            <activity-card v-bind:activity="activity" v-for="activity in getActivities" v-bind:key="activity.username"></activity-card>
            
            
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
                    title: '',
                    description: '',   
                    minutesRead: 0,
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
     color: gray
}
.activity{
     display: flex;
     flex-direction: column;
}

</style>