<template>
  <div class="my-family">
    <h2>Family Members</h2>
    <div class="members">
      <div class="member">
        <user v-for="member in familyUsers" v-bind:key="member.username" v-bind:familyUser="member" ></user>
      </div>
    </div>
  </div>

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
</template>

<script>
import User from "@/components/User.vue";
import FamilyService from "@/services/FamilyService.js";

export default {
  name: "family-list",

  data() {
    return {
      familyUser: {
        username: '',
        minutesRead: 0,
      },
      familyUsers: [],
    };
  },
  components: {
    User,
  },
  computed: {
    getMembers() {
      // TODO: RICH DEBUG COMMENT_OUT 
      return this.$store.state.familyUsers;


    },
  },
  // R.SEEDS COMMENT BLOCK 15:55
  created() {
    FamilyService.getFamily().then((response) => {
      this.familyUsers = response.data;
      this.$store.commit("SET_FAMILY_MEMBERS", response.data);
    });
  }
};
</script>

<style scoped>
div{
      font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
     color: gray
}
.member{
     display:flex;
     flex-direction: column;
}
</style>