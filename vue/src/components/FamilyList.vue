<template>
  <div class="my-family">
      <h2>The {{family.name}} Family Book Collection</h2>
      <div class="members">
             <div v-for="user in getFamily" v-bind:key="user.username"><user v-bind:user="user" /> </div> 
             <div>{{user.username}}</div>
           <!-- <table class="family">
         <thead>
              <tr>
                   <th>Name</th>
                   <th>Current Book</th>
                   <th>Minutes Read</th>
              </tr>
         </thead>
         <tbody> -->
              <!-- <user v-bind:family="family" v-for="user in getFamily" v-bind:key="user.username"/> 
              <tr v-for="user in family" :key="user.username"> -->
               
              <!-- <tr >
                   <user v-bind:family="family" v-for="user in getFamily" v-bind:key="user.username" /> 
                   <td>{{user.username}}</td>
                   <td>{{user.currentBook}}</td> -- need to add current book and total mins read to a user; also could have display name-- 
                   <td>{{user.totalMins}}</td>
              </tr>
         </tbody>
    </table> -->
      </div>
  </div>
  
</template>

<script>
import User from '@/components/User.vue'
import FamilyService from '@/services/FamilyService.js'

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
    },
//     computed: {
//         getFamily() {
//             return this.$store.state.Family;
//         }
//     },
    methods: {
         getFamily(){
         FamilyService.getFamily()
         .then(response => {
              this.family = response.data;
              this.$store.commit("SET_FAMILY_MEMBER" , response.data);
         })
         }
    },
    created(){
         this.getFamily();
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