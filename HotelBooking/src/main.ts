import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { IonicVue } from '@ionic/vue'

import App from './App.vue'
import router from './router'

const app = createApp(App).use(IonicVue).use(router);

app.use(createPinia())
app.use(router)

router.isReady().then(() => {
    app.mount('#app')
});


