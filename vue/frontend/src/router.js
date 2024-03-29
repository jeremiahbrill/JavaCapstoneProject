import Vue from 'vue'
import Router from 'vue-router'
import auth from './auth'
//import Home from './views/Home.vue'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
// added by JJ
import Chatbox from './views/Chatbox.vue'
import Chat from 'vue-beautiful-chat'
import AboutUs from './views/AboutUs.vue'

// added by MSR

import HomePage from './component/HomePage.vue'
import JobSearch from './component/JobSearch.vue'

Vue.use(Chat)

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'defaultpage',
      component: HomePage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/homepage",
      name: "homepage",
      component: HomePage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/chatbox",
      name: "chatbox",
      component: Chatbox,
      props: true,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/jobsearch",
      name: "jobsearch",
      component: JobSearch,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/aboutus",
      name: "aboutus",
      component: AboutUs,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const user = auth.getUser();

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && !user) {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
