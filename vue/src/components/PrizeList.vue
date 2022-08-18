<template>
  <div>
      <div class="prizes">
          <div >
               <h2>My Prizes</h2>
          <div class="testing-grid">
              <prize-card class="prizeCard" v-bind:prize="prize" v-for="prize in getPrizes" v-bind:key="prize.prizeID"></prize-card>
              </div>

          </div>
      </div>

  </div>
</template>

<script>
import PrizeCard from '@/components/PrizeCard.vue'
import PrizeService from '@/services/PrizeService.js'


export default {
    name: 'prize-list',
    data(){
        return {
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
               },
               prizes: []
        }
    },
    components: {
        PrizeCard
    },
    computed: {
        getPrizes(){
            return this.$store.state.prizes
        }
    },
    created(){
        PrizeService.getPrizes()
        .then( (response) => {
            this.prizes = response.data;
            this.$store.commit("SET_CURRENT_PRIZES", response.data);
        });
    }


}
</script>

<style scoped>
.testing-grid{
     display: flex;   
     text-align: center;
     max-width: 65vw;
     border: 2px solid black;
     padding: 5px;
     background:rgb(18, 34, 63);
     overflow: auto;
     flex-wrap: wrap;
     max-height: 35vh;
     justify-content: center;
     margin-bottom: 25px;
     }
.prizes{
     display: flex;
     text-align: center;
     align-items: center;
     justify-content: center;
}
::-webkit-scrollbar{
     width: 10px;
     background: rgb(18, 34, 63);
}
::-webkit-scrollbar-thumb{
     border-radius: 10px;
     background: rgb(36, 58, 99);
}


</style>