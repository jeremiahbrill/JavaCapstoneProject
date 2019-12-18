<template>
<div>  
    <form class="form-signin" @submit.prevent="startLogin">
      <div class="container">
        <h1>Sign In</h1>
        <div class="imgcontainer">
          <img src="https://www.w3schools.com/howto/img_avatar.png" alt="Avatar" class="avatar">
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
import auth from '../auth';

export default {
  name: 'login',
  components: {},
  data() {
    return {
      API_URL: 'http://localhost:8080/ChatBot',
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
    };
  },
  methods: {
    login() {
      //v-on:click.prevent="getLoginUser()"
      //${process.env.VUE_APP_REMOTE_API}
      fetch(`${this.API_URL}/login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push('/chatbox');
          }
        })
        .catch((err) => console.error(err));
    },

    getLoginUser(){
        fetch(`${this.API_URL}/api/user/${this.user.userName}`)
         .then(response => response.json())
         .then(list => this.user = list)
         .catch(err => console.error(err));
       //emit the event to use the user data in parent component
       this.$emit("login-user", this.user);
     },

     startLogin(){
        this.login();
        if(!this.invalidCredentials){
          this.getLoginUser();
        }  
     },
  },
  
};
</script>
<style>
img.avatar {
  width: 40%;
  border-radius: 50%;
}
h1{
  text-align: center;
}
form {
  border: 3px solid #f1f1f1;
  background-color: #f1f1f1;
  border-radius: 8px;
  margin: 1% auto;
  max-width: 80%;
  }

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: rgb(160, 142, 38);
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 50px;
  cursor: pointer;
  width: 100%;
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
  width: 40%;
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
