<template>
<body>
  <div class="flex_container">
    <div class="row">
      <div class="homePage" id="left_container">
        <video src="../assets/video/video-aerial-flight-around-mountain-peak.mp4" 
        class="mp4" controls="controls" autoplay="autoplay" loop="loop"></video>
      </div>
      <div class="homePage" id="right_container">
        <div class="pageText">
          <p class="edge"><h2 id="title_phrase">Give yourself the edge...</h2>
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



