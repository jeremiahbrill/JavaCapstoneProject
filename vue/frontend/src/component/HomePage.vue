<template>
  <div class="flex_container">
    <div class="row">
      <div class="left_container">
        <img class="img" src="../assets/images/student-on-computer.jpg"/>
      </div>
      <div class="side_container">
        <p class="marketing_text">
          <b>The Wisdom of Athena</b> in the modern age.
          Knowledge is a simple click away with 
          a growing list of features. Let us 
          give your students the answers they
          need day or night. As <b>The Owl Athena</b>  
          is always available.
        
      <router-link :to="{ name: 'register' }">
        <h3 class="get_started">Get Started</h3>
      </router-link>
      </p>   
      </div>
      <div class="video_container"> 
        <h2 class="video_lable">Owl of Athena chatbot gives you the edge...</h2>
        <div class="demo_video">
          <video width="auto" height="75%" autoplay muted controls loop>
            <source src="../assets/video/Owl of Athena Demo.mp4" type="video/mp4">
            Your browser does not support the video tag.
          </video>
        </div>
      </div>
      <div class="footer">
        <p>This is the Footer Text add the social icons Here</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  
};
</script>



