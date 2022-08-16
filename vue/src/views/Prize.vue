<template>
  <div>
       <div class="prize">
            <h2>Prize List</h2>
            <prize-list id="prize-list"></prize-list>
            <prize-form></prize-form>
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

<style>

</style>