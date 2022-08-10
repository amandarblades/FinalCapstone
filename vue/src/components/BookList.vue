<template>
  <div>
      <h2>My Books</h2>
      <div class="library">
          <div class="book"
          v-for="book in books"
          v-bind:key="book.title">
          {{book.title}}
          </div>

      </div>

  </div>
</template>

<script>

import BookService from '@/services/BookService.js'

export default {
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

<style>

</style>