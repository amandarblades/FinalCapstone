<template>
  <div class="container">
      <form>
          <div class="library-card">
            <h2>Log your minutes!</h2>
             <input type="text" name="minutes" id="logged-minutes">
          </div>
          <div >
              <h5>How did you read today?</h5>
              <select name="read-type" id="type">
                  <option selected disabled>Please Select Type</option>
                  <option value="1">Audiobook</option>
                  <option value="2">Digital</option>
                  <option value="3">Paper</option>
                  <option value="4">Read-Aloud(Reader)</option>
                  <option value="5">Read-Aloud(Listener)</option>
                  <option value="6">Other</option>
              </select>
              <button>Log it!</button>
          </div>
          
      </form>

  </div>
</template>

<script>
export default {
    name: 'add-activity',
    props: ['activity']

}
</script>

<style>

form>div>h2{
    color: whitesmoke;
}

form>div>h5{
    color: whitesmoke;
    margin-bottom: 0px;
}
/* .container{
     background-image: url("@/public/libraryCard.png");
} */
/* .library-card{
     background: color url('library-card.png');
} */

</style>