import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import 'bootstrap'
import 'assets/app.scss'
import router from 'router/router'
import '@babel/polyfill'
import store from 'vuex/store'
Vue.use(VueResource)



new Vue({
    el: '#app',
    router,
    store,
    render: a => a(App)
})