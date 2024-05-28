import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Welcomepage from '../views/WelcomePage.vue'
import AboutPage from '../views/AboutPage.vue'
import ImprintPage from '../views/ImprintPage.vue'
import RoomOverviewPage from '../views/RoomOverviewPage.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/welcome'
  },
  {
    path: '/welcome',
    name: 'Welcome',
    component: Welcomepage
  },
  {
    path: '/about',
    name: 'About',
    component: AboutPage
  },
  {
    path: '/imprint',
    name: 'Imprint',
    component: ImprintPage
  },
  {
    path: '/room-overview',
    name: 'RoomOverview',
    component: RoomOverviewPage
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
