<template>
  <div class="my-books"> 
       <!-- added my books class for styling  -->
      <h2>My Books</h2>
      <div class="library">
          <div class="book">

            <book-card v-bind:book="book" v-for="book in getBooks" v-bind:key="book.title"/>
          
          </div>

      </div>

  </div>
</template>

<script>

import BookService from '@/services/BookService.js'
import BookCard from './BookCard.vue'

export default {
    name: 'book-list',
    data(){
        return {
        book: {
            title: '',
            author: '',
            status: '',
            isbn: 0
        },
        books: []
        
     }
    },
    components: { 
        BookCard
     },
    computed: {
        getBooks() {
            return this.$store.state.books;
        }
    },
    created(){
        BookService.getBookList()
        .then( response =>{
                this.books = response.data;
                this.$store.commit("SET_CURRENT_USER_BOOKS", response.data);
        });
    }

}
</script>

<style scoped>

div {
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

.book  {
    /*
    AS .LIBRARY
    height: 50vh;
    overflow: scroll;
    background-color: lightpink;
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    
    flex-flow: column wrap;
    flex-direction: column;
    min-width: 100%; */
    
    /* display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    max-width: 80%;
    overflow: auto;
    max-height: 40vh;
    background-color: rgb(162, 192, 247); */

    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    max-width: 70vw;
    overflow: auto;
    max-height: 40vh;
    background-color: rgb(66, 107, 182);
      
}
::-webkit-scrollbar{
     width: 10px;
     background: rrgb(66, 107, 182);
}
::-webkit-scrollbar-thumb{
     border-radius: 10px;
     background: rgb(56, 90, 153);
}

    .my-books{
         background-color:rgb(66, 107, 182);
         text-align: center;
         border: solid 2px black;
    } 
/* added card class to book card to try formatting */
/* .card{
     background-color: violet;
     
} */



</style>