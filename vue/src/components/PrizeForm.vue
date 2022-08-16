<template>
  <div class="add-prize">
     
     <form action="" v-on:submit.prevent="submitForm" class="add-prize-form">
          <label for="name">Add Prize Name: </label>
          <input type="text" id="prize-name" v-model="prizeName"/>
          <label for="start-date">Start-Date: </label>
          <input type="date" v-model="prizeStartDate">
          <label for="end-date">End-Date: </label>
          <input type="date" v-model="prizeEndDate">
          <label for="number-available">Number of available prizes: </label>
          <input type="number" v-model="numberAvailable">
          <label for="goal-minutes">Minutes goal:</label>
          <input type="number" v-model="numberMinsToGoal">

     </form>
     </div>
</template>

<script>

// import PrizeService from '@/services/PrizeService'

export default {
     name: "add-new-prize"
    

}
</script>

<style>

</style>