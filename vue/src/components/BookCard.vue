<template>
  <router-link v-bind:to="{name: 'book-details', params: {title: book.title}}">
      <div class="card" v-bind:class="{status: book.status}">
          <h5 class="book-title">{{book.title}}</h5>
          <!-- image of book cover here -->
          <h6 class="book-author">{{book.author}}</h6>
          

      </div>

  </router-link>
</template>

<script>
// import BookDetail from "@/components/BookDetail.vue";

export default {
    name: 'book-card',
    props: {
        book: Object
    }

}
</script>

<style>

.card{
    
     /* position: relative;
     background-color: #FFB997;    
     padding: 0px 10px 10px 10px;
     border-radius: 10px;
     box-shadow: 4px -3px 0 0 white, 7px -5px 0 0 #FFB997;
     margin-top: 5px;
     margin-bottom: 10px;
     margin-right: 10px;
     margin-left: 10px;
     max-width: 70%;
     max-height: 100%;
     font-size: 100%; */

     border: 2px solid black;
     width: 150px;
     height: 200px;
     margin: 3px;
     border-radius: 5px;
     padding-left: 5px;

}

</style>