import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const app = Vue.resource('/application{/id}')

export default {
	update: application => app.update({id: application.id}, application), 
	add: application => app.save({}, application),
    remove: id => app.remove({id: id})
}