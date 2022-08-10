<template>
  <div id="app">
    <div id="nav">
      <router-link class="nav-button" v-bind:to="{ name: 'home' }" tag="button" style="background-color: teal">My Library</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" tag="button" style="background-color: teal">Logout</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'PLACEHOLDER' }" tag="button" style="background-color: teal">Family Library</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'PLACEHOLDER' }" tag="button" style="background-color: teal">Prizes</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'PLACEHOLDER' }" tag="button" style="background-color: teal">Log Activity</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
#app{
     font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
     background-color: rgb(117, 62, 92);
     display: flex;
     flex-direction: column;
     justify-items: center;
     align-items: center;
}
#nav{
     display: flex;
     background-color: rgb(71, 37, 116);
     justify-content: space-around;
     padding: 10px;
     
}
.nav-button{
     color: black;
     padding-left: 8px;
     padding-right: 8px;
     border-radius: 2px;
     border: none;
     margin-left: 10px;
     margin-right: 10px;
}
.nav-button:hover{
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

</style>
