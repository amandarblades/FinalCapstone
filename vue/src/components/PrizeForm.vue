<template>
  <div class="add-prize">
     
     <form action="" v-on:submit.prevent="submitForm" class="add-prize-form">
          <label for="prizeName">Add Prize Name: </label>
          <input type="text" id="prize-name" v-model="prizeName"/>
          <label for="start-date">Start-Date: </label>
          <input type="date" v-model="startDate">
          <label for="end-date">End-Date: </label>
          <input type="date" v-model="endDate">
          <label for="maxPrize">Number of available prizes: </label>
          <input type="number" v-model="maxPrize">
          <label for="milestone">Minutes goal:</label>
          <input type="number" v-model="milestone">
          <label for="description">Description:</label>
          <input type="number" v-model="description">
          <select name="userRole" id="type" v-model="userRole">
               <option value="" disabled selected>Prize For:</option>
               <option value="ROLE_USER">Child</option>
               <option value="ROLE_ADMIN">Parent</option>
               <option value="ROLE_BOTH">Both</option>
          </select>
          

     </form>
     </div>
</template>

<script>

import PrizeService from '@/services/PrizeService'

export default {
     name: "add-new-prize",
     data(){
          return{
               prize: {
                    prizeID: 0,
                    prizeName: '',
                    startDate: '',
                    endDate: '',
                    maxPrize: 0,
                    milestone: 0 ,
                    description: '',
                    userRole: '',
                    numOfPrizeWinners: 0,
                    isActive: true
               }

          }
     },
     methods: {
          submitForm(){
          const newPrize = {
          title: this.prize.prizeName,
          startDate: this.startDate,
          endDate: this.endDate,
          maxPrize: this.maxPrize,
          milestone: this.milestone,
          description: this.description,
          userRole:this.userRole,
          numOfPrizeWinners: this.numOfPrizeWinners
          };
          window.alert("New Prize Made!"),
          window.location.reload();
          PrizeService.addPrize(newPrize)
          .then((response) => {
               this.$store.commit("SET_PRIZE", response.data)
          });
          }
     }
    

}
</script>

<style>

</style>