<template>
  <div>
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
  name: "search-form",
  props: ["book"],
  methods: {
    retrieveBookByTitle(title) {
      window.alert("It works!");
      BookService.getBookByTitle(title)
        .then((response) => {
          this.$store.commit("SET_CURRENT_BOOK", response.data);
          this.$router.push({name: "home"})
        })
        .catch((error) => {
          if (error.response && error.response.status == 404) {
            alert("Book not available.");
          }
        })
    }
  }
}
</script>

<style>
</style>