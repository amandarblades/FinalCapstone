<template>
  <div class ="add-family">

    <form action="">
      <label for="name" >Update Family Name: </label>
      <input type="text" v-model="familyName"/>
      <button @click="addFamily(familyName)" type="submit">Submit</button>
    </form>

   
  </div>
</template>

<script>
import FamilyService from '@/services/FamilyService'

export default {
  name: "add-new-family",
  data(){
       return {
            family: [
      {
        name: '',
        user: {
             userID: 0 ,
             username: '',
             minutesRead: '', 
             currentBook: '',
             displayName: ''
        }
      }
    ]
            }
       },
  // props: [
  //   'family'
  // ],
  methods: {
    addFamily(familyName){
      window.alert("ADD NEW FAMILY");
      FamilyService.createFamily(familyName)
      .then((response) =>{
        this.$store.commit("SET_FAMILY_NAME", response.data);
        window.location.reload();
      });

    }
  }
}
</script>

<style scoped>
img{
     max-width: 100vw;
     max-height: 80vh;
}



</style>