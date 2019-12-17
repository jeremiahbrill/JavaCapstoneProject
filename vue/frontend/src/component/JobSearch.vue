<template>
  <div v-if="open">
    <slot />
    <div class="jobs" v-for="job in jobSearchDisplay" :key="job.id" style="color:blue;text-align:center;background-color:tan;"> 
      <h2 class="jobName">{{job.name}}</h2>
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
      this.windowRef = window.open("", "", "width=600,height=400,left=200,top=200");
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

<style scoped>

</style>
