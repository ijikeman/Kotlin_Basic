import { createRouter, createWebHistory } from 'vue-router'
import Owner from './Owner.vue'
import Home from './Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/owner',
    name: 'Owner',
    component: Owner
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
