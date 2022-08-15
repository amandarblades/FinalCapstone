<template>
  <div class="activity-card">
      <div>
          <h3>{{activity.username}}</h3>
          <h4>Minutes Read: {{activity.minutesRead}} </h4>
          <h4>{{activity.title}}</h4>
          <h4>{{activity.description}}</h4>
          <h4>{{activity.notes}}</h4>
      </div>
  </div>
</template>

<script>
export default {
    name: 'activity-card',
    props: {
        activity: Object
    }

}
</script>


<style>

</style>