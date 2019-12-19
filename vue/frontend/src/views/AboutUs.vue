<template>
   <div>
    <!-- <div v-for="about in aboutUs" 
         v-bind:key="about.id" >
     <img class="img" :src="about.image"/>
     <span> {{about.description}}
     </span>    
    </div>  -->

     <div>
       <h4>Steve Carmichael</h4>     
      <img class="img" src="../assets/images/greenLantern.jpeg"/>  
       <span>A product of the superhero revival that sparked the Silver Age and birthed a new generation of characters, Steve Carmichael is, perhaps, one of the most innovative updates to an older character that took place during that time.  
       </span>      
    </div>

     <div>
       <h4>Andrew Frank</h4>     
       <img class="img" src="../assets/images/ironMan.jpeg"/>  
       <span>Andrew Frank may be the ultimate example of human ingenuity. Gifted with great intellect and a daring spirit, Andrew was a billionaire playboy who had it all, using his wealth - garnered from producing innovative weaponry - in pursuit of his own selfish whims.
        After being taken prisoner by enemy combatants in the Vietnam War (or the Gulf war, in later versions), Andrew was forced to use his skills as an engineer and arms designer to build a weapon of mass destruction.    
       </span>      
    </div> 

    <div>
       <h4>Jeremiah Brill</h4>     
      <img class="img" src="../assets/images/captainAmerica.jpeg"/>  
       <span>
        Jeremiah finally found a home in Project: Rebirth, and experimental program meant to turn his weak body into the perfect human, a soldier who operated a peak efficiency and possessed incredible strength. The project was a success, but Nazi saboteurs ensured that the formula that turned Rogers into a super soldier would die with the inventor of the process.        
       </span>    
    </div>  

    <div>
       <h4>Mirlene Radcliffe</h4>     
       <img class="img" src="../assets/images/nubia.jpg"/>  
       <span> 
         Mirlene was stolen at birth by Mars, God of War, and trained as a master of combat. Her introduction to comic readers was during a battle where she challenged Wonder Woman and won. She is the ultimate superhuman, possessing enhanced super strength, intelligence and healing. She can glide on air, time travel and break steel and concrete with her bare hands.
       </span>  
    </div>  

    <div>
      <h4>Venkata Kondaveeti</h4>     
      <img class="img" src="../assets/images/wonder.jpg"/>  
       <span> 
         Wonder Woman tells the tale of Princess Diana of Themyscira. Her original origin story says she was formed out of clay by her mother, Hippolyta, and had life bestowed upon her by the Greek gods  
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