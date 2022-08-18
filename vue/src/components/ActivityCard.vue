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
          <div class="activity-item" id="date-logged">{{activity.dateLogged}}</div>
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
     border: 2px solid rgb(82, 82, 82);
     border-radius: 5px;
}
.activity-item{
     display: flex;
     padding: 10px;
     background:#2abbb4;
     width: 100vw;
     justify-items: space-evenly;
     text-align: left;
     border: 1px solid whitesmoke;
     font-weight: bold;
}


/* 
#username{
     width: 70px;
    
}
#minutes-read{
    width: 50px;
    
}
#title{
     width: 200px;
    
}
#date-completed{
     width:50px;
}

#description{
     width: 100px;
   
}
#notes{
     width:223px;
      
}
      */
</style>