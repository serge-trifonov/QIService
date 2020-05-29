<template>

<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Program</th>
      <th scope="col">Candidat</th>
      
    </tr>
  </thead>
  
  <tbody>
    <tr v-for="program in programs" :key="program.id">
    	<td scope="row">{{program.name}}</td>
      
     	<td>{{studByProg[program.id].length}}
     	
     	
     	
     	<router-link class="btn btn-link" :to="'/candidats/'+program.id"><img src="/images/eye.png" alt="eye" height="20"></router-link>
      	 </td>
    </tr>
  </tbody>
</table>
   
</template>

<script>

    import {mapState} from 'vuex'
    
    export default {
    
   
    
    computed: mapState(['programs','studByProg','user']),
    
        data() {
        
            return {
            	
               		
					
               
            }
        },
        methods: {
        		
        		
        		
        
        		
        		
	   		},
	   		
        
        async created(){
        	
        	console.log(this.userProgram);
        	console.log(this.userInfo);
        	console.log(this.studByProg);
        	console.log(JSON.parse(JSON.stringify(this.studByProg)));
        	console.log(this.user);
        	
        }
    }
</script>

<style>
</style>