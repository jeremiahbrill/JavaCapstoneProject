<template>
  <div class="flex_container">
    <div class="row">
      <div class="homePage" id="left_container">
        <img class="img" src="../assets/images/student-on-computer.jpg"/>
      </div>
      <div class="side_container">
      <p><h4 class="achieve">Level Up...</h4>
      <p><h4 class="elevate">Achieve your dreams...</h4>
      <p><h4 class="Do_More">Go further and do more...</h4>
      <div>
        <button class="btn"><h2 id="sign_up_or_login">&nbsp;&nbsp;Get Started</h2></button>
      </div>
      </div>
      <div class="homePage" id="right_container">
        <div class="pageText">
            <div id="final_text">
                <p class="edge"><h2 id="title_phrase">Owl of Athena chat bot gives you the edge...</h2>
                <router-link :to="{ name: 'register' }"></router-link>
            </div>
            <div class="demo_video" style="position: relative; padding-bottom: 106.82492581602374%; 
            height: 0;"><iframe src="https://www.loom.com/embed/33787508707a4d03b5ebcf33677c2242" 
            frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen 
            style="position: absolute; top: 0; left: 0; width: 90%; height: 60%;"></iframe></div>
              </div>
            </div>
        </div>
      </div>
</template>

<script>
export default {
  
};
</script>



