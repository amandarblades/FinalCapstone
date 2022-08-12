<template>
  <div>
    <div>
      <h1>Search for Book by Title</h1>
      <input type="text" v-model="isbnToSearch" />
      <button @click="retrieveBookByIsbn(isbnToSearch)">Submit</button>
    </div>
    
  </div>
</template>

<script>
import BookService from '@/services/BookService.js';

export default {
  name: "search-form",
  props: ["book"],
  methods: {
    retrieveBookByIsbn(isbn) {
      BookService.getBookByIsbn(isbn)
        .then((response) => {
          this.$store.commit("SET_CURRENT_BOOK", response.data);
          window.location.reload();
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

<style scoped>
div {
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

</style>