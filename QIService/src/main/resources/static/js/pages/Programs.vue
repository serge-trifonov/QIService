<template>
   <div>
   <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Titre</th>
      <th scope="col">Université</th>
      <th scope="col">Durée</th>
      <th scope="col">Niveau</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="program in allprograms" :key="program.id" >
      <td scope="row">{{program.name}}</td>
      <td>{{program.university?program.university.name:'-'}}</td>
      <td>{{program.duration}}</td>
      <td>{{program.level}}</td>
      	
      <td></td>
    </tr>
   
  </tbody>
</table>
    
   </div>
</template>

<script>
	import {mapState} from 'vuex'
    export default {
    computed: mapState(['allprograms']),
        data() {
            return {
            	//prog:programs,
              //  messages: []
                //profile: frontendData.profile
            }
        },
	created(){
		console.log("created!!!!");
	}
    }
</script>

<style>
</style>
