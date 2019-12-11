<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link>
      <p/>
      <router-link to="/Chatbox">Chatbox</router-link>
      <p>
        <router-link to="/Splash">Splash Screen</router-link>
      </p>
    </div>
    <router-view/>
  </div>
</template>

<script>
// import chatbox from '@/components/Chatbox'

 export default {
//   name: 'app',
//   components: {
//     chatbox
//   }
   data() {
     return {
       API_URL: 'http://localhost:8080/ChatBot/api',
       categories:[],
       workflows:[],
       subworkflows:[]
     };
   },

   methods: {
     getCategories(){
       fetch(`${this.API_URL}/category`)
         .then(response => response.json())
         .then(list => (this.categories = list))
         .catch(err => console.error(err));
     },
     
     getWorkFlows(){
       fetch(`${this.API_URL}/workflow/1`)
         .then(response => response.json())
         .then(list => (this.workflows = list))
         .catch(err => console.error(err));
     },
     
     getSubWorkflows(){
        fetch(`${this.API_URL}/subworkflow/1`)
         .then(response => response.json())
         .then(list => (this.subworkflows = list))
         .catch(err => console.error(err));
     }
   }
   
  //  created(){
  //    console.log("in created");
  //    console.log(`${this.API_URL}category`);
  //      fetch(`${this.API_URL}/workflow/1`)
  //        .then(response => response.json())
  //        .then(list => (this.workflows = list))
  //        .catch(err => console.error(err));
  //        console.log("test: "+ this.workflows.length);
  //     }
   
 }



</script>
