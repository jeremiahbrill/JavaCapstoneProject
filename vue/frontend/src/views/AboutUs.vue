<template>
   <div class="aboutUs">
     <div class="aboutUsFlex">
     <div class="aboutItem">
       <h4>Steve Carmichael</h4>     
      <img class="img" src="../assets/images/steve.png"/>  
       <p>A product of the superhero revival that sparked the Silver Age and birthed a new generation of characters, Steve Carmichael is, perhaps, one of the most innovative updates to an older character that took place during that time.  
       </p>      
    </div>

     <div class="aboutItem">
       <h4>Andrew Frank</h4>     
       <img class="img" src="../assets/images/andrew.png"/>   
       <p>Andrew Frank may be the ultimate example of human ingenuity. Gifted with great intellect and a daring spirit, Andrew was a billionaire playboy who had it all, using his wealth - garnered from producing innovative weaponry - in pursuit of his own selfish whims.
        After being taken prisoner by enemy combatants in the Vietnam War (or the Gulf war, in later versions), Andrew was forced to use his skills as an engineer and arms designer to build a weapon of mass destruction.    
       </p>      
    </div> 

    <div class="aboutItem">
       <h4>Jeremiah Brill</h4>     
      <img class="img" src="../assets/images/captainAmerica.jpeg"/>  
       <p>
        Jeremiah finally found a home in Project: Rebirth, and experimental program meant to turn his weak body into the perfect human, a soldier who operated a peak efficiency and possessed incredible strength. The project was a success, but Nazi saboteurs ensured that the formula that turned Rogers into a super soldier would die with the inventor of the process.        
       </p>    
    </div>  

    <div class="aboutItem">
       <h4>Mirlene Radcliffe</h4>     
       <img class="img" src="../assets/images/nubia.jpg"/>  
       <p> 
         Mirlene was stolen at birth by Mars, God of War, and trained as a master of combat. Her introduction to comic readers was during a battle where she challenged Wonder Woman and won. She is the ultimate superhuman, possessing enhanced super strength, intelligence and healing. She can glide on air, time travel and break steel and concrete with her bare hands.
       </p>  
    </div>  

    <div class="aboutItem">
      <h4>Venkata Kondaveeti</h4>     
      <img class="img" src="../assets/images/wonder.jpg"/>  
       <p> 
         Wonder Woman tells the tale of Princess Diana of Themyscira. Her original origin story says she was formed out of clay by her mother, Hippolyta, and had life bestowed upon her by the Greek gods  
        </p>    
    </div>    
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
.aboutUs{
  width: 80%;
  margin:0 auto;
  background: #c29f80;
}
.aboutUsFlex{
  display: flex;
  flex-direction: column;
  width: 80%;
  margin: 0 auto;
}
.aboutItem{
  width: 100%;
  margin: 1rem;
  background: #F4f4f4;
  border-radius: 1rem;
}
.aboutItem h4{
  background: #763240;
  padding: .5rem;
  color: whitesmoke;
  border-radius: .5rem;
  text-align: center;
  width: 50%;
  margin: 1rem 13rem;
}
.aboutItem img{
  width: 20%;
  float: left;
  height: auto;
  margin: 1rem 1rem;
  shape-outside: border-box;
  border-radius: 5rem;
}
.aboutItem p{
  background: #F4f4f4;
  margin-left: 11rem;
  height: 10rem;
  border-radius: 1rem;
  padding: 3rem;
}
</style>