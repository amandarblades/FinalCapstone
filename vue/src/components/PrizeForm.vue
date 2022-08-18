<template>
  <div class="add-prize">
       <h3>Create a Prize!</h3>
          <form v-on:submit.prevent="submitForm" class="add-prize-form">
          <label for="prizeName">Add Prize Name: </label>
          <input type="text" id="prize-name" v-model="prize.prizeName"/>

          <div class="flex-form">
               <label for="start-date">From:</label>
               <input type="date" v-model="prize.startDate">
               <label for="end-date">To:</label>
               <input type="date" v-model="prize.endDate">
               <label for="maxPrize">Available prizes:</label>
               <input type="number" v-model="prize.maxPrize">
               <label for="milestone">Goal:</label>
               <input type="number" v-model="prize.milestone">
          </div>

          <label for="description">Description:</label>
          <input type="text" v-model="prize.description" id="description">
          <select name="userRole" id="type" v-model="prize.userRole" >Prize For?:
               <option value="" disabled selected>Prize For:</option>
               <option value="ROLE_USER">Child</option>
               <option value="ROLE_ADMIN">Parent</option>
               <option value="ROLE_BOTH">Both</option>
          </select>
          <input type="submit">
          <input type="reset">



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
          prizeName: this.prize.prizeName,
          startDate: this.prize.startDate,
          endDate: this.prize.endDate,
          maxPrize: this.prize.maxPrize,
          milestone: this.prize.milestone,
          description: this.prize.description,
          userRole: this.prize.userRole,
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

<style scoped>
*{
     box-sizing: border-box;
}
input[type=text], 
select {
     width: 75%;
     padding: 15px;
     border: 1px solid rgba(226, 223, 206, 0.767);
     border-radius: 4px;
     resize: vertical;
}
input[type=date],
input[type=number]{
     max-width: 15%;
     padding: 10px;
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
 cursor: pointer;

}
#type,
#description{
     max-width: 40%;
}

input[type=submit]:hover,
input[type=reset]:hover 
{
     transform: skewX(-20deg);
     transition: 0.7s;
}
.add-prize{
     border-radius: 5px;
     background-color: rgba(226, 223, 206, 0.767);
     display: flex;
     justify-content: center;
     align-items: center;
     max-width: 90vw;
     
     display: flex;
     flex-direction: column;
     border: 2px solid black;
     
     text-align: center;
     padding: 15px;

}
h3{
     margin-top: -2px;
     margin-bottom: -2px;
}
</style>