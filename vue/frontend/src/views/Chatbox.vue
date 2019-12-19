<template>
  <div class="chatBox">
    <chat-bot-demo
      :categories="categories"
      :workflows="workflows"
      :subworkflows="subworkflows"
      :userColors="colors"
      :user="user"
      :jobSearchArray="jobSearchArray"
      @get-jobs="getJobsByJobPositionId"
      @get-workflows="getWorkFlows"
      @get-subworkflows="getSubwWorkflows"
    />
  </div>
</template>

<script>
import ChatBotDemo from "../component/ChatBotDemo.vue";



export default {
  name: "chat-box",
  components:{
    ChatBotDemo
  },
  props:{
    user:Object
  },
  data() {
    return {
      API_URL: 'http://localhost:8080/ChatBot/api',
      categories:[],
      workflows:[],
      subworkflows:[],
      userInput: "",
      // user:{
      //   userName: 'superman',
      //   password: 'password',
      //   confirmPassword: 'password',
      //   role: 'student',
      //   firstName: 'Clark',
      //   lastName: 'Kent',
      //   avatar:'',
      //   jobSelections:[
      //     {id: 1, name: "Software Engineer"}, 
      //     {id: 2, name: "Database Administrator"}, 
      //     {id: 3, name: "Data Analyst"}]
      // },
      jobSearchArray:[],
      colors: {
        header: {
          bg: "#565656",
          text: "whitesmoke"
        },
        launcher: {
          bg: "#c2a080",
        },
        messageList: {
          bg: "#c2a080"
        },
        sentMessage: {
          bg: "#d7cec7",
          text: "#763240"
        },
        receivedMessage: {
          bg: "#763240",
          text: "whitesmoke"
        },
        userInput: {
          bg: "#f9f295",
          text: "#565867"
        }
        
      }, // specifies the color scheme for the component
    };
  },
  methods: {
    getCategories(){
      fetch(`${this.API_URL}/category`)
        .then(response => response.json())
        .then(list => (this.categories = list))
        .catch(err => console.error(err));
    },
    
    getWorkFlows(n){
      fetch(`${this.API_URL}/workflow/${n}`)
        .then(response => response.json())
        .then(list => (this.workflows = list))
        .catch(err => console.error(err));
    },
    
    getSubwWorkflows(n){
        fetch(`${this.API_URL}/subworkflow/${n}`)
        .then(response => response.json())
        .then(list => (this.subworkflows = list))
        .catch(err => console.error(err));
    },
  
    getAnswers(n){
        fetch(`${this.API_URL}/answer/${n}`)
        .then(response => response.json())
        .then(list => (this.answers = list))
        .catch(err => console.error(err));
    },

     getAllJobs() {
        fetch(`${this.API_URL}/jobSearch`)
          .then(response => response.json())
          .then(list => (this.jobResults = list))
          .catch(err => console.error(err));
      },

      getJobsByJobPositionId(n){
        fetch(`${this.API_URL}/jobSearch/${n}`)
          .then(response => response.json())
          .then(list => (this.jobSearchArray = list))
          .catch(err => console.error(err));
      },

      getJobPositions() {
        fetch(`${this.API_URL}/jobPositionSearch`)
          .then(response => response.json())
          .then(list => (this.jobPositionResults = list))
          .catch(err => console.error(err));
      }
  },
  computed: {

  },
  watch: {

  },
  created(){
    console.log("in created");
      this.getCategories();
      //  this.getWorkFlows();
      //  this.getSubwWorkflows();
      }
  
};

</script>

<style>

</style>

