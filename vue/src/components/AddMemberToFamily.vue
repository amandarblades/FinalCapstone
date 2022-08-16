<template>
  <div>
       <form action="" v-on:submit.prevent="submitForm" class="add-user-family-form">
                    <label for="Username" >Add a Family Member:</label>
                    <input type="text" id="userToAdd" v-model="familyMemberName"/>
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
               familyMemberName: '',
          }
     },
     methods: {
          submitForm() {
               window.alert("add member to family " + this.familyMemberName);

               const activeMember = FamilyService.getUserValidation(this.familyMemberName);
               
               if(activeMember){
               FamilyService.addMemberToFamily(this.familyMemberName)
               .then((response) => { 
                    if(response.status == 200){
                         this.$store.commit("SET_FAMILY_MEMBERS",this.familyMemberName );
                         window.location.reload();
                      }
                    }    
               );
                    
               }
               else {
                    window.alert(" We're sorry, that user is not available");
               }
               
          }
     }
}
</script>

<style>

</style>