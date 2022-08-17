<template>
  <div>
      <div class="prizes">
          <div >
               <h2>My prizes</h2>

              <prize-card class="prizeCard" v-bind:prize="prize" v-for="prize in getPrizes" v-bind:key="prize.prizeID"></prize-card>

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

<style>

</style>