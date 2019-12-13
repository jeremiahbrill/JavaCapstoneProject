<template>
  <div>
    <h2>Here are the current positions for {{jobtitle}}</h2>

    <p class="job-title" id="job-title">{{jobtitle}}</p>

    <p class="job-description" id="job-description">{{jobDescription}}</p>
    <p><a href="{{jobUrl}}"/>More...</p>
  </div>
</template>


<script>
export default {
    name: 'job-search',
    props: {
        title:  String,
        description: String,
        url: url
    },
    data(){
        return{
            jobSearchResults:  []
        }
    }, 
    methods: {
 
    }
}
</script>


<style>

</style>