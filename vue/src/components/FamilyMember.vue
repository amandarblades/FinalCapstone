<template>
<div>
  <h3>username</h3>
  <h5>minutes logged:</h5>
  <book-list></book-list>


</div>

</template>

<script>
import BookList from '@/components/BookList.vue'
export default {
    components:
        {BookList}

}
</script>

<style>

</style>