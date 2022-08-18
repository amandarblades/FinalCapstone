<template>
  <div>
       <form action="" v-on:submit.prevent="submitForm" class="add-user-family-form">
                    <label for="Username" >Add a Family Member:</label>
                    <input type="text" id="userToAdd" v-model="familyMemberName"/>
                    <input type="submit">
                    <input type="reset">
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

<style scoped>
input[type=submit],
input[type=reset]{
      font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 10px;
  width: 20%;
  position: relative;
  transition: opacity 0.3s linear 0s;
  background-color: rgb(19, 62, 80);
 margin: 10px;
}
input:hover{
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
     color: white;
     transition: 0.7s;

}
input[type=submit]:hover,
input[type=reset]:hover 
{
     transform: skewX(-20deg);
     transition: 0.7s;
     cursor: pointer;
}
input[type=text]{
     border:2px solid rgb(11, 34, 44);
     
     margin-left: 10px;
}
input[type=text] {
     width: 75%;
     padding: 15px;
     border: 1px solid rgba(226, 223, 206, 0.767);
     border-radius: 4px;
     resize: vertical;
}
.add-family{
     display: flex;
     justify-content: center;
     align-items: center;
}
.add-user-family-form{

}

</style>