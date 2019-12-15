<template>
  <div  >
    <h2>Here are the current entries in the job search db</h2>

    {{jobResults}}
    {{jobPositionResults}}
    {{jobResultsByPositionId}}

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
      jobPositionResults: [],
      jobResultsByPositionId: [],
    };
  },
    methods: {

      getAllJobs() {
        fetch(`${this.API_URL}/jobSearch`)
          .then(response => response.json())
          .then(list => this.jobResults = list)
          .catch(err => console.error(err));
      },

      getJobsByJobPositionId(){
        fetch(`${this.API_URL}/jobSearch/1`)
          .then(response => response.json())
          .then(list => this.jobResultsByPositionId = list)
          .catch(err => console.error(err));

        console.log("Testing jobResults" + this.jobResults);

      },

      getJobPositions() {
        fetch(`${this.API_URL}/jobPositionSearch`)
          .then(response => response.json())
          .then(list => (this.jobPositionResults = list))
          .catch(err => console.error(err));
      }
    },
      created(){
       this.getAllJobs();
       this.getJobPositions();
       this.getJobsByJobPositionId()
      }
  }
</script>


<style>


</style>