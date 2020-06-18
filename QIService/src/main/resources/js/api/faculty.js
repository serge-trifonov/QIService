import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const faculties = Vue.resource('/faculty{/id}')

export default {
	add: faculty => faculties.save({}, faculty),
    remove: id => faculties.remove({id: id})
}