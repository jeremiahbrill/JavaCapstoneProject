<template>
  <div class="flex_container">
    <div class="row">
      <div class="homePage" id="left_container">
        <img class="img" src="../assets/images/student-on-computer.jpg"/>
      </div>
      <div class="side_container">
      <p><h4 class="achieve">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Level Up...</h4></p>
      <p><h4 class="elevate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Achieve your dreams...</h4></p>
      <p><h4 class="Do_More">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go further and do more...</h4></p>
      </div>
      <div class="homePage" id="right_container">
        <div class="pageText">
            <div id="final_text">
                <p class="edge"><h2 id="title_phrase">Owl of Athena chatbot gives you the edge...</h2>
                <router-link :to="{ name: 'register' }">
                <p><button class="btn"><h3 id="sign_up_or_login">&nbsp;&nbsp;Get Started</h3></button></p></router-link>
            </div>
        </div>
      </div>
      </div>
    </div>
</template>

<script>
export default {
  
};
</script>



