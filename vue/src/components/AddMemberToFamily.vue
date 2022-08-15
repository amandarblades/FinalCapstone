<template>
  <div>
       <form action="" v-on:submit.prevent="submitForm" class="add-user-family-form">
                    <label for="Username" >Add a Family Member:</label>
                    <input type="text" id="userToAdd" v-model="username"/>
                    <button type="submit">Add</button>
               </form>
  </div>
</template>

<script>
import FamilyService from '@/services/FamilyService'

export default {
     name: "add-new-member-to-family",
     props: ['user'],
     data() {
          return {
               username: '',
          }
     },
     methods: {
          submitForm() {
               window.alert("add member to family " + this.username);
               FamilyService.addMemberToFamily(this.username)
               .then((response) => response.data)
               .then(items => { 
                    this.$store.commit("SET_FAMILY_MEMBERS", items);
                    window.location.reload();}); 
                    
               
          }
     }
}
</script>

<style>

</style>