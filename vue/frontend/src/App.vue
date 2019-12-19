<template>
  <div id="app">
    <div class="nav_container">
      <img class="logo" src="./assets/images/athena-logo-new-just-owl.png"/>
    <nav id="nav"  >
      <ul class="navbar">
      <li class="navbar"><router-link to="/HomePage" ><i class="fa fa-home"></i>Home</router-link></li>
      <li class="navbar"><router-link to="/login"><i class="fa fa-sign-in"></i>Login</router-link></li>
      <li class="navbar"><router-link to="/Chatbox" ><i class="fa fa-comment"></i>Chatbot</router-link></li>
      <li class="navbar"><router-link to="/AboutUs"><i class="fa fa-info-circle"></i>About Us</router-link></li>
      </ul>
    </nav>
    </div>
    <!-- <div class="hideThis">
      <login @login-user="setUser"/>
      <chat-box :user="user"/>
    </div> -->
    <router-view/>
    <div class="footer">
      <a href="#" class="fa fa-facebook"></a>
      <a href="#" class="fa fa-twitter"></a>
      <a href="#" class="fa fa-google"></a>
      <a href="#" class="fa fa-linkedin"></a>
      <p> The Owl of Athena copy right 2019.</p>
    </div>
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
.fa-info-circle{
   border: none;
  color: white;
  padding: 0px 0px !important;
  font-size: 16px;
  cursor: pointer;
  margin: 4px !important;
}
.fa-comment{
  border: none;
  color: white;
  padding: 0px 0px !important;
  font-size: 16px;
  cursor: pointer;
  margin: 4px !important;
}
.fa-sign-in{
  border: none;
  color: white;
  padding: 0px 0px !important;
  font-size: 16px;
  cursor: pointer;
  margin: 4px !important;
}
.fa-home{
  border: none;
  color: white;
  padding: 0px 0px !important;
  font-size: 16px;
  cursor: pointer;
  margin: 4px !important;
}
.fa {
  margin: 1rem;
  padding: 10px;
  font-size: 15px;
  width: 25px;
  text-align: center;
  text-decoration: none;
  margin: 1rem;
  border-radius: 3rem;
}

.fa:hover {
    opacity: 0.7;
}
.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}

.fa-google {
  background: #dd4b39;
  color: white;
}

.fa-linkedin {
  background: #007bb5;
  color: white;
}

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
  /* padding: 1%; */
  width: 80%;
  height: 1%;
  margin: 0 auto;
  background: linear-gradient(to bottom right, #76323F, #cbad77);
}
.footer p{
  display: inline-block;
  float: right;
  margin: 2rem 2rem;
  color: #d7cec7;
}
.marketing_text{
  height: auto;
  font-size: smaller;
  color: #3d1920 !important;
}
</style>
