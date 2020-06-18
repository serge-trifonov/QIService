import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const users = Vue.resource('/users{/id}')

export default {
	add: user => users.save({}, user),
    remove: id => users.remove({id: id}),
    update: user => users.update({id: user.id}, user)
}