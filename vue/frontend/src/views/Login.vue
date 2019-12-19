<template>
<div class="loginScreen">  
    <form class="form-signin" @submit.prevent="startLogin">
      <div class="container">
        <h1>Sign In</h1>
        <div class="imgcontainer">
          <img src="https://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatar">
        </div>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.userName"
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
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
      </div>
    </form>
  </div>

</template>

<script>
import auth from "../auth";

export default {
  name: "login",
  components: {},
  data() {
    return {
      API_URL: "http://localhost:8080/ChatBot",
      user: {
        userName: '',
        password: '',
        confirmPassword: '',
        role: '',
        firstName: '',
        lastName: '',
        avatar:'',
        jobSelections:[]
      },
      invalidCredentials: false,
      validCredentials: false
    };
  },
  methods: {
    login() {
      //v-on:click.prevent="getLoginUser()"
      //${process.env.VUE_APP_REMOTE_API}
      fetch(`${this.API_URL}/login`, {
        method: 'POST',
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.user)
      })
        .then(response => {
          if (response.ok) {
            this.validCredentials = true;
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then(token => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, "");
            }
            auth.saveToken(token);

          }
        })
        .catch(err => console.error(err));
    },

    getLoginUser(){
        fetch(`${this.API_URL}/api/user/${this.user.userName}`)
         .then(response => response.json())
         .then(list => this.user = list)
         .then(() => {
             const userObject = this.user;
             this.$router.push({name: 'chatbox', params:{ user: userObject}})
          })
         .catch(err => console.error(err));
     },

     startLogin(){
        this.login();
        console.log('Invalid ' + this.invalidCredentials)
        if(!this.invalidCredentials){
          this.getLoginUser();
        }  
     },
  },
  
};
</script>
<style>
.loginScreen{
  width: 80%;
  margin: 0% auto;
  background: #c09f80;
  padding-bottom: 1rem;
}
img.avatar {
  width: 40%;
  border-radius: 50%;
}
h1{
  text-align: center;
}
form {
  border: 3px solid #c09f80;
  background-color: #eaf5f5;
  border-radius: 1rem;
  margin: 0 auto;
  width: 50%;
  text-align: center;
}

label{
  display: block;
  text-align: left
}

input[type="text"],
input[type="password"] {
  display: block;
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  display: block;
  text-align: center;
  color:whitesmoke;
  border: solid;
  border-color: #76323F;
  border-bottom: outset;
  border-left: outset;
  border-left-color: #76323F;
  border-radius: 1rem;
  height: 4em;
  width: 50%;
  background-color: #3c1920;
  cursor: pointer;
  margin: 0 auto;
  margin-top: 1rem
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 20%;
  border-radius: 50%;
}

.container {
  padding: 2%;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
    display: block;
    float: none;
  }
  .cancelbtn {
    width: 100%;
  }
}
</style>
