<template>
  <div id="app">
    <div class="nav_container">
      <img class="logo" src="./assets/images/athena-logo-new-just-owl.png"/>
    <nav id="nav"  >
      <ul class="navbar">
      <li class="navbar"><router-link to="/HomePage" >Home</router-link></li>
      <li class="navbar"><router-link to="/login">Login</router-link></li>
      <li class="navbar"><router-link to="/Chatbox" >Chatbot</router-link></li>
      </ul>
    </nav>
    </div>
    <!-- <div class="hideThis">
      <login @login-user="setUser"/>
      <chat-box :user="user"/>
    </div> -->
    <router-view/>
  </div>
</template>

<script>
  // import ChatBox from '@/views/Chatbox.vue'
  // import Login from '@/views/Login.vue';
 export default {
    name: 'app',
     components: {
      //  ChatBox,
      //  Login
    },
   data() {
     return {
       API_URL: 'http://localhost:8080/ChatBot/api',
       user:{}
     };
   },

   methods: {
    setUser(object){
      this.user = object;
    }
   },
   
  //  created(){
  //    console.log("in created");
  //      this.getCategories();
  //      this.getWorkFlows();
  //        console.log("test: "+ this.categories);
  //        console.log("test2: "+ this.workflows);
  //     }
   
 }



</script>
<style>
/* .hideThis{
  display: none;
} */
head{
  font-size: 4rem;
}
html {
background-color: rgb(201, 202, 206);
background-size: cover;
background-repeat: no-repeat;
height: 100%;
overflow: hidden;
font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
overflow-y: scroll;
}

div.pageText{

    text-align: center;
    padding-left: 25%;
    font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
    font-weight: bolder;
    overflow: hidden;
    max-width: 100%;
}

div.row {
  display: flex;
  flex-direction: row;
  height: 100%;
  width: 80%;
  max-width: 80%;
  margin: 0 auto;
  align-items: center;
  flex-wrap: wrap;
  background-color: rgb(115, 132, 187);
  font-size: 1.5rem;
  font-stretch: expanded;
  font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
  -webkit-text-fill-color: #651d1d;
}

div#register.text-center {
width: 80%;
padding: 10.5%;
  
}

.btn{
  border-radius: 50px;
  height: 3.75em;
  width: 80%;
  font-size: .60em;
  background-color: rgb(249, 247, 243);
  -webkit-text-fill-color: black;
  font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
}

button.submit {
  font-size: 1.5rem;
  font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
}

div#app{ 
  width: 80%;
  margin: 0 auto;
}

h1#title_phrase {
  -webkit-text-fill-color: #651d1d;
  text-justify: initial;
  text-shadow: 1em;
}

div#final_text{
  align-items: baseline;
}

h1.Athena_Logo_Text {
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: 4em;
  font-stretch: expanded;
  -webkit-text-fill-color: #651d1d;
}

h4.achieve{
  -webkit-text-fill-color: rgb(249, 247, 243);
}
h4.Do_More {
  -webkit-text-fill-color: rgb(249, 247, 243);
}

h4.elevate{
  -webkit-text-fill-color: #651d1d;
}

div.nav_container{
  width: 80%;
  margin: 0 auto;
  background-color: rgb(160, 142, 38);
}

div.nav_container::after{
  content: '';
  display: table;
  clear: both;
}

img.img {
  height: auto;
  max-width: 100%;
}

img.logo{
  float: left;
  padding: 5px 0;
  height: 5rem;
}

nav {
  float: right;
}
ul.nav{
  margin: 0;
  padding: 0;
  list-style: none;
  justify-content: center;
  border: solid;
}

button.nav_btn{
  font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
  text-transform: uppercase;

}

ul.nav:hover{
  color: whitesmoke;
}

li.navbar{
  display: inline-block;
  margin-left: 70px;
  margin: 0 35px;
  padding-top: 25px;
  font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
  text-decoration: none;
  text-transform: uppercase;
  font-size: .90rem;
  -webkit-text-fill-color: whitesmoke;

}
label.sr-only{
  -webkit-text-fill-color: black;
}

.navbar a {
  font-size: 1.25rem;
  -webkit-text-fill-color: whitesmoke;
  text-decoration: none;
}

li.navbar:hover{
  color: whitesmoke;
}

li.nav_btn{
  margin: 20px;
  border-radius: 90px;
  height: 100%;
  width: 100%;
  font-size: 1em;
  -webkit-text-fill-color: whitesmoke;
  background-color: #e0e0e8;

}
div#login.text-center {
  display: flex;
  flex-direction: column;
  width: 80%;
  padding: 12%;
}

div#homePage {
  align-items: center;
  flex-wrap: wrap;
}

div.left_container#homePage{
  -ms-flex-order: 1;
  min-width: 12em;
  max-width: 30%;
  margin-right: 7em;
}

div.right_container#homePage {
  -ms-flex-order: 2;
  width: 80%;
  align-self:  left;
  background-color:  aliceblue;
  min-width: 50%;
}

div.jobs{
  background: sandybrown;
  color: black;
  font-weight: bold;
  padding: 2%;
  margin: 1%;
  border: black;
}

h3#sign_up_or_login{
  align-self: center;
}

</style>
