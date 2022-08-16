<template>
  <div>
      <p v-for="item in testArray" :key="item.id">{{item.username}}</p>
      
      <p v-for="user in apiArray" :key="user.id">{{user.username}}</p>
  </div>
</template>

<script>
import FamilyService from "@/services/FamilyService.js"
import BookService from "@/services/BookService.js"

export default {
    name: "techTest",
    data() { return {
        testArray: [],
        apiArray: [],
        books: []

    }},
    created() {

        this.testArray = [
        {username: "Bob", minutesRead: 10},
        {username: "Mary", minutesRead: 10},
        {username: "Jake", minutesRead: 10}
      ];

      this.getAPIStuff();

    },

    methods: {

    getAPIStuff() {

        BookService.getBookList()
        .then( response =>{
                this.books = response.data;
        });

       FamilyService.getFamily().then( response => {
           this.apiArray = response.data;
        }).catch( (err=>{ console.log(err) }));

    }

    }

}
</script>

<style>

</style>