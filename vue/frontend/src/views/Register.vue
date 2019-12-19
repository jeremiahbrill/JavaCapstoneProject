<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        There were problems registering this user.
      </div>
      <label for="firstName" class="sr-only">First Name</label>
      <input
        type="text"
        id="firstname"
        class="form-control"
        placeholder="First Name"
        v-model="user.firstName"
        required
        autofocus
      />
      <label for="lastName" class="sr-only">Last Name</label>
      <input
        type="text"
        id="lastname"
        class="form-control"
        placeholder="Last Name"
        v-model="user.lastName"
        required
        autofocus
      />
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /> 
     
      <p>
      <label for="avatar" class="sr-only">Please select avatar</label>  
      <!-- <select v-model="user.avatar">      
      <option value="avatar1" data-thumbnail="../assets/images/avatar1.jpg"> avatar1 </option>
      <option value="avatar2"><img class="img" src="../assets/images/avatar2.jpg"/>avatar2</option>
      <option value="avatar3"><img class="img" src="../assets/images/avatar3.jpg"/>avatar3</option>
      </select> -->
      <ul>
      <li>
         <input type="checkbox">
         <img class="img" src="../assets/images/avatar1.jpg"/>
      </li>
      <li>
         <input type="checkbox">
         <img class="img" src="../assets/images/avatar2.jpg"/>
      </li>
      <li>
         <input type="checkbox">
         <img class="img" src="../assets/images/avatar3.jpg"/>
      </li>
    </ul>
      </p>
      <label for="jobPositions" class="sr-only">Please select Jobs you are interested in: </label>
       <span v-for="job in availableJobSelections" 
                v-bind:key="job.id" 
                v-on:click="updateUserJobPositions(job.id,$event)">
       <input type="checkbox"
        name="jobPositions"
         />
        {{job.name}}
       </span>
      <router-link :to="{ name: 'login' }">
        Have an account?
      </router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit" v-on:click.prevent="registerUser()">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    return {
      user: {
        userName: '',
        password: '',
        confirmPassword: '',
        role: '',
        firstName: '',
        lastName: '',
        avatar:'',
        jobSelections:[
          {
              "id": 1,
              "name": "Software Engineer"
           },
          {
             "id": 2,
             "name": "Database Administrator"
          },
          {
             "id": 3,
             "name": "Data Analyst"
          }
        ]
      },
      availableJobSelections:[],
      registrationErrors: false,
      API_URL: 'http://localhost:8080/ChatBot',
    };
  },
  methods: {
    register() {
      console.log("url" +process.env.VUE_APP_REMOTE_API) +
      fetch(`${this.API_URL}/register`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
     
      })
        .then((response) => {
          console.log("test json" + JSON.stringify(this.user));
          if (response.ok) {
            console.log("ok")
            this.$router.push({ path: '/login', query: { registration: 'success' } });
          } else {
            this.registrationErrors = true;
          }
        })

        .then((err) => console.error(err));
    },
    getJobPositions() {
        fetch(`${this.API_URL}/api/jobPositionSearch`)
          .then(response => response.json())
          .then(list => (this.availableJobSelections = list))
          .catch(err => console.error(err));
      },
    updateUserJobPositions(id,event) { 
      this.availableJobSelections.forEach(element => {
        console.log("checkbox: " + event.traget);
        if(element.id === id){
           this.user.jobSelections.push(element);
        }
      })  
    }, 
    registerUser(){
      this.register(); 
      this.$emit("register-user", this.user);
    },
  },
  created(){
      this.getJobPositions();
      console.log("register job positions:" + this.availableJobSelections );
  }
};
</script>

