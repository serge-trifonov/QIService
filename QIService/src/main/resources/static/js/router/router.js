import Vue from 'vue'
import VueRouter from 'vue-router'
import Program from 'pages/Program.vue'
import Student from 'pages/Student.vue'
import University from 'pages/University.vue'
import Programs from 'pages/Programs.vue'

import StudVueCand from 'pages/StudVueCand.vue'
import Users from 'pages/Users.vue'
import Faculty from 'pages/Faculty.vue'
import Address from 'pages/Address.vue'
import Search from 'pages/Search.vue'
import ProgramFound from 'pages/ProgramFound.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/program', component: Program },
    { path: '/student', component: Student },
    
    { path: '/university', component: University },
    { path: '/programs', component: Programs },
    { path: '/studVueCand', component: StudVueCand },
    { path: '/users', component: Users },
    { path: '/faculty', component: Faculty },
    { path: '/address', component: Address },
    { path: '/search', component: Search },
    { path: '/program/:id', component: ProgramFound}
    
]


export default new VueRouter({
    mode: 'history',
    routes
})   