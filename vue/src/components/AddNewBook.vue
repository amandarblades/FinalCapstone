<template>
  <div>
    <div>
      <h3>Search for Book by ISBN</h3>
      <input class="text-field" type="text" v-model="isbnToSearch" />
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

.button:hover{
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
     color: white;
     transition: 0.7s;
     
} 
/*------------------------*/

.button{
  font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  line-height: 20px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 0 42px;
  position: relative;
  transition: opacity 0.3s linear 0s;
  background-color: rgb(19, 62, 80);
  transform: skewX(-20deg);
content: skewX(20deg);
margin-left: 2px;
}
div {
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
.text-field{
     border:2px solid rgb(11, 34, 44);
     transform: skewX(-20deg);
     margin-left: 10px;
}

</style>