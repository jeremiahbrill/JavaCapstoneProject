<template>
    <div class="chatBot">
        {{categories}}
        {{workflows}}
        {{subworkflows}}
        {{userInput}}
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
            };
        },
        methods: {
            setUserChoiceIdFromUserInput(){
                this.searchArray.forEach(element => {
                    if(element.name === this.userInput){
                        console.log("elementId"+element.id)
                        this.userChoiceId = element.id;
                        this.foundAnswer = true;
                        console.log("Should be setting choice"+this.userChoiceId);
                    }
                    console.log('Did not find input in database');
                })
            },

            setBotResponseSuggestions(){
                this.searchArray.forEach(element => {
                        this.botResponseSuggestions.push(element.name);
                })
            }, 

            setBotResponseText(){
                this.botResponseText = "Testing Responses";
                // this.searchArray.forEach(element =>{
                //     if(element.name === this.userInput){
                //         this.botResponseText = element.response; 
                //     }
                // })
            },

            botProcess(){
                console.log(this.userChoiceId);
                console.log("Search Array"+this.searchArray[0].name);
                this.setBotResponseText();
                this.setBotResponseSuggestions();
                this.$emit("bot-response-text", this.botResponseText);    
                this.$emit("bot-response-suggestions", this.botResponseSuggestions);
                this.resetLogic();
                        
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
                if(this.foundAnswer === false){
                    console.log("Answer not found")
                }
                this.checkedCategories = false;
                this.checkedWorkflows = false;
                this.checkedSubWorkflows = false;
            }
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
            watchCheckedCategories(){
                return this.checkedCategories;
            }
        },
        watch: {
            watchChatLog(){
                console.log('Chatlog updated in Chatbot');
            },
            watchUserInput(){
                console.log('Userinput changed in chatbot')
                this.searchCategories();
            },
            watchAnswerFound(){
                console.log('Answer Found')
            },
            watchWorkflows(){
                if(this.foundAnswer === false && this.checkedWorkflows === false){
                this.searchWorkflows();
                }
                this.searchArray = this.workflows;
                this.botProcess();
            },
            watchSubWorkflows(){
                console.log("Got to sub workflow watcher")
                 if(this.foundAnswer === false && this.checkedSubWorkflows === false){
                this.searchSubWorkflows();
                }
                this.searchArray = this.subworkflows;
                this.botProcess();               
            },
        }
    }
</script>

<style scoped>
/* .chatBot{
visibility: hidden;
} */
</style>