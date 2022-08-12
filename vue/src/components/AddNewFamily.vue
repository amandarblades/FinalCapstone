<template>
  <div class ="add-family">

    <form action="">
      <label for="name">What would you like to call your Family?</label>
      <input type="text">
      <button type="submit">Submit</button>
    </form>

  </div>
</template>

<script>
export default {
  name: "add-new-family",
  props: [
    'family'
  ]
  

}
</script>

<style>

</style>