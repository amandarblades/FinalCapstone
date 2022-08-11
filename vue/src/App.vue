<template>
  <div id="app">  
    <div id="nav">
      <router-link class="nav-button" v-bind:to="{ name: 'home' }" tag="button" style="background-color: teal">My Library</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" tag="button" style="background-color: teal">Logout</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'PLACEHOLDER' }" tag="button" style="background-color: teal">Family Library</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'PLACEHOLDER' }" tag="button" style="background-color: teal">Prizes</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'PLACEHOLDER' }" tag="button" style="background-color: teal">Log Activity</router-link>
    </div>
    <!-- <img id="book-image" src="transparentBook.png" alt="a book background" /> -->
    <router-view />
  </div>
</template>

<style scoped>
#app{
     font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
     /* background-color: rgb(117, 62, 92); */
     background-color: rgb(117, 57, 122);
     display: flex;
     flex-direction: column;
     justify-items: center;
     align-items: center;
}
#nav{
     display: flex;
     background-color: rgb(143, 114, 146);
     justify-content: space-around;
     padding: 10px;
     min-width: 100%;
     
}
/* .nav-button{
     color: lightgray;
     padding-left: 8px;
     padding-right: 8px;
     border-radius: 2px;
     border: none;
     margin-left: 10px;
     margin-right: 10px;
     font-size: 20px;
     
}
.nav-button:hover{
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
     color: white;
     transition: 0.7s;
} */
/*------------------------*/

.nav-button{
  font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  line-height: 45px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 0 42px;
  position: relative;
  transition: opacity 0.3s linear 0s;
}

.nav-button span{
  left: 0;
  position: relative;
  transition: all 0.2s ease-out 0s;
}

.nav-button i{
  width: 18px;
  position: absolute;
  right: 30px;
  top: 50%;
  margin-top: -9px;
  line-height: 18px;
  opacity: 0;
  transition: all 0.2s ease-out 0s;
}

.nav-button:hover span{
  left: -18px;
}

.nav-button:hover i{
  opacity: 1;
  right: 24px;
}




</style>
