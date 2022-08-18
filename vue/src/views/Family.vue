<template>
  <div class="background">
    
      <h2>{{this.$store.state.familyName}} Family Library</h2>
     
      <button id="add-family" @click="isUpdating = !isUpdating">
            
        {{ isUpdating ? "Discard Changes" : "Update Family" }}
      </button>
      <div class="form-container">
      <add-new-family v-show="isUpdating"></add-new-family>
    
    
    <div class="member-form-container">
    <add-member-to-family ></add-member-to-family></div>
    </div>
    <family-list ></family-list>
      <!-- <div class="logo"><img id="BW" src="bookworm.png" alt="Bookworm"></div> -->
  </div>
</template>

<script>
import AddNewFamily from "@/components/AddNewFamily.vue";
import FamilyList from "@/components/FamilyList.vue";
import addMemberToFamily from "@/components/AddMemberToFamily.vue";
import FamilyService from "@/services/FamilyService.js";


export default {
  name: "add-family",
  components: {
    AddNewFamily,
    FamilyList,
    addMemberToFamily,
  },
  //     props: [
  //          "user"
  //     ],
  data() {
    return {
      isUpdating: false,
    };
  },
  //     methods: {
  //     addFamily(name){
  //          window.alert("FIRE FIRE FIRE");
  //          FamilyService.createFamily(name)
  //          .then((response) =>{
  //          this.$store.commit("SET_FAMILY_NAME", response.data);
  //          window.location.reload()});

  //     addMemberToFamily(){
  //          FamilyService.addMemberToFamily(this.family.name, this.user)
  //          .then(( response) =>
  //          this.$store.commit("SET_FAMILY_MEMBER", response.data));
  //          window.location.reload();
  //     },
  //     },
 created(){
        FamilyService.getFamilyName()
        .then( (response) => {
            this.familyName = response.data;
            this.$store.commit("SET_FAMILY_NAME", response.data);
        });
 
   }
};
</script>

<style scoped>
.testing{
     background-color: black;
}

#add-family:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  color: white;
  transition: 0.7s;
  cursor: pointer;
}
/*------------------------*/

#add-family {
  font-family: "Montserrat", sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  line-height: 20px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  /* padding: 0 42px; */
  position: relative;
  transition: opacity 0.3s linear 0s;
  background-color: rgb(19, 62, 80);
  
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
input[type=text]{
     width: 90%;
     padding: 5px;
     border: 1px solid rgba(226, 223, 206, 0.767);
     border-radius: 4px;
     resize: vertical;
}

h2{
    
}

.button{
  font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  line-height: 20px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  position: relative;
  transition: opacity 0.3s linear 0s;
  background-color: rgb(19, 62, 80);
  transform: skewX(-20deg);
content: skewX(20deg);
margin-left: 2px;
cursor: pointer;
}
button:hover{
     /* transform: skewX(-20deg); */
     transition: 0.7s;
     cursor: pointer;
}
.form-container{
     margin-top: 25px;
     text-align: center;
     display: flex;
     align-items: center;
     justify-content: center;
     flex-direction: column;
     background-color: rgba(226, 223, 206, 0.767);
     border-radius: 5px;
      border: 2px solid black;
}
.member-form-container{
     margin-top: 20px;
     text-align: center;
     display: flex;
     align-items: center;
     justify-content: center;
     flex-direction: column;
    
     border-radius: 5px;
}

/* .background{
      background-color: #2abbb4;
     background: linear-gradient(0deg, rgba(42,187,180,1) 0%, rgba(255,255,255,1) 30%);
     width: 100vw;
     height: 90vh;
} */
/* #BW{
     height: 450px;
     length: auto;
     margin-left: 250px;
} */
/* .logo{
     margin-right: -100px;
} */

/* .form-container{
    
} */
/* label{
     padding: 5px;
} */
</style>