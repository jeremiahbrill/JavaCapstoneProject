<template>
  <div id="app">
    <div class="nav_container">
      <img class="logo" src="./assets/images/athena-logo-new-just-owl.png"/>
    <nav id="nav"  >
      <ul class="navbar">
      <li class="navbar"><router-link to="/HomePage" >Home</router-link></li>
      <li class="navbar"><router-link to="/login">Login</router-link></li>
      <li class="navbar"><router-link to="/Chatbox" >Chatbot</router-link></li>
      <li class="navbar"><router-link to="/AboutUs">About Us</router-link></li>
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

background-color: #D7CEC7;
background-size: cover;
background-repeat: no-repeat;
height: 100%;
overflow: hidden;
font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
overflow-y: scroll;
}

body{
  margin: 0%;
}

/* div.pageText{

    text-align: center;
    padding-left: 25%;
    font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
    font-weight: bolder;
    overflow: hidden;
    max-width: 100%;
} */

div#register.text-center {
width: 80%;
margin: 0 auto;
background: #c09f80;
}

div.row {
  display: flex;
  flex-direction: row;
  height: 100%;
  width: 80%;
  max-width: 80%;
  margin: 0 auto;
  align-items: flex-start;
  flex-wrap: wrap;
  background-color: #c09f80;
  font-size: 1.5rem;
  font-stretch: expanded;
  font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
  color: #f5f5f5;
}

side_container.btn{
  text-align: center;
}
.get_started{
    border: solid;
    border-color: #76323F;
    border-bottom: outset;
    border-left: outset;
    border-left-color: #76323F;
    border-radius: 50px;
    height: 2em;
    width: 50%;
    font-size: .60em;
    background-color: #3c1920;
    -webkit-text-fill-color: whitesmoke;
    font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
    padding: 3% 0% 0% 0%;
    text-align: center;
}
.btn{
  border-radius: 50px;
  height: 5.5em;
  width: 80%;
  font-size: .60em;
  background-color: #76323F;
  -webkit-text-fill-color: whitesmoke;
  font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
  margin-bottom: 10%;
}

button.submit {
  font-size: 1.5rem;
  font-family: 'Inria Serif', serif, 'Oswald', sans-serif;
}

div#app{ 
  width: 80%;
  margin: 0 auto;
}

h4.achieve{
  -webkit-text-fill-color: #F4f4f4;
}
h4.Do_More {
  -webkit-text-fill-color: #F4f4f4;
}

h4.elevate{
  -webkit-text-fill-color: #373737;
}

div.nav_container{
  width: 80%;
  margin: 0 auto;
  background-color: #565656;
  border-bottom: 11px solid;
  border-color: #76323F;
}

div.nav_container::after{
  content: '';
  display: table;
  clear: both;
}

img.img {
  height: auto;
  width: 100%;
}

img.logo{
  float: left;
  padding: 5px 0;
  height: 5rem;
}
.avatar{
  width: 30%;
  height: auto;
  justify-content: space-between;
}
.avatarFlex{
  display: flex;
  margin: 1rem;
}
.jobSelectionDiv{
  display: flex;
  margin: 1rem;
  flex-flow: wrap;
  justify-content: space-between;
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
  color: whitesmoke;

}
label.sr-only{
  -webkit-text-fill-color: #373737;
}

.navbar a {
  font-size: 1.25rem;
  -webkit-text-fill-color: whitesmoke;
  text-decoration: none;
}

li.navbar:hover{
  color: whitesmoke;
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

div.left_container{
  min-width: 20%;
  width: 45%;
  height: auto;
}
ul.avatar {
  display: flex;
  flex-direction: row;
  justify-content:space-around;
}

li {
  list-style-type: none;
}

.side_container{
  padding: 1%;
  width: 40%;
  height: 20%;
  text-align: -webkit-center;
  background-color: #d7cec7;
  border: #d7cec7 solid;
  border-radius: 3rem;
  margin-top: .5rem;
  margin-left: 2.5rem;
}

h4.achieve{
  text-align: left;
}
h4.elevate{
  text-align: center;
}
h4.Do_More{
  text-align: end;
}
.video_container{
  width: 100%;
  text-align: center;
}
.video_lable{
  background-color: #555555;
  border-bottom: 11px solid;
  border-color: #76323F;
  margin-bottom: 0% !important;  
}
.footer{
  padding: 1%;
  width: 100%;
  height: 1%;
  background: linear-gradient(to bottom right, #76323F, #cbad77);
}
.marketing_text{
  height: auto;
  font-size: smaller;
  color: #3d1920 !important;
}
</style>
