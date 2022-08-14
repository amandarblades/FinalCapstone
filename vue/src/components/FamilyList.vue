<template>
  <div class="my-family">
      <h2>The {{this.family.name}} Family Book Collection</h2>
      <div class="members">
           <table class="family">
         <thead>
              <tr>
                   <th>Name</th>
                   <th>Current Book</th>
                   <th>Minutes Read</th>
              </tr>
         </thead>
         <tbody>
              <tr v-for="user in family" :key="user.id">
                   <td>{{user.username}}</td>
                   <td>{{user.currentBook}}</td><!--  -- need to add current book and total mins read to a user; also could have display name-- -->
                   <td>{{user.totalMins}}</td>
              </tr>
              
         </tbody>
                       
    </table>
     <div v-on:submit.prevent="addUserToFamily" class="add-user-family-form">
                    <label for="Username" >Add a Family Member:</label>
                    <input type="text" id="userToAdd" v-model="family.user"/>
                    <button type="submit">Add</button>
               </div>
      </div>
     <user> </user>
  </div>
  
</template>

<script>
import User from '@/components/User.vue'

export default {
    name: 'family-list',
    data(){
         return{
        family: [
             {name: '',
             user: []}
        ]
    }
    },
    components :{
         User
    }
}
</script>

<style>


table, th, td {
     border: 1px solid;
}

th{
      column-width: 20vw;
}

</style>