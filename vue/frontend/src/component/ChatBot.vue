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
                // foundSubWorkflowsAnswer: false
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
            setBotResponesAnswer(){
                this.searchArray.forEach(element => {
                    if(element.id === this.userLastChoiceID){
                        this.botResponseText = element.textAnswer;
                    }
                    console.log("Did not set answers for subworkflows")
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

            setBotOutput(){
                this.setBotResponseText();
                this.setBotResponseSuggestions();
            },

            botProcess(){
                console.log(this.userChoiceId);
                console.log("Search Array"+this.searchArray[0].name);
                this.$emit("bot-response-text", this.botResponseText);    
                this.$emit("bot-response-suggestions", this.botResponseSuggestions);
                
                        
            },
            resetLogic(){
                this.foundAnswer = false;
                this.botResponseSuggestions = [];
                this.botResponseText = "";
                this.searchArray = this.categories;
                this.userLastChoiceID = this.userChoiceId;
                this.foundSubWorkflowsAnswer = false;
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
                // this.foundSubWorkflowsAnswer = true;

                // this.checkedSubWorkflows = false;
            }
        },
        getAnswer(){
             this.setBotResponesAnswer();
             this.searchArray = [];
             this.botProcess();
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
            // watchfoundSubWorkFlowsAnswer(){
            //     return this.foundSubWorkflowsAnswer;
            // }
        },
        watch: {
            watchChatLog(){
                console.log('Chatlog updated in Chatbot');
            },
            watchUserInput(){
                console.log('Userinput changed in chatbot')
                if(this.checkedCategories === false){
                    this.searchCategories(); 
                    this.searchArray = [];
                    // this.botProcess();
                    }
                if(this.checkedCategories === true && this.checkedWorkflows === false){
                    this.searchWorkflows();
                    this.searchArray = [];
                }
                if(this.checkedWorkflows === true && this.checkedSubWorkflows === false){
                    this.searchSubWorkflows();
                    this.searchArray = [];
                }
            },
            watchAnswerFound(){
                console.log('Answer Found')
            },
            watchWorkflows(){
                // if(this.foundAnswer === false && this.checkedWorkflows === false){
                // this.searchWorkflows();
                // }
                this.searchArray = this.workflows;
                this.setBotOutput();
                this.botProcess();
            },
            watchSubWorkflows(){
                console.log("Got to sub workflow watcher")
                //  if(this.foundAnswer === false && this.checkedSubWorkflows === false){
                // this.searchSubWorkflows();
                // this.setBotOutput();
                // }
                this.searchArray = this.subworkflows;
                // this.foundSubWorkflowsAnswer = true;
                this.setBotResponesAnswer()
                this.botProcess();  

                // if(this.foundAnswer === true & this.checkedSubWorkflows === true){
                //     this.foundSubWorkflowsAnswer = true;  
                // }
                          
            },
            // watchfoundSubWorkFlowsAnswer(){
            //     this.botProcess();
            //     // if(this.foundSubWorkflowsAnswer === true){
            //     // console.log("found sub search array"+this.searchArray)
            //     // this.searchArray = this.subworkflows;
            //     // this.setBotResponesAnswer();
            //     // this.searchArray = [];  
            //     // this.botProcess();   
            //     // }
            // },
        }
    }
</script>

<style scoped>
/* .chatBot{
visibility: hidden;
} */
</style>