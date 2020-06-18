import Vue from 'vue'
import VueResource from 'vue-resource'
Vue.use(VueResource)
const addresses = Vue.resource('/address{/id}')

export default {
	add: address => addresses.save({}, address),
    remove: id => addresses.remove({id: id})
}