import Vue from 'vue'
import VueRouter from 'vue-router'
import Program from 'pages/Program.vue'
import Student from 'pages/Student.vue'
import University from 'pages/University.vue'
import Programs from 'pages/Programs.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/program', component: Program },
    { path: '/student', component: Student },
    { path: '/university', component: University },
    { path: '/programs', component: Programs }
]


export default new VueRouter({
    mode: 'history',
    routes
})   