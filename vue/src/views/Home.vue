<template>
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
</template>

<script>

import BookList from "@/components/BookList.vue";
import AddNewBook from "@/components/AddNewBook.vue";

export default {
  name: "home",
  data(){
    return{
      isShowForm: false,
    }
  },
  components: {
    BookList,
    AddNewBook
  }
 
  
};
</script>

<style scoped>
.home {
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  height: 100vh;
}
.home{
     color: aliceblue;
}
.button{
 font-family: 'Montserrat', sans-serif;
  
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  line-height: 20px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 0 20px;
  position: relative;
  transition: opacity 0.3s linear 0s;
}

.button:hover{
     transition: 1s;
     background-color:rgb(36, 133, 133);
}
#book-list {
  /* display: flex; */
  /* flex-direction: column; */
  flex-wrap: wrap;
  min-width: 30em;
  align-content: center;

}


</style>
