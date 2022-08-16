<template>
  <div class="activity-card">
      <div class="container">
          <!-- <h3>{{activity.username}}</h3>
          <h4>Minutes Read: {{activity.minutesRead}} </h4>
          <h4>{{activity.title}}</h4>
          <h4>{{activity.description}}</h4>
          <h4>{{activity.notes}}</h4> -->
          <div class="activity-item" id="username">{{activity.username}}</div>
          <div class="activity-item" id="minutes-read">{{activity.minutesRead}} </div>
          <div class="activity-item" id="title">{{activity.title}}</div>
          <div class="activity-item" id="description">{{activity.description}}</div>
          <div class="activity-item" id="notes">{{activity.notes}}</div>
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


<style scoped>
.container{
     display: flex;
     border: 2px solid grey;
}
.activity-item{
     border: 2px solid black;
     width: 50%;
}

</style>