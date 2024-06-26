import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Welcomepage from '../views/Components/WelcomePage.vue'
import AboutPage from '../views/Components/AboutPage.vue'
import ImprintPage from '../views/Components/ImprintPage.vue'
import RoomOverviewPage from '../views/Components/RoomOverviewPage.vue'
import RoomAvailabilityCheckPage from '../views/Components/RoomAvailabilityCheckPage.vue'
import BookingReservationPage from '../views/Components/BookingReservationPage.vue'
import BookingReservationCheckPage from '../views/Components/BookingReservationCheckPage.vue'
import BookingReservationConfirmationPage from '../views/Components/BookingReservationConfirmationPage.vue'

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
  },
  {
    path: '/room-availability-check/',
    name: 'RoomAvailabilityCheck',
    component: RoomAvailabilityCheckPage
  },
  {
    path: '/booking-reservation/',
    name: 'BookingReservation',
    component: BookingReservationPage
  },
  {
    path: '/booking-reservation-check/',
    name: 'BookingReservationCheck',
    component: BookingReservationCheckPage
  },
  {
    path: '/booking-reservation-confirmation/',
    name: 'BookingReservationConfirmation',
    component: BookingReservationConfirmationPage
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
