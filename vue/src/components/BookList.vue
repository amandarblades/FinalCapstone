<template>
  <div>
      <h2>My Books</h2>
      <div class="library">
          <div class="book"
          v-for="book in books"
          v-bind:key="book.title">
          {{book.title}}

          <book-detail v-for="book in books" v-bind:key="book.title" v-bind:to="{name: 'book-details', params: {title: $route.params.title}}">
          </book-detail>
          
          </div>

      </div>

  </div>
</template>

<script>

import BookService from '@/services/BookService.js'
import BookDetail from '@/components/BookDetail.vue'

export default {
     components: { 
          BookDetail
     },
    data(){
        return{
            books:[]
        }
    },
    created(){
        BookService.getBookList()
        .then( response =>{
                this.books = response.data;
        });
    }

}
</script>

<style scoped>
div {
    font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

</style>