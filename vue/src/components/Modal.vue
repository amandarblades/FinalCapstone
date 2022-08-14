<template>
  <div class="modal-container" :style="{backgroundImage: '@/public/libraryCard.png'}">
       <div class="modal">
            <section name="form-hold">
                 Family Library
           </section>
               <button type="button" class="btn-close"></button>
       </div>
  </div>
</template>

<script>
export default {
     name: 'Modal',
    

};
</script>

<style>
.modal-container{
     position:fixed;
     top: 0;
     bottom: 0;
     left: 0;
     right: 0;
     display:flex;
     justify-content: center;
     align-items: center;
}
.modal{
     box-shadow: 2px 2px 20px 1px;
     overflow-x: auto;
     display:flex;
     flex-direction: column;
}
.form-hold{
     padding: 15px;
     display: flex;
}

</style>