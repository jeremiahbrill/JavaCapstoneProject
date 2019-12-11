<template>
  <div id="app">
    <div id="nav"  >
      <router-link to="/">Home</router-link>
      <p/>
      <router-link to="/Chatbox">Chatbox</router-link>
      <p>
        <router-link to="/Splash">Splash Screen</router-link>
      </p>
      <router-link to="/Chatbox"  >Chatbox</router-link>

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
