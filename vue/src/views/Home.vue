<template>
  <div class="home">
    <h1>My Library</h1>
    <p>See your books, and add a book by title.</p>
    <div >
      <button v-on:click="isShowForm=true">Add New Book</button>
      <div v-show="isShowForm">
        <p>testing business</p>
        <add-new-book ></add-new-book>
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

#book-list {
  /* display: flex; */
  /* flex-direction: column; */
  flex-wrap: wrap;
  min-width: 30em;
  align-content: center;

}


</style>
