<template>
  <div>
      <h1>Add a new book!</h1>
      <add-new-book/>

  </div>
</template>

<script>
import AddNewBook from '../components/AddNewBook.vue'
export default {
    name: 'add-book',
  components: { AddNewBook },

}
</script>

<style>

</style>