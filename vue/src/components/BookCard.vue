<template>
  <router-link v-bind:to="{name: 'book-details', params: {title: book.title}}">
      <div class="card" v-bind:class="{}">

      </div>

  </router-link>
</template>

<script>
export default {

}
</script>

<style>

</style>