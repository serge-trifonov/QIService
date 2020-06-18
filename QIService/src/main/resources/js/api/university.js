import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const universities = Vue.resource('/university{/id}')

export default {
	add: university => universities.save({}, university),
    remove: id => universities.remove({id: id}),
    update: university => universities.update({id: university.id}, university)
}