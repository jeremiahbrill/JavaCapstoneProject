<template>
    <div class="chatBot">
        {{categories}}
        {{workflows}}
        {{subworkflows}}
        {{userInput}}
        {{chatLog}}
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
            getCategories(){
                this.categories.forEach(element => {
                        this.botResponses.push(element);
                })
            }, 
            getResponses(array = []){
                return array.filter(obj =>{
                    return obj.name == this.userInput;
                })
            },
            botProcess(){
                const input = this.userInput;
                this.categories.forEach(element => {
                    if(element.name === input){
                        this.botResponses.push(element);
                    } 
                })
                this.$emit("bot-responses", this.botResponses);              
            }
        },
        computed: {
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