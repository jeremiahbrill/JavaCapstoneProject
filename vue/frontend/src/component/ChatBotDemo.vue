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

    <p class="hide"><job-search
    :jobSearchDisplay="jobSearchArray"
    :open='openWindow'
    /></p> 

    <div class="hide">
      <p>{{categories}}</p>
      <p>{{workflows}}</p>
      <p>{{subworkflows}}</p>
      <p>{{jobArray}}</p>
    </div>
  </div>
</template>

<script>

import CloseIcon from "vue-beautiful-chat/src/assets/close-icon.png";
import OpenIcon from "vue-beautiful-chat/src/assets/logo-no-bg.svg";
import FileIcon from "vue-beautiful-chat/src/assets/file.svg";
import CloseIconSvg from "vue-beautiful-chat/src/assets/close.svg";
import JobSearch from "../component/JobSearch.vue";

export default {
   name: "chat-bot-demo",
   components:{
     JobSearch
   },
  props:{
    userColors:Object,
    categories:Array,
    workflows:Array,
    subworkflows:Array,
    user:Object,
    jobSearchArray:Array,
  },
  data() {
    return {
      //Bot data starts here. Used by the methods for keeping track of bot logic
      userChoiceId: 0,
      userLastChoiceID: 0,
      searchArray: [],
      jobArray: [],
      openWindow: false,
      foundAnswer: false,
      checkedCategories: false,
      checkedWorkflows: false,
      checkedSubworkflows: false,
      pickedJobSearch: false,
      //This is the end of bot data added
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
          name: "Chat Bot",
          imageUrl: "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQr58HCf19wO41wbKeFHFxroROkVjCk6CfNjhxU_o65_YyH2Pu4"
        }
      ], // the list of all the participant of the conversation. `name` is the user name, `id` is used to establish the author of a message, `imageUrl` is supposed to be the user avatar.
      titleImageUrl:
        "https://a.slack-edge.com/66f9/img/avatars-teams/ava_0001-34.png",
      messageList: [
        { type: "text", author: `user1`, data: { text: `Welcome ${this.user.lastName} To Chat Bot`}, suggestions:['Pathway', 'Curriculum', 'Job Search'] } 
      ], // the list of the messages to show, can be paginated and adjusted dynamically
      newMessagesCount: 0,
      isChatOpen: false, // to determine whether the chat window should be open or closed
      showTypingIndicator: "", // when set to a value matching the participant.id it shows the typing indicator for the specific user
      alwaysScrollToBottom: false, // when set to true always scrolls the chat to the bottom when new events are in (new message, user starts typing...)
      messageStyling: true // enables *bold* /emph/ _underline_ and such (more info at github.com/mattezza/msgdown)
    };
  },
  methods: {
    //this is used to send the bot Text in chat and set the suggestion options for the user
    sendMessage(text, suggestions = []) {
      if (text.length > 0) {
        this.newMessagesCount = this.isChatOpen
          ? this.newMessagesCount
          : this.newMessagesCount + 1;
        this.onMessageWasSent({
          author: "user1",
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

    // all methods dealing with bot logic
    //botProcess is the main method of the bot if handles user input
    //then runs through if else statments to send a reponse
    botProcess(string){
      if(string === 'Yes'){
        this.reset();
      }else if(string === 'No'){
        this.closeChat();
        this.reset();
      }else if(this.checkedCategories === false){
        this.searchCategories(string);
      }else if(this.pickedJobSearch === true){
        this.searchJobs(string);
      }else if(this.checkedWorkflows === false && this.foundAnswer === false){
        this.searchWorkflows(string);
      }else if(this.checkedSubworkflows === false && this.foundAnswer === false){
        this.searchSubworkflows(string);
      }
    },
    // Resets all the checks to false so the logic can be ran through again
    reset(){
      this.messageList = [{ type: "text", author: `user1`, data: { text: `Welcome ${this.user.firstName} To Chat Bot`}, suggestions:['Pathway', 'Curriculum', 'Job Search'] }]
      this.checkedCategories = false;
      this.checkedWorkflows = false;
      this.checkedSubworkflows = false;
      this.openWindow = false;
    },
    //Takes in an array and string then searchs the array for the string
    // the intent is to take the user's selection then perform a search of the database
    // to match the input with a field name.
    setUserChoiceIdFromUserInput(array = [], string){
      const userInput = string;
                array.forEach(element => {
                    if(element.name === userInput){
                        this.userChoiceId = element.id;
                        this.foundAnswer = true;
                    }

                })
      },
      //Intent is to perform a search using setUserIdFromUserInput 
      // then it says it checked the categories from the api call
      // then trigger custom event using $emit to pass the id to parent for api call
      // then $watch watches for the parent api call to set this.workflows
      // then if setUserChoiceIdFromUserInput found a match (foundAnswer = true)
      //  it sets the botText to send back to the user using the data from the saved array
      // then if the user picked Job Search (userId === 3) it sets the suggestions from the
      // logged in users selected JobTitles using setJobSuggestion else it uses 
      // setBotResponseSuggestions using the workflows array that triggered this watch
      searchCategories(string){
          this.setUserChoiceIdFromUserInput(this.categories, string);
          this.checkedCategories = true;
          this.$emit("get-workflows", this.userChoiceId);
          this.$watch(function(){return this.workflows},
            function(){
              if(this.foundAnswer === true){
                const botText = this.setBotResponseText(this.categories, string);
                let botSuggestions = [];
                if(this.userChoiceId === 3){
                  botSuggestions = this.setJobSuggestion(this.user.jobSelections)
                  this.pickedJobSearch = true;
                  this.userChoiceId = 0;
                }
                else{
                  botSuggestions = this.setBotResponseSuggestions(this.workflows)
                }
                this.sendMessage(botText, botSuggestions);
                this.foundAnswer = false;
              }
            });
      },
      //Same as above but does not have to look for Job Search
      searchWorkflows(string){
          this.setUserChoiceIdFromUserInput(this.workflows, string);
          this.checkedWorkflows = true;
          this.$emit("get-subworkflows", this.userChoiceId);
          this.$watch(function(){return this.subworkflows},
          function(){
            if(this.foundAnswer === true){
              const botText = this.setBotResponseText(this.workflows, string);
              const botSuggestions = this.setBotResponseSuggestions(this.subworkflows);
              this.sendMessage(botText, botSuggestions);
              this.foundAnswer = false;
            }
            });
      },
      //As this is the end we use setBotAnswer for the botText and I have hardcoded Yes or No for Now
      searchSubworkflows(string){
          this.setUserChoiceIdFromUserInput(this.subworkflows, string);
          this.checkedSubworkflows = true;
          if(this.foundAnswer === true){
            const botAnswer = this.setBotAnswer(string);
            this.sendMessage(botAnswer, ['Yes', 'No']);
            this.foundAnswer = false;
          }
      },
      //This searchs like the ones above but it searchs through the user information to
      // get the id to send in the custom event get-jobs to the parent it then
      // waits for the parent to return the data by using $watch before it opens a new
      // window with job postings from the api call
      searchJobs(string){
        let id = 0;
        this.user.jobSelections.forEach(element => {
          if(string === element.name){
            id = element.id;
          }
        })
        this.$emit('get-jobs', id);
        this.$watch(function(){return this.jobSearchArray}, 
        function(){
          if(this.pickedJobSearch === true){
          this.sendMessage('Do It Again', ['Yes', 'No'])
          this.pickedJobSearch = false;
          this.jobArray = this.jobSearchArray;
          this.openWindow = true;}
        })
      },
      setBotAnswer(string){
        let answer = 'Bob';
        this.subworkflows.forEach(element =>{
          if(element.name === string){
            answer =  element.textAnswer;
          }
        })
        return answer;
      },
      setBotResponseText(array = [], string){
          let text = '';
          array.forEach(element =>{
            if(element.name === string){
              text = element.presentationText;
            }
            else if(element.categoryId === this.userChoiceId){
                return element.presentationText; 
            }else if(element.workflowId === this.userChoiceId){
                return element.presentationText;
            }else if(element.subworkflowId === this.userChoiceId){
                return element.presentationText;
            }
          })
          return text;
      },
      setBotResponseSuggestions(array = []){
          let suggestionsArray = []
          array.forEach(element => {
                  suggestionsArray.push(element.name);
          })
          return suggestionsArray;
      }, 
      setJobSuggestion(array = []){
          let suggestionsArray = []
          array.forEach(element => {
                  suggestionsArray.push(element.name);
          })
          return suggestionsArray;
      },  

  },
  computed: {
// this just tiggers the watch when there is input to the chat.
    botResponse(){
      return this.messageList;
    }
  },
  watch: {
    //checks to see if last entry to chat was the user (me is the name beautiful chat gives to input.)
    botResponse(){
      const lastMessage = this.messageList[this.messageList.length - 1];
      if(lastMessage.author === 'me'){
       this.botProcess(lastMessage.data.text);
      }
    }
  }
};
</script>

<style>
.sc-user-input{
  visibility: hidden;
}
sc-chat-window opened{
  background-color: rgb(160, 142, 38);
}

 button.sc-suggestions-element {
  color:black;
  margin: 3px;
  padding: 5px 10px 5px 10px;
  border: 2px solid;
  border-radius: 15px;
  font-size: 14px;
  background-color: rgb(115, 132, 187);
  cursor: pointer;
  border-color:  rgb(160, 142, 38);
}

.sc-suggestions-row {
  text-align: center;
  background: inherit;
} 
.hide{
  visibility: hidden;
}


</style>