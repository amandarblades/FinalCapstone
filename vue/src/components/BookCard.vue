<!--
<div class="book-card">
  <div v-bind:to="{name: 'book-details', params: {title: book.title}}" class="style-book">
      <div class="card" v-bind:class="{status: book.status}" > 
          <img  class="book-image" :src="book.imgURL" />
          <div class="book-title">{{book.title}}</div>
         <div class="book-author">{{book.author}}</div>
     </div>
     <div class="overlay"> 
         
          <h5 class="book-title">{{book.title}}</h5>
          <h6 class="book-author">{{book.author}}</h6>
      
     </div>
 </div>         

      
  </div>-->



<template>
  <div class="book-card">
    <div
      v-bind:to="{ name: 'book-details', params: { title: book.title } }"
      class="style-book"
    >
      <div>
        <img class="book-image" :src="book.imgURL" />
      </div>
      <div>
        <h5 class="book-title">{{ book.title }}</h5>
        <h6 class="book-author">{{ book.author }}</h6>
        <div class="button-container" v-if="!enableAdd"></div>
        <button id="current-book" @click="isCurrent = !isCurrent">
          {{ isCurrent ? "Current Book" : "Mark Current?" }}
        </button>
      </div>
    </div>
  </div>
</template>

<script>
// import BookDetail from "@/components/BookDetail.vue";

export default {
  name: "book-card",
  props: {
    book: Object,
  },
  data() {
    return {
      isCurrent: false,
          };
     }
}
</script>

<style scoped>
.card {
  border: 2px solid black;
  width: 150px;
  height: 200px;
  margin: 0px;
  margin-bottom: 30px;
  border-radius: 5px;
}

.book-image {
  width: 150px;
  height: 200px;
}

.book-image:hover {
  transform: skewX(-20deg);
  transform: skewY(5deg);
}
@keyframes fadeOut {
  0% {
    opacity: 1;
  }
  100% {
    opacity: 0;
  }
}
.book-card {
  width: 170px;
  height: 230px;
  margin: 5px;
  margin-bottom: 80px;
  border: 2px solid;
  background: black;
}

.style-book {
  text-align: center;
  background-color: rgb(19, 62, 80);
  border-radius: 5p;
  color: rgb(253, 236, 250);
  border: 2px solid whitesmoke;
}

h5 {
  margin: 1px;
}
h6 {
  margin: 2px;
  font-style: italic;
}

button{
     font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  font-size: 10px;
  letter-spacing: 2px;
  border: 1px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 0 5px;
  position: relative;
  transition: opacity 0.3s linear 0s;
   background-color: rgb(19, 62, 80);
   cursor: pointer;
}
</style>