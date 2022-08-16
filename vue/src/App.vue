<template>
    
  <div id="app">  
    <div id="nav" >
         <div class="logo"><img id="BW" src="favThumbnailBW.png" alt="Bookworm Logo"></div>
      <router-link class="nav-button" v-bind:to="{ name: 'home' }" tag="button" style="background-color: rgb(11, 34, 44)">My Library</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != '' " tag="button" style="background-color:rgb(11, 34, 44)">Logout</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'family' }" tag="button" style="background-color: rgb(11, 34, 44)">Family Library</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'prizes' }" tag="button" style="background-color: rgb(11, 34, 44)">Prizes</router-link>
      <router-link class="nav-button" v-bind:to="{ name: 'add-activity' }" tag="button" style="background-color: rgb(11, 34, 44)" >Log Activity</router-link>
    </div>
    <!-- <img id="book-image" src="blueTransparentBooks.png" alt="a book background" />  -->
    <router-view />

  </div >
</template>


<style scoped>
#app{
     font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
     /* background-color: rgb(117, 62, 92); */
     
     display: flex;
     flex-direction: column;
     justify-items: center;
     align-items: center;
}
#nav{
     display: flex;
     /* background-color: rgb(66, 107, 182); */
     background-color: #2abbb4;
     justify-content: space-around;
     padding: 10px;
     min-width: 100%;
     max-height: 50px;
     
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
     
}*/
.nav-button:hover{
          box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
     color: white;
     transition: 0.7s;
    transform: skewX(-20deg);

} 
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
  padding: 0 20px;
  position: relative;
  transition: opacity 0.3s linear 0s;
  overflow: visible;
  cursor: pointer;
}

#BW{
     height: 118px;
     border: 5px solid #fff;
     border-radius: 20px;

}

</style>
