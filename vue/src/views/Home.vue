<template>
  <div class="home">
    <h1>Home</h1>
    <p>Your Library! still need to be logged in</p>
    <div >
      <button v-on:click="isShowForm=true">Add New Book</button>
      <div v-show="isShowForm">
        <p>testing business</p>
        <add-new-book ></add-new-book>
      </div>
    </div>
    <book-list></book-list>
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
