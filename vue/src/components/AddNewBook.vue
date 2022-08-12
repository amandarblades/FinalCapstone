<template>
  <div>
    <div>
      <h3>Search for Book by ISBN</h3>
      <input type="text" v-model="isbnToSearch" />
      <button @click="retrieveBookByIsbn(isbnToSearch)" class="button">Submit</button>
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

.button{
 font-family: 'Montserrat', sans-serif;
  
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  line-height: 17px;
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
div {
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

</style>