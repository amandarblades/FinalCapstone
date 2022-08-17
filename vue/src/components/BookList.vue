<template>
  <div class="my-books"> 
       <!-- added my books class for styling  -->
      <h2>My Books</h2>
      <div class="library">
          <div class="book">

            <book-card class="bookCard" v-bind:book="book" v-for="book in getBooks" v-bind:key="book.title"/>
          
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



.book  {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    max-width: 85vw;
    overflow: auto;
    max-height: 70vh;
    background-color: rgb(66, 107, 182);
    color: whitesmoke;
}
::-webkit-scrollbar{
     width: 10px;
     background: rgb(66, 107, 182);
}
::-webkit-scrollbar-thumb{
     border-radius: 10px;
     background: rgb(56, 90, 153);
}

    .my-books{
         background-color:rgb(66, 107, 182);
         text-align: center;
         border: solid 2px black;
         color: whitesmoke;
    }
.bookCard{
     width: 170px;
     height: 210px;
     
}

</style>