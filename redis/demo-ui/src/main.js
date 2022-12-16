import Vue from 'vue'
import App from './App.vue'
import { createApp } from 'vue';

import store from './store'
import router from './router'

const app = createApp(App)
app.mount('#app')
app.use("router")