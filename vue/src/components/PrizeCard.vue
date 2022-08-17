<template>
  <div class="prize-card">
      <div class="container">
          <div class="prize-item" id="prizeName">{{prize.prizeName}}</div>
          <div class="prize-item" id="startDate">{{prize.startDate}}</div>
          <div class="prize-item" id="endDate">{{prize.endDate}}</div>
          <div class="prize-item" id="maxPrize">{{prize.maxPrize}}</div>
          <div class="prize-item" id="milestone">{{prize.milestone}}</div>
          <div class="prize-item" id="description">{{prize.description}}</div>
          <div class="prize-item" id="userRole">{{prize.userRole}}</div>
          <div class="prize-item" id="numberOfPrizeWinners">{{prize.numOfPrizeWinners}}</div>
          <div class="prize-item" id="isActive">{{prize.isActive}}</div>
          <div id="burst-8"></div>

      </div>
  </div>
</template>

<script>
export default {
    name: 'prize-card',
    props: {
        prize: Object
    }

}
</script>

<style scoped>
/* .prize-card{
     display: flex;
     flex-direction: column;
     justify-content: space-between;
     align-items: center;
   
} */
.container{
     display: flex;
     border: 2px solid rgb(82, 82, 82);
     border-radius: 5px;
}

.prize-card{
  display: flex;
  flex-wrap: wrap;
   width: 170px;
     height:230px;
     margin: 5px;
     border: 2px solid;
}

.prize-item{
     display: flex;
     
     padding: 10px;
     background:#2abbb4
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