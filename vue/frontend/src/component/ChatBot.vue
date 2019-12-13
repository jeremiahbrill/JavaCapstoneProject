<template>
    <div class="chatBot">
        {{categories}}
        {{workflows}}
        {{subworkflows}}
        {{userInput}}
        {{answers}}
    </div>
</template>
// I am unable to get the responses back to the parent and I am not sure why.
<script>
    export default {
        name: "chat-bot",
        props:{
            categories:Array,
            workflows:Array,
            subworkflows:Array,
            answers:Array,
            chatLog:Array,
            userInput: String
        },
        data() {
            return {
                botResponseSuggestions: [],
                botResponseText: "",
                userChoiceId: 0,
                userLastChoiceID: 0,
                searchArray: [],
                foundAnswer: false,
                checkedCategories: false,
                checkedWorkflows: false,
                checkedSubWorkflows: false,
                foundSubWorkflowsAnswer: ""
            };
        },
        methods: {
            setUserChoiceIdFromUserInput(){
                this.searchArray.forEach(element => {
                    if(element.name === this.userInput){
                        this.userChoiceId = element.id;
                        this.foundAnswer = true;

                    }

                })
            },

            setBotResponseSuggestions(){
                this.searchArray.forEach(element => {
                        this.botResponseSuggestions.push(element.name);
                })
            }, 
            setBotResponesAnswer(){
                this.searchArray.forEach(element => {
                    console.log('element Id '+element.subworkflowId)
                    if(element.subworkflowId === 1){
                        this.botResponseText = element.textAnswer;
                        console.log(this.botResponseText)
                        console.log(element.textAnswer)
                    }
                })               
            },

            setBotResponseText(){
                this.botResponseText = "I can help with";
                // this.searchArray.forEach(element =>{
                //     if(element.name === this.userInput){
                //         this.botResponseText = element.presentationText; 
                //     }
                // })
            },

            setBotOutput(){
                this.setBotResponseText();
                this.setBotResponseSuggestions();
            },

            botProcess(){

                // console.log("Search Array"+this.searchArray[0].name);
                this.$emit("bot-response-text", this.botResponseText);    
                this.$emit("bot-response-suggestions", this.botResponseSuggestions);
                this.foundAnswer = false;      
            },
            resetLogic(){
                this.foundAnswer = false;
                this.botResponseSuggestions = [];
                this.botResponseText = "";
                this.searchArray = this.categories;
                this.userLastChoiceID = this.userChoiceId;
            },

            searchCategories(){
                this.searchArray = this.categories;
                this.setUserChoiceIdFromUserInput();
                this.checkedCategories = true;
                this.$emit("get-workflows", this.userChoiceId);
            },

            searchWorkflows(){
                this.setUserChoiceIdFromUserInput();
                this.checkedWorkflows = true;
                this.$emit("get-subworkflows", this.userChoiceId)

            },

            searchSubWorkflows(){
                this.setUserChoiceIdFromUserInput();
                this.checkedSubWorkflows = true;
                this.$emit("get-answers", this.answers)
                // this.checkedSubWorkflows = false;
            },
              getAnswer(){
                this.searchArray = this.answers;
                this.setBotResponesAnswer();
                this.searchArray = [];
                console.log("botProcess start");
                this.botProcess();
                console.log("botProcess end")
                this.foundSubWorkflowsAnswer = "anything";
                this.$emit("get-subworkflowAnswer", this.foundSubWorkflowsAnswer);
                this.resetLogic();
            },
      
        },
        computed: {
            watchAnswerFound(){
              return this.foundAnswer;
            },
            watchUserInput() {
                return this.userInput;
            },
            watchChatLog() {
                return this.chatLog;
            },
            watchWorkflows(){
                return this.workflows;
            },
            watchSubWorkflows(){
                return this.subworkflows;
            },
            watchAnswers(){
                return this.answers;
            },
            watchCheckedCategories(){
                return this.checkedCategories;
            },
        },
        watch: {
            watchChatLog(){
  
            },
            watchUserInput(){

                if(this.checkedCategories === false){
                    this.searchCategories(); 
                    this.searchArray = [];
                    }
                else if(this.checkedCategories === true && this.checkedWorkflows === false ){
                    this.searchWorkflows();
                    this.searchArray = [];
                }
                else if(this.checkedWorkflows === true && this.checkedSubWorkflows === false){
                    this.searchSubWorkflows();
                    this.searchArray = [];
                }
                // if(this.checkedSubWorkflows === true){
        
                // }
            },
            watchAnswerFound(){

            },
            watchWorkflows(){
                // if(this.foundAnswer === false && this.checkedWorkflows === false){
                // this.searchWorkflows();
                // }
                this.searchArray = this.workflows;
                this.setBotOutput();
                this.botProcess();
                this.botResponseSuggestions = [];
            },
            watchSubWorkflows(){
                this.searchArray = this.subworkflows;
                this.setBotOutput();
                this.botProcess();
                this.botResponseSuggestions = [];
            },
            watchAnswers(){
                console.log("Last step to Answer")
                this.searchArray = this.answers;
                this.getAnswer();
            },
        }
    }
</script>

<style scoped>
 .chatBot{
visibility: hidden;
} 
</style>