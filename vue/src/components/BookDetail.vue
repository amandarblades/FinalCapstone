<template>
  <div>
       <h1>{{book.title}}</h1>
       <h3>{{book.author}}</h3>
       <!-- placeholder for image -->
          <p>{{book.status}}</p>

  </div>
</template>

<script>
import bookService from "@/services/BookService.js";

export default {
  name: "book-detail",
  components: {},
  data() {
    return {
      book: {
        title: "",
        author: "",
        status: "",
        isbn: 0,
      },
    };
  },
  created() {
       bookService
       .getBookDetails(this.$route.params.title)
       .then(response => {
            this.book = response;
       })
  },
};
</script>

<style scoped>
div{
     background-color:black;
}


</style>