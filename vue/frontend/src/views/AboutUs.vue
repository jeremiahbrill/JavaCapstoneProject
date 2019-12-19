<template>
   <div>
    <div v-for="about in aboutUs" 
         v-bind:key="about.id" >
     <img class="img" :src="about.image"/>
     <span> {{about.description}}
     </span>    
    </div> 
   </div>  
</template>

<script>
export default {
 name: 'AboutUs',
  data(){
   return {
     aboutUs:[
         {
           id: 1,  
           image: "../assets/images/athena-logo-new-just-owl.png",
           description: "In Greek mythology, a little owl (Athene noctua) traditionally represents or accompanies Athena, the virgin goddess of wisdom, or Minerva, her syncretic incarnation in Roman mythology.[1] Because of such association, the bird — often referred to as the \"owl of Athena\" or the \"owl of Minerva\" — has been used as a symbol of knowledge, wisdom, perspicacity and erudition throughout the Western world."
         },
         {
           id: 2,  
           image: "../assets/images/avatar2.jpg",
           description: "Far from the only arrogant rich guy made good on this list, Green Arrow still has the unique distinction of being one of the first characters to have a truly compelling \"riches to rags\" style origin. Taking inspiration from characters like Robinson Crusoe and Robin Hood, Oliver Queen was a young playboy who was marooned on a desert isle after a shipwreck sent him overboard. At first struggling to survive without the luxuries of his rich life, Queen eventually learned to rely on the archery and survival training he had received as a child."
         }
     ]
   }
  }   
}
</script>

<style>

</style>