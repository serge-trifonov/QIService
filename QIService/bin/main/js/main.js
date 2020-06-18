import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import 'bootstrap'
import 'assets/app.scss'
import router from 'router/router'
import '@babel/polyfill'
import store from 'vuex/store'
import {i18n} from 'i18n/i18n'
Vue.use(VueResource)

new Vue({
    el: '#app',
    router,
    store,
    i18n,
    render: a => a(App)
})