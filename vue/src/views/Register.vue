<template>
  <div id="register" class="text-center">

    <form class="form-register" @submit.prevent="register">
      <h2 class="h3 mb-3 font-weight-normal">Create Account</h2>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <label for="isAdmin">If you are a parent, click here: </label>
      <input type="checkbox" id="isAdmin" v-on:click="user.role='admin'">
      <router-link :to="{ name: 'login' }" class='link'>Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
    <div class="book-container">
    <img id="book-image" src="blueTransparentBooks.png" alt="a book background" />
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user'
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
#register{
     font-family: 'Montserrat', sans-serif;
     background-size:auto;
     display: flex;
     flex-direction: column;
     align-items: center;
     justify-content: center;
     color: whitesmoke;
}
.link{
     color: #2abbb4
}
.form-register{
     display: flex;
     flex-direction: column;
     position: absolute;
     background-color: rgb(64, 56, 122);    
     padding: 0px 20px 20px 20px;
     border-radius: 10px;
     box-shadow: 4px -3px 0 0 white, 7px -5px 0 0 rgb(64, 56, 122);
     margin-top: -175px;
     
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
     background: linear-gradient(0deg, #2abbb4 0%, rgba(255,255,255,1) 30%);
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
