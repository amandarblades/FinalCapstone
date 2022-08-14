<template>
  <div>
       <div v-on:submit.prevent="addUserToFamily" class="add-user-family-form">
                    <label for="Username" >Add a Family Member:</label>
                    <input type="text" id="userToAdd" v-model="family.user"/>
                    <button type="submit">Add</button>
               </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>