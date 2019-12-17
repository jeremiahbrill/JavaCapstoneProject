<template>
  <div id="app">
    <div id="nav"  >
      <button class="nav_btn"><router-link to="/HomePage" >Home</router-link></button>
      <button class="nav_btn"><router-link to="/" >Login</router-link></button>
      <button class="nav_btn"><router-link to="/Chatbox" >Chatbox</router-link></button>
      <button class="nav_btn"><router-link to="/Chatbox" >Chatbox</router-link></button>
      <button class="nav_btn"><router-link to="/JobSearch" >Job Search</router-link></button>
    </div>
    <router-view/>
  </div>
</template>

<script>
  //import chatbox from '@/views/Chatbox'

//  export default {
//     name: 'app',
    //  components: {
    //    chatbox
    // },
//    data() {
//      return {
//        API_URL: 'http://localhost:8080/ChatBot/api',
//        categories:[],
//        workflows:[],
//        subworkflows:[]
//      };
//    },

//    methods: {

//    },
   
//    created(){
//      console.log("in created");
//        this.getCategories();
//        this.getWorkFlows();
//          console.log("test: "+ this.categories);
//          console.log("test2: "+ this.workflows);
//       }
   
//  }



</script>
<style>
body{
    background-image: url("./assets/images/ws_Nice_Mountain_Top_Clouds_Foggy_1440x900.jpg");
    background-repeat: no-repeat;
    background-size:cover;
}
body.img{
  height: 100%;
}

div.pageText{
  align-content: right;
  width: 100%;
  padding-left: 100%;
  text-justify: auto
  
}

div.row {
  display: flex;
  flex-direction: row;
  height: 100%;
  width: 100%;
  align-items: center;
  flex-wrap: wrap;
  background-color: rgb(115, 132, 187);
}

.mp4 {
  width: 100%;
}

.img {
  size: 2em;
  align-content: space-between;
  margin-left: 1%;
  border-block-color: black;
  border-width: 10%;
}

img.AOE_Logo{
  border-end-end-radius: 50px;
  background-color: transparent;
  height: 3.75em;
  width: 80%;

}

.btn{
  border-radius: 50px;
  height: 3.75em;
  width: 80%;
  font-size: .60em;
  background-color: rgb(249, 247, 243);
  -webkit-text-fill-color: black;
}

div#nav{ 
  justify-content: center;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  padding-left: 5%;
  padding-right: 10%;
  margin: 1em;
  margin-right: .5em;
  
}

h2#title_phrase {
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
h4.AOE {
  -webkit-text-fill-color: rgb(249, 247, 243);
}

h4.elevate{
  -webkit-text-fill-color: #651d1d;
}

button.nav_btn{
  margin: 20px;
  border-radius: 90px;
  height: 100%;
  width: 100%;
  font-size: 1em;
  background-color: #e0e0e8;
  -webkit-text-fill-color: black;
}
div#login.text-center {
  display: flex;
  flex-direction: column;
  
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
  width: 50%;
  align-self:  right;
  background-color:  aliceblue;
  padding-right: 100%;
}

div.jobs{
  background: sandybrown;
  color: black;
  font-weight: bold;
  padding: 2%;
  margin: 1%;
  border: black;
}

</style>
