import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'

Vue.use(VueResource)

new Vue({
el: '#appd',
render: a => a(App)
})
 	 

/*
Vue.component('hello-list', {
	props: ['hellos'],
	data: function() {
	return {
	hello: null
	}
	},
	template:
	'<div><div v-for="hello in hellos" :key="hello.id">{{hello.text}}</div></div>',
	created: function() {
	helloApi.get().then(result =>
	result.json().then(data =>
	data.forEach(hello => this.hellos.push(hello))
	)
	)
	}
	});

	var app = new Vue({
	el: '#hello',
	template: '<hello-list :hellos="hellos" />',
	data: {
	hellos: []
	}
	});*/