<template>
  <div class="jobsWindow" v-if="open">
    <slot />
    <div class="jobs" v-for="job in jobSearchDisplay" :key="job.id" 
      style="
      color: black;
      text-align: center;
      background-color: rgb(201, 202, 206);
      margin: 4%;
      padding: 2%;
      border: solid;
      border-color: rgb(160, 142, 38);
      border-radius: 2%;
    "> 
      <h2 class="jobName"
      style="
      border: solid;
      border-color:  rgb(115, 132, 187);
      background-color:  rgb(115, 132, 187);
      border-radius: 5px;
      padding: 1%;
      ">{{job.name}}</h2>
      <p class="jobDescription">{{job.jobDescription}}</p>
      <a class="jobUrl" :href="job.jobUrl" target="_blank">
        {{job.jobUrl}}
      </a>
    </div>
  </div>
</template>

<script>
export default {
  name: 'window-portal',
  model: {
  prop: 'open',
  event: 'close'
  },
  props: {
    jobSearchDisplay: Array,
    open: {
      type: Boolean,
      default: false,
    }
  },
  data() {
    return {
      windowRef: null
    }
  },
  watch: {
    open(newOpen) {
      if(newOpen) {
        this.openPortal();
      } else {
        this.closePortal();
      }
    }
  },
  methods: {
    openPortal() {
      this.windowRef = window.open("", "Job Results", "width=600,height=400,left=200,top=200");
      // this.windowRef.addEventListener('beforeunload', this.closePortal());
      // magic!
        this.windowRef.document.body.appendChild(this.$el);
    },
    closePortal() {
      if(this.windowRef) {
        this.windowRef.close();
        this.windowRef = null;
        this.$emit('close');
      }
    }
  },
  mounted() {
    if(this.open) {
      this.openPortal();
    }
  },
  beforeDestroy() {
    if (this.windowRef) {
      this.closePortal();
    }
  }
}
</script>

<style>

</style>
