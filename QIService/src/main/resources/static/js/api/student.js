import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)

const students = Vue.resource('/student{/id}')

export default {
	add: student => students.save({}, student),
    remove: id => students.remove({id: id})
}