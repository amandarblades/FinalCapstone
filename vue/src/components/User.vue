<template>
  <div class="user-card">
    <div>
      <h3>{{ familyUser.username}}</h3><h3>{{familyUser.minutesRead}}</h3>
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

<style>
</style>