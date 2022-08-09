<template>
  <div>
      <h1 class= "book-title" v-if="book.title">{{book.title}}</h1>
      <h2 class= "book-author" v-if="book.author">{{book.author}}</h2>
      <img src="" alt="image goes here">
      
      <p class= "book-isbn" v-if="book.isbn">{{book.isbn}}</p>
  </div>
</template>

<script>

export default {
        
        props: ["book"]
       
}
</script>

<style>

</style>