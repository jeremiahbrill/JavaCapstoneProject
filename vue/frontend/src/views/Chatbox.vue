<template>
  <div>
    <beautiful-chat
      :participants="participants"
      :titleImageUrl="titleImageUrl"
      :onMessageWasSent="onMessageWasSent"
      :messageList="messageList"
      :newMessagesCount="newMessagesCount"
      :isOpen="isChatOpen"
      :close="closeChat"
      :icons="icons"
      :open="openChat"
      :showEmoji="true"
      :showFile="true"
      :showTypingIndicator="showTypingIndicator"
      :colors="colors"
      :alwaysScrollToBottom="alwaysScrollToBottom"
      :messageStyling="messageStyling"
      @onType="handleOnType"
      @edit="editMessage"
    />
  </div>
</template>

<script>

import CloseIcon from "vue-beautiful-chat/src/assets/close-icon.png";
import OpenIcon from "vue-beautiful-chat/src/assets/logo-no-bg.svg";
import FileIcon from "vue-beautiful-chat/src/assets/file.svg";
import CloseIconSvg from "vue-beautiful-chat/src/assets/close.svg";

export default {
  name: "chatbox",
  props:{
    categories:Array,
    workflows:Array,
    subworkflows:Array
  },
  data() {
    return {
        sampleCategory: [
            {
            categoryId: 1,
            categoryName: "Pathyway"
            },
            {
            categoryId: 2,
            categoryName: "Curriculum"
            },
            {
            categoryId: 3,
            categoryName: "Job Search"
            } 
        ],
        sampleWorkflow: [
            {
            "workflowId": 1,
            "workflowName": "I need help with",
            "categoryId": 1
            },
            {
            "workflowId": 2,
            "workflowName": "Where can I learn about",
            "categoryId": 1
            },
            {
            "workflowId": 3,
            "workflowName": "I do not understand",
            "categoryId": 1
            },
            {
            "workflowId": 4,
            "workflowName": "What is",
            "categoryId": 1
            }
        ],
        sampleSubWorkflow: [
            {
            "subWorkflowId": 1,
            "subWorkflowName": "Writing a cover letter",
            "textAnswer": "provide your eleavtor pitch here, to get the best impression",
            "videoAnswer": null,
            "imageAnswer": null,
            "linkAnswer": null,
            "workflowId": 0
            },
            {
            "subWorkflowId": 2,
            "subWorkflowName": "Prepping for an interview",
            "textAnswer": "Be on time",
            "videoAnswer": null,
            "imageAnswer": null,
            "linkAnswer": null,
            "workflowId": 0
            },
            {
            "subWorkflowId": 3,
            "subWorkflowName": "Following up with employers",
            "textAnswer": "send an email",
            "videoAnswer": null,
            "imageAnswer": null,
            "linkAnswer": null,
            "workflowId": 0
            },
            {
            "subWorkflowId": 4,
            "subWorkflowName": "What to wear to an interview",
            "textAnswer": "wear busines casual",
            "videoAnswer": null,
            "imageAnswer": null,
            "linkAnswer": null,
            "workflowId": 0
            }
        ],
      icons: {
        open: {
          img: OpenIcon,
          name: "default"
        },
        close: {
          img: CloseIcon,
          name: "default"
        },
        file: {
          img: FileIcon,
          name: "default"
        },
        closeSvg: {
          img: CloseIconSvg,
          name: "default"
        }
      },
      participants: [
        {
          id: "user1",
          name: "Matteo",
          imageUrl: "https://avatars3.githubusercontent.com/u/1915989?s=230&v=4"
        },
        {
          id: "user2",
          name: "Owl Boy",
          imageUrl:
            "https://avatars3.githubusercontent.com/u/37018832?s=200&v=4"
        }
      ], // the list of all the participant of the conversation. `name` is the user name, `id` is used to establish the author of a message, `imageUrl` is supposed to be the user avatar.
      titleImageUrl:
        "https://a.slack-edge.com/66f9/img/avatars-teams/ava_0001-34.png",
      messageList: [
        { type: "text", author: `user1`, data: { text: `No.` }},  
        { type: "text", author: `me`, data: { text: `Look at this!` } },
        { type: "text", author: `user2`, data: { text: `Owl Boy is` }, suggestions: ['some quick reply', 'another one', 'This', 'That', 'With', 'Then']} 
      ], // the list of the messages to show, can be paginated and adjusted dynamically
      newMessagesCount: 0,
      isChatOpen: false, // to determine whether the chat window should be open or closed
      showTypingIndicator: "", // when set to a value matching the participant.id it shows the typing indicator for the specific user
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
          bg: "#4e8cff",
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
      alwaysScrollToBottom: false, // when set to true always scrolls the chat to the bottom when new events are in (new message, user starts typing...)
      messageStyling: true // enables *bold* /emph/ _underline_ and such (more info at github.com/mattezza/msgdown)
    };
  },
  methods: {
    sendMessage(text, suggestions = []) {
      if (text.length > 0) {
        this.newMessagesCount = this.isChatOpen
          ? this.newMessagesCount
          : this.newMessagesCount + 1;
        this.onMessageWasSent({
          author: "user2",
          type: "text",
          data: { text },
          suggestions
        });
      }
    },
    onMessageWasSent(message) {
      // called when the user sends a message
      this.messageList = [...this.messageList, message];
      this.botResponse();
    },
    openChat() {
      // called when the user clicks on the fab button to open the chat
      this.isChatOpen = true;
      this.newMessagesCount = 0;
    },
    closeChat() {
      // called when the user clicks on the botton to close the chat
      this.isChatOpen = false;
    },
    handleScrollToTop() {
      // called when the user scrolls message list to top
      // leverage pagination for loading another page of messages
    },
    handleOnType() {
      console.log("Emit typing event");
    },
    editMessage(message) {
      const m = this.messageList.find(m => m.id === message.id);
      m.isEdited = true;
      m.data.text = message.data.text;
    },
    // This is the logic to our bot responses 
    botResponse(){
      console.log(this.workflows)
        const checkArray = [];
        this.workflows.forEach(element => { checkArray.push(element.workflowName)});
        const filter = this.messageList[this.messageList.length - 1].data.text;
        console.log(checkArray);
        if(checkArray.includes(filter) === true ){
            return this.sendMessage('Test');
        }
        else if (this.messageList[this.messageList.length - 1].author === 'me'){
            const responseText = [];
            this.workflows.forEach(element => {
                responseText.push(element.workflowName);
            });
            return this.sendMessage('Did not get that', responseText)
        }
            return null;
      }
  },

  computed: {

  }
};
</script>

<style>

</style>