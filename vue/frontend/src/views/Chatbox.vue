<template>
  <div class="chatBox">
    <chat-bot :categories="sampleCategories" 
    :workflows="sampleWorkflows" 
    :subWorkflows="sampleSubWorkflows" 
    :chatLog="chatLog"
    :userInput="userInput"
    @bot-responses="handleBotResponses"></chat-bot>
    <chat-bot-demo :botResponses="botResponsesOutput" :userColors="colors" @user-input="handleUserInput" @chat-log="handleChatLog"></chat-bot-demo>
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
      botResponsesOutput: [],
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
    handleBotResponses(newArray){
      this.botResponsesOutput = newArray;
      console.log("Does handleBotResponses happen")
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
  }
};
</script>

<style>

</style>