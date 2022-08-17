<template>
<div>
  <div class="home">
    <h1>My {{this.$store.state.familyName}} Library</h1>
    <p>See your books, and add a book by ISBN.</p>
     <div class="align-right">
      <button v-on:click="isShowForm=true" class="button">Add New Book</button>
      <div v-show="isShowForm">
        <add-new-book></add-new-book>
        </div>
      </div>
   
    <book-list id="book-list"></book-list>
    <activity-list></activity-list>
     </div>
  </div>
  
</template>

<script>

import BookList from "@/components/BookList.vue";
import AddNewBook from "@/components/AddNewBook.vue";
import ActivityList from "@/components/ActivityList.vue";
import FamilyService from "@/services/FamilyService.js";


export default {
  name: "home",
  data(){
    return{
      isShowForm: false,
      familyName: ''
    }
  },
  components: {
    BookList,
    AddNewBook,
    ActivityList
  },
   created(){
        FamilyService.getFamilyName()
        .then( (response) => {
            this.familyName = response.data;
            this.$store.commit("SET_FAMILY_NAME", response.data);
        });
 
   }
}
</script>

<style scoped>
.home {
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  height: 100vh;
  color: rgb(19, 62, 80);
  
}
h1{
     text-align: center;
}
.button:hover{
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
     color: white;
     transition: 0.7s;
    transform: skewX(-20deg);
} 
/*------------------------*/
.align-right,p{
     text-align: right;
}

.button{
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
   background-color: rgb(19, 62, 80);
   cursor: pointer;

}
#book-list {
  /* display: flex; */
  /* flex-direction: column; */
  flex-wrap: wrap;
  min-width: 30em;
  align-content: center;
margin: 5px;
}

#book-image{
     width: 85vh;
     height: auto;
}

</style>
