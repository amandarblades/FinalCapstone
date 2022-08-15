<template>
  <div class="my-family">
    <h2>The {{ family.name }} Family Book Collection</h2>
    <div class="members">
      <div class="member">
        <user v-bind:familyUser="familyUser" v-for="familyUser in getMembers" v-bind:key="familyUser.username"></user>
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
      return this.$store.state.familyUsers;
    },
  },
  created() {
    FamilyService.getFamily().then((response) => {
      window.alert("IT WORKS!");
      this.familyUsers = response.data;
      this.$store.commit("SET_FAMILY_MEMBERS", response.data);
    });
  },
};
</script>

<style>
/* table,
th,
td {
  border: 1px solid;
}

th {
  column-width: 20vw;
} */
</style>