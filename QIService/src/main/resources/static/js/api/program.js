import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const programs = Vue.resource('/program{/id}')

export default {
	add: program => programs.save({}, program),
    remove: id => programs.remove({id: id})
}