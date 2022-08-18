<template>
  <div class ="add-family">

    <form action="">
      <label for="name" >Update Family Name: </label>
     
      <input type="text" v-model="familyName"/>
      <input @click="addFamily(familyName)" type="submit">
       <p>(You will automatically be added to your family)</p>
    </form>

   
  </div>
</template>

<script>
import FamilyService from '@/services/FamilyService'

export default {
  name: "add-new-family",
  data(){
       return {
         familyName: ''
    //         family: [
    //   {
    //     name: '',
    //     user: {
    //          userID: 0 ,
    //          username: '',
    //          minutesRead: '', 
    //          currentBook: '',
    //          displayName: ''
    //     }
    //   }
    // ]
            }
       },
  // props: [
  //   'family'
  // ],
  methods: {
    addFamily(familyName){
      window.alert("ADDED NEW FAMILY");
      FamilyService.createFamily(familyName)
      .then((response) =>{
        this.$store.commit("SET_FAMILY_NAME", response.data);
        window.location.reload();
      });

    }
  }
}
</script>

<style scoped>
img{
     max-width: 100vw;
     max-height: 80vh;
}
input[type=submit],
input[type=reset]{
      font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 10px;
  width: 20%;
  position: relative;
  transition: opacity 0.3s linear 0s;
  background-color: rgb(19, 62, 80);
 margin: 10px;
}

p{
     font-size: smaller;
     color: rgb(128, 126, 118)
}

input[type=submit]:hover,
input[type=reset]:hover 
{
     transform: skewX(-20deg);
     transition: 0.7s;
     cursor: pointer;
}
input[type=text] {
     width: 75%;
     padding: 15px;
     border: 1px solid rgba(226, 223, 206, 0.767);
     border-radius: 4px;
     resize: vertical;
}
.add-family{
     display: flex;
     justify-content: center;
     align-items: center;
}


</style>