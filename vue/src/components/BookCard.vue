<template>
  <router-link v-bind:to="{name: 'book-details', params: {title: book.title}}">
      <div class="card" v-bind:class="{status: book.status}">
          <h2 class="book-title">{{book.title}}</h2>
          <!-- image of book cover here -->
          <h3 class="book-author">{{book.author}}</h3>
          

      </div>

  </router-link>
</template>

<script>
export default {
    name: 'book-card',
    props: {
        book: Object
    }

}
</script>

<style>

.card{
    display: flex;
     flex-direction: column;
     position: absolute;
     background-color: #FFB997;    
     padding: 0px 10px 10px 10px;
     border-radius: 10px;
     box-shadow: 4px -3px 0 0 white, 7px -5px 0 0 #FFB997;
     margin-top: -100px;
}

</style>