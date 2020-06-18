import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)

const students = Vue.resource('/users/stud{/id}')

export default {
	add: student => students.save({}, student),
    remove: id => students.remove({id: id}),
    update: user => students.update({id: user.id}, user)
}