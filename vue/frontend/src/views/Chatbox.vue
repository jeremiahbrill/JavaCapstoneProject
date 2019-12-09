<template>
    <div class="chatbox">
        <div class="chatwindow">
        <p class="owlBot"> OwlBot: Hi how are you today. </p>
        <p class="user"> I need help with X </p>
        </div>
        <input
        type="text"
        id="userInput"
        class="form-control"
        placeholder=""
        autofocus/>
        <button> Enter </button>
  </div>
</template>

<script>
export default {
  name: 'chatbox'
}
</script>

<style>
div.chatbox{
    display: block;
    height:100%;
    background: white;
    border: 1px solid black;
    margin: 5%;
    padding: 2%;
}
div.chatwindow {
    height:90%;
    background: gray;
    border: 1px solid black;
    padding: 2%;
}
div.chatwindow  p.user {
    text-align: right;
}
</style>
