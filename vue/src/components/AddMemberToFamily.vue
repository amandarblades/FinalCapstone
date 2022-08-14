<template>
  <div>
       <form action="" v-on:submit.prevent="addUserToFamily" class="add-user-family-form">
                    <label for="Username" >Add a Family Member:</label>
                    <input type="text" id="userToAdd" v-model="username"/>
                    <button type="submit" @click="addMemberToFamily(username)" >Add</button>
               </form>
  </div>
</template>

<script>
import FamilyService from '@/services/FamilyService'

export default {
     name: "add-new-member-to-family",
     props: ['user'],
     methods: {
          addMemberToFamily(username) {
               window.alert("add member to family" + username);
               FamilyService.addMemberToFamily(username)
               .then((response) => {
                    this.$store.commit("SET_FAMILY_MEMBER", response.data);
                    window.location.reload();
               });
          }
     }
}
</script>

<style>

</style>