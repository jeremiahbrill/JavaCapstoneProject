<template>
  <div>
    <h2 v-bind:value="JobResults.name">Here are the current positions for Software Engineer</h2>
    {{jobResults}}
    {{jobPositionResults}}

  </div>
</template>


<script>
export default {
  name: 'job-search',
  props: {
    name: String,
    description: String,
    city:  String,
    state: String,
    jobUrl: String
  },
  data() {
    return {
      API_URL: "http://localhost:8080/ChatBot/api",
      jobResults: [],
      jobPositionResults: []
    };
  },
    methods: {
      getJobs() {
        fetch("${this.API_URL}/jobSearch}")
          .then(response => response.json())
          .then(list => (this.jobResults = list))
          //.then(list => (console.log(list)))
          .catch(err => console.error(err));
          console.log("Testing jobResults" + this.jobResults);
      },

      getJobPositions() {
        fetch("${this.API_URL}/jobPositionSearch}")
          .then(response => response.json())
          .then(list => (this.jobPositionResults = list))
          .catch(err => console.error(err));
      }
    },
      created(){
       console.log("You're inside created");
       this.getJobs();
       console.log("You're after getJobs");
       this.getJobPositions();
       console.log("You're leaving created");
      }
  }
</script>


<style>


</style>