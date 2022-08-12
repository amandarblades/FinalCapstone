<template>
  <div>
      <h2>Register your Family!</h2>
      <add-new-family></add-new-family>
  </div>
  
</template>

<script>
import AddNewFamily from "@/components/AddNewFamily.vue"
export default {
    name: "add-family",
    components:{
        AddNewFamily
    }
}
</script>

<style>

</style>