<template>
  <div>
       <h1>{{book.title}}</h1>
       <h3>{{book.author}}</h3>
       <!-- placeholder for image -->
          <p>{{book.status}}</p>

  </div>
</template>

<script>
export default {
  name: "book-detail",
  props: 
      ['book']
  
};
</script>

<style scoped>
div{
     background-color:black;
}


</style>