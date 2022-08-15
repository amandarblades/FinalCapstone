<template>
<div>
  <div class="home">
    <h1>My Library</h1>
    <p>See your books, and add a book by ISBN.</p>
    <div>
      <button v-on:click="isShowForm=true" class="button">Add New Book</button>
      <div v-show="isShowForm">
        <add-new-book></add-new-book>
      </div>
    </div>
    <book-list id="book-list"></book-list>
    </div>
    <!-- <div class="bottom-page">
    <img id="book-image" src="blueTransparentBooks.png" alt="a book background"/>
    </div> -->
    <activity-list></activity-list>
    <family-list></family-list>
  </div>
  
</template>

<script>

import BookList from "@/components/BookList.vue";
import AddNewBook from "@/components/AddNewBook.vue";
import ActivityList from "@/components/ActivityList.vue";
import FamilyList from "@/components/FamilyList.vue"

export default {
  name: "home",
  data(){
    return{
      isShowForm: false,
    }
  },
  components: {
    BookList,
    AddNewBook,
    ActivityList,
    FamilyList
  }
 
  
};
</script>

<style scoped>
.home {
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  height: 100vh;
  color: rgb(19, 62, 80);
}

.button:hover{
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
     color: white;
     transition: 0.7s;
    transform: skewX(-20deg);
} 
/*------------------------*/

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
}
#book-list {
  /* display: flex; */
  /* flex-direction: column; */
  flex-wrap: wrap;
  min-width: 30em;
  align-content: center;

}
.bottom-page{
     background-color: black;
     max-width:100%;
}
#book-image{
     width: 85vh;
     height: auto;
}

</style>
