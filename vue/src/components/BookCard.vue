<template>
<!-- changed to div instead of router-link ; added class style-book-->
  <div v-bind:to="{name: 'book-details', params: {title: book.title}}" class="style-book">
      <div class="card" v-bind:class="{status: book.status}" >
          <img  class="book-image" :src="book.imgURL" />
         <!-- <img  class="book-image" v-bind:src="'https://covers.openlibrary.org/b/isbn/' + 9781400079278 + '-M.jpg'" /> -->
     </div>
     <div class="overlay">
          <h5 class="book-title">{{book.title}}</h5>
          <h6 class="book-author">{{book.author}}</h6>
     </div>
          

      
  </div>
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

     /* border: 2px solid black;  
     width: 150px;
     height: 200px;
     margin: 3px;
     border-radius: 5px;
     padding-left: 5px;*/

     border: 2px solid black;  
     width: 150px;
     height: 200px;
     margin: 3px;
     border-radius: 5px;
}

.book-image{
     width: 150px;
     height: 200px;      
}

img:hover{
      animation: fadeOut ease 1s;

}
@keyframes fadeOut{
     0% { opacity:1;}
     100% { opacity:0;};
     
}

.style-book{
     text-align: center;
     background-color: rgb(66, 107, 182);
     border: 2px black;
     margin: 5px;
     border-radius: 5px;
     color: rgb(253, 236, 250);
     perspective: 1000;
     display: inline-block;
     
}


</style>