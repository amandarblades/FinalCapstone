<template>
  <div>
    <!-- <h1 class="book-title" v-if="book.title">{{ book.title }}</h1>
    <h2 class="book-author" v-if="book.author">{{ book.author }}</h2>
    <img src="" alt="image goes here" />

    <p class="book-isbn" v-if="book.isbn">{{ book.isbn }}</p> -->

    <div>
      <h1>Search for Book by Title</h1>
      <input type="text" v-model="titleToSearch" />
      <button @click="retrieveBookByTitle(titleToSearch)">Submit</button>
    </div>
    
  </div>
</template>

<script>
import BookService from '@/services/BookService.js';

export default {
  props: ["book"],
  methods: {
    retrieveBookByTitle(title) {
      window.alert("It works!");
      BookService.getBookByTitle(title)
        .then((response) => {
          this.$store.commit("SET_CURRENT_BOOK", response.data);
        })
        .catch((error) => {
          if (error.response && error.response.status == 404) {
            alert("Book not available.");
          }
        });
    },
  },
};
</script>

<style>
</style>