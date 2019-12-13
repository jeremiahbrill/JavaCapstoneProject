<template>
  <div class="chatBox">
    <chat-bot :categories="categories" 
    :workflows="workflows" 
    :subworkflows="subworkflows" 
    :chatLog="chatLog"
    :userInput="userInput"
    @bot-response-text="handleBotResponseText"
    @bot-response-suggestions="handleBotResponseSuggestions"
    @get-workflows="getWorkFlows"
    @get-subworkflows="getSubwWorkflows"></chat-bot>
    <chat-bot-demo :botResponseText="botResponseText" :botResponseSuggestions="botResponseSuggestions" :userColors="colors" @user-input="handleUserInput" @chat-log="handleChatLog"></chat-bot-demo>
  </div>
</template>

<script>
import ChatBot from "../component/ChatBot.vue";
import ChatBotDemo from "../component/ChatBotDemo.vue";

export default {
  name: "chat-box",
  components:{
    ChatBot,
    ChatBotDemo
  },
  data() {
    return {
       API_URL: 'http://localhost:8080/ChatBot/api',
       categories:[],
       workflows:[],
       subworkflows:[],
      botResponseText: "",
      botResponseSuggestions: [],
      userInput: "",
      chatLog: [],
      sampleCategories: [
          {
          id: 1,
          name: "Pathway"
          },
          {
          id: 2,
          name: "Curriculum"
          },
          {
          id: 3,
          name: "Job Search"
          } 
      ],
      sampleWorkflows: [
          {
          "id": 1,
          "name": "I need help with",
          "categoryId": 1
          },
          {
          "id": 2,
          "name": "Where can I learn about",
          "categoryId": 1
          },
          {
          "id": 3,
          "name": "I do not understand",
          "categoryId": 1
          },
          {
          "id": 4,
          "name": "What is",
          "categoryId": 1
          }
      ],
      sampleSubWorkflows: [
          {
          "id": 1,
          "name": "Writing a cover letter",
          "textAnswer": "provide your eleavtor pitch here, to get the best impression",
          "videoAnswer": null,
          "imageAnswer": null,
          "linkAnswer": null,
          "workflowId": 0
          },
          {
          "id": 2,
          "name": "Prepping for an interview",
          "textAnswer": "Be on time",
          "videoAnswer": null,
          "imageAnswer": null,
          "linkAnswer": null,
          "workflowId": 0
          },
          {
          "id": 3,
          "name": "Following up with employers",
          "textAnswer": "send an email",
          "videoAnswer": null,
          "imageAnswer": null,
          "linkAnswer": null,
          "workflowId": 0
          },
          {
          "id": 4,
          "name": "What to wear to an interview",
          "textAnswer": "wear busines casual",
          "videoAnswer": null,
          "imageAnswer": null,
          "linkAnswer": null,
          "workflowId": 0
          }
      ],
      colors: {
        header: {
          bg: "#F9F295",
          text: "#ffffff"
        },
        launcher: {
          bg: "#4e8cff"
        },
        messageList: {
          bg: "gray"
        },
        sentMessage: {
          bg: "black",
          text: "#ffffff"
        },
        receivedMessage: {
          bg: "#eaeaea",
          text: "#222222"
        },
        userInput: {
          bg: "#F9F295",
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
    handleBotResponseText(string){
      this.botResponseText = string;
    },
    handleBotResponseSuggestions(array){
      this.botResponseSuggestions = array;
    },
    handleUserInput(string){
      this.userInput = string;
    },
    handleChatLog(newArray){
      this.chatLog = newArray;
      console.log(this.chatLog)
    }
  },
  computed: {
    comUserInput(){
      return this.userInput;
    }
  },
  watch: {
    comUserInput(){
      console.log(this.userInput)
    }
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