<template>
  <div>
       <div class="prize">
           <div class="prize-form">
            <prize-form></prize-form>
            </div>
            <prize-list id="prize-list"></prize-list>
            <div id="burst-8"></div>
          
       </div>
  </div>
</template>

<script>
import PrizeList from "@/components/PrizeList.vue";
import PrizeForm from "@/components/PrizeForm.vue"
export default {
     name: "prizes",
     components: {
          PrizeList,
          PrizeForm
     }

};
</script>

<style scoped>
.prize-form{
     margin: 75px;
}



</style>