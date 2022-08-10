<template>
  <div>
      <h2>My Books</h2>
      <div class="library">
          <div class="book">

            <book-detail v-for="book in getBooks" v-bind:key="book.title"/>
          
          </div>

      </div>

  </div>
</template>

<script>

import BookService from '@/services/BookService.js'
import BookDetail from '@/components/BookDetail.vue'

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
          BookDetail
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

</style>