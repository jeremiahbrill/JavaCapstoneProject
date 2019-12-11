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
                botResponses: []
            };
        },
        methods: {
        
            getResponses(array = []){
                return array.filter(obj =>{
                    return obj.name == this.userInput;
                })
            },
            botProcess(){
                if(this.categories.includes(this.userInput) === true){
                    const botTalk = this.getResponses(this.workflows); 
                    this.$emit("bot-responses", botTalk)
                   return this.botResponses = botTalk;
                }
                return console.log('Error in Chatbot process.')
            },

        },
        compute: {
            getBotResponses() {
                return this.chatLog;
            }
        },
        watch: {
            getBotResponses(){
                console.log('Bot Response Changed');
                 this.botProcess();
                
            }
        }
    }
</script>

<style scoped>
/* .chatBot{
visibility: hidden;
} */
</style>