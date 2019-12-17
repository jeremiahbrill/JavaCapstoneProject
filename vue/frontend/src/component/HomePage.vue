<template>
<body>
  <div class="flex_container">
    <div class="row">
      <div class="homePage" id="left_container">
        <img src="../assets/images/student-on-computer.jpg"/>
      </div>
      <div class="homePage" id="right_container">
        <div class="pageText">
          <p class="edge"><h1 id="title_phrase">Owl of Athena gives you the edge...</h1>
            <div>

            </div>
            <div>

            </div>
            <div>

            </div>
            <div id="final_text">
                <h4 class="achieve">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Achieve your dreams...</h4>
                <h4 class="elevate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Elevate Your World...</h4>
                <p><h4 class="AOE">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Owl of Athena (AOE)</h4></p>
                <router-link :to="{ name: 'register' }">
                <p><button class="btn"><h3 id="sign_up_or_login">&nbsp;&nbsp;Get Started</h3></button></p></router-link>
            </div>
        </div>
      </div>
      </div>
    </div>
</body>
</template>

<script>
export default {
  
};
</script>



