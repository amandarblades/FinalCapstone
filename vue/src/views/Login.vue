<template>
  <div id="login" class="text-center" >
       
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }" class="link">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
    <div class="book-container">
    <img id="book-image" src="blueTransparentBooks.png" alt="a book background" />
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/home");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
#login{
     font-family:  'Montserrat', sans-serif;
     background-size:auto;
     display: flex;
     flex-direction: column;
     align-items: center;
     justify-content: center;

}
.link{
     padding: 3px;
     margin-top: 2px;
}
.form-signin{
     display: flex;
     flex-direction: column;
     position: absolute;
     background-color: #2abbb4;    
     padding: 0px 20px 20px 20px;
     border-radius: 10px;
     box-shadow: 4px -3px 0 0 white, 7px -5px 0 0 #2abbb4;
     margin-top: -125px;
     
}
label{
     padding: 5px;
}

#book-image{
     Max-width: 50em;
     max-height: 50em;
     z-index: -1;
     position: relative;
     top: 0;
     left: 0;

}

.book-container{
     background-color: #2abbb4;
     background: linear-gradient(0deg, rgba(42,187,180,1) 0%, rgba(255,255,255,1) 30%);
     width: 100vw;
     height: 90vh;
     z-index: -2;
     display: flex;
     align-items: flex-end;
     justify-content: flex-end;
}
button {
      font-family: 'Montserrat', sans-serif;
  color: white;
  text-transform: uppercase;
  text-decoration: none;
  letter-spacing: 2px;
  border: 2px solid #fff;
  border-radius: 3px;
  box-shadow: 0 -3px rgba(0, 0, 0, 0.1) inset;
  padding: 10px;
  width: 100;
  /* position: relative; */
  transition: opacity 0.3s linear 0s;
  background-color: rgb(19, 62, 80);
 margin: 10px;
}

button:hover 
{
     transform: skewX(-20deg);
     transition: 0.7s;
}
</style>
