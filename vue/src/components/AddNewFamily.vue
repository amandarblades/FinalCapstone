<template>
  <div class ="add-family">

    <form action="">
      <label for="name">What would you like to call your Family?</label>
      <input type="text" v-model="familyName"/>
      <button @click="newFamily(familyName)" type="submit">Submit</button>
    </form>

    <table></table>

  </div>
</template>

<script>
import FamilyService from '@/services/FamilyService'

export default {
  name: "add-new-family",
  props: [
    'family'
  ],
  methods: {
    newFamily(familyName){
      FamilyService.createFamily(familyName)
      .then((response) =>{
        this.$store.commit("SET_FAMILY", response.data)
        window.location.reload
      });

    }
  }
  

}
</script>

<style>

</style>