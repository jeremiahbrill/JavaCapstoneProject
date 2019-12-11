//this page is the chat window itself

<template>
  <div class="chatBotDemo">
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
      :showEmoji="false"
      :showFile="false"
      :showTypingIndicator="showTypingIndicator"
      :colors="userColors"
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
   name: "chat-bot-demo",
  props:{
    userColors:Object,
    botResponses:Array,
    chatLog: Array
  },
  data() {
    return {
        userInput:"",
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
        { type: "text", author: `user2`, data: { text: `Welcome To Chat Bot` }} 
      ], // the list of the messages to show, can be paginated and adjusted dynamically
      newMessagesCount: 0,
      isChatOpen: false, // to determine whether the chat window should be open or closed
      showTypingIndicator: "", // when set to a value matching the participant.id it shows the typing indicator for the specific user
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
    // getUserInput does the emit for thge chat log and the user-input which is what I am trying to get to work
    // I can get the user data to pass but I can not get the botResponses to pull from the chat. 
    // I am able to hard code data into the parent and make it work but then have to do even more logic 
    // on this page.
          getUserInput(){
          if(this.messageList[this.messageList.length - 1].author === 'me'){
              const userInput = this.messageList[this.messageList.length - 1].data.text;
              this.$emit('user-input', userInput);
              this.$emit('chat-log', this.messageList);
              return userInput;
          }
          return this.userInput;
      },
        getBotResponses(){
            const nameArray = [];
            this.botResponses.forEach(element => nameArray.push(element.name))
          if(this.botResponses.length === 0){
              return 0;
          }else if(this.messageList[this.messageList.length - 1].author === 'me'){
              console.log(this.botResponses)
              return this.sendMessage('This is what I can do in the Pathway Program', nameArray);
          }
          return null;
      }
  },
  //this computed keeps and eye on the the and when it changes the watch persom the methods.
  computed: {
      comUserInput(){
          return this.messageList;
      }
  },
  watch: {
      comUserInput(){
          this.getUserInput();
          this.getBotResponses();
      }
  }
};
</script>

<style scoped>

.sc-suggestions-element {
  margin: 3px;
  padding: 5px 10px 5px 10px;
  border: 1px solid;
  border-radius: 15px;
  font-size: 14px;
  background: black;
  cursor: pointer;
}

.sc-suggestions-row {
  text-align: center;
  background: inherit;
}
</style>