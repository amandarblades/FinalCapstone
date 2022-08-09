<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>

    <!-- <form class="title-search" >
      <label for="SearchTitle">Title:</label>
      <input type="text" name="SearchTitle" id="search-title" v-model="input" placeholder="Search by title">
      <button type="submit">GO!</button>
    </form> -->

    <div>
      <h1>Search for Book by Title</h1>
      <input type="text" v-model="titleToSearch" />
      <button @click="retrieveBookByTitle(titleToSearch)">Submit</button>
    </div>
    <div>
      
    </div>
    <book v-bind:book="book"></book>
    
  </div>
</template>

<script>
import book from "@/components/Book.vue";
import BookService from "@/services/BookService.js";

export default {
  name: "home",
  components: {
    book,
  },
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
