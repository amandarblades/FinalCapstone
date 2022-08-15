<template>
  <div>
       <div class="form-container">
      <h2>Family Library</h2>
      <button  id="add-family" @click="isUpdating= !isUpdating">{{isUpdating ? 'Discard Changes' : 'Update Family'}}</button>
           <add-new-family v-show="isUpdating"></add-new-family>
      
      
          <family-list></family-list>

      
  </div>
  <add-member-to-family ></add-member-to-family >
    </div>
</template>

<script>
import AddNewFamily from "@/components/AddNewFamily.vue"
import familyList from "@/components/FamilyList.vue"
import FamilyService from "@/services/FamilyService.js"
import addMemberToFamily from "@/components/AddMemberToFamily.vue"

export default {
    name: "add-family",
    components:{
        AddNewFamily,
        familyList,
        addMemberToFamily
    },
    props: [
         "user"
    ],
    data() {
         return{
         isUpdating: false
    }
    },
    methods: {
     //     addFamily(name){
     //          window.alert("FIRE FIRE FIRE");
     //          FamilyService.createFamily(name)
     //          .then((response) =>{
     //          this.$store.commit("SET_FAMILY_NAME", response.data);
     //          window.location.reload()});
         
         addMemberToFamily(){
              FamilyService.addMemberToFamily(this.family.name, this.user)
              .then(( response) => 
              this.$store.commit("SET_FAMILY_MEMBER", response.data));
              window.location.reload();
         }
    }
}
</script>

<style scoped>
#add-family:hover{
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
     color: white;
     transition: 0.7s;
} 
/*------------------------*/

#add-family{
  font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  line-height: 45px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 0 42px;
  position: relative;
  transition: opacity 0.3s linear 0s;
  background-color: rgb(19, 62, 80)
}



</style>