<template>
  <div id="app">
    <div id="nav"  >
      <router-link to="/">Home</router-link>
      <p/>
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
//      getCategories(){
//        fetch(`${this.API_URL}/category`)
//          .then(response => response.json())
//          .then(list => (console.log("catrgories" + list)))
//          .catch(err => console.error(err));
//      },
     
//      getWorkFlows(){
//        fetch(`${this.API_URL}/workflow/1`)
//          .then(response => response.json())
//          .then(list => (console.log(list)))
//          .catch(err => console.error(err));
//      },
     
//      getSubWorkflows(){
//         fetch(`${this.API_URL}/subworkflow/1`)
//          .then(response => response.json())
//          .then(list => (this.subworkflows = list))
//          .catch(err => console.error(err));
//      }
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
