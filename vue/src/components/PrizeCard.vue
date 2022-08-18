<template>
  <div class="prize-card">
    <div class="container">
         <img id="trophy" src="trophy.png" alt="BookTrophy">
      <div class="prize-item" id="prizeName">Prize Name: {{ prize.prizeName }}</div>
      <!-- <div class="prize-item" id="startDate">{{prize.startDate}}</div> -->
      <div class="prize-item" id="endDate">Due by: {{ prize.endDate }}</div>
      <div class="prize-item" id="description">{{ prize.description }}</div>
      <!-- <div class="prize-item" id="userRole">{{prize.userRole}}</div> -->
      <div class="prize-item" id="milestone"> Goal: {{ prize.milestone }}min</div>
      <div class="prize-fraction">
        <!-- <div class="prize-item" id="numberOfPrizeWinners">
          {{ prize.numOfPrizeWinners }}
        </div> -->
        <div class="prize-item" id="maxPrize">{{ prize.maxPrize }} Prizes Available</div>
      </div>
      <!-- <div class="prize-item" id="isActive">{{prize.isActive}}</div> -->
      <div id="burst-8"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "prize-card",
  props: {
    prize: Object,
  },
};
</script>

<style scoped>
/* .prize-card{
     display: flex;
     flex-direction: column;
     justify-content: space-between;
     align-items: center;
   
} */
.container {
    background: #2abbb4;
    width: 50vw;
  border: 2px solid rgb(82, 82, 82);
  border-radius: 5px;
  display: grid;
  grid-template-columns:  1fr 2fr 2fr 1fr;
  grid-template-areas:
    "trophy prizeName prizeName endDate"
    "trophy description  maxPrize milestone"
    "trophy description  maxPrize milestone";
}
#trophy{
     align-self: center;
     justify-self: center;
     text-align: center;
     grid-area: trophy;
     background-color: #2abbb4;
     width: 100px;
}
#prizeName{
  grid-area: prizeName;
  font-weight: bold;
}
#endDate{
  grid-area: endDate;
}
#description{
  grid-area: description;
}
#milestone{
  grid-area: milestone;
}
#numberOfPrizeWinners{
  grid-area: numberOfPrizeWinners;
}
#maxPrize{
  grid-area: maxPrize;
}

/* 
.prize-card {
  flex-wrap: wrap;
  width: 170px;
  height: 230px;
  margin: 5px;
  border: 2px solid rgb(161, 21, 21);
} */

.prize-item {
  /* display: flex; */

  padding: 10px;
  background: #2abbb4;
}

/* #burst-8 {
     margin: 20px;
      background: blue;
      width: 80px;
      height: 80px;
      position: relative;
      text-align: center;
      transform: rotate(20deg);
    }
    #burst-8:before {
      content: "";
      position: absolute;
      top: 0;
      left: 0;
      height: 80px;
      width: 80px;
      background: blue;
      transform: rotate(135deg);
    } */
</style>