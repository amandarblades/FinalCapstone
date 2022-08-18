<template>
  <div class="user-card">
    <div class="container">
      <div class="family-item" id="family-user">{{ familyUser.username}}</div>
      <div class="family-item" id="family-minutes">{{familyUser.minutesRead}}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "user",
  props: {
    familyUser: Object
  },
};
</script>

<style scoped>
.container{
     display: flex;
     border: 2px solid grey;
}
.family-item{
     border: 2px solid black;
     width: 50%;
     color: whitesmoke;
     font-weight: bold;
}
</style>