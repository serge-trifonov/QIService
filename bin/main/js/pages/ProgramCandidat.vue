<template>
	<table class="table table-dark">
	 <thead>
	    <tr>
	    	<th scope="col">{{$t('prog')}}</th>
	    	<th scope="col">{{$t('cand')}}</th>   
	 	</tr>
	 </thead>
	  
	  	<tbody>
		  	<tr v-for="program in programs" :key="program.id">
		    	<td scope="row">{{program.name}}</td>
		     	<td>{{studByProg[program.id]?studByProg[program.id].length:"no application"}}
		
		     		<router-link v-if="studByProg[program.id]" 
		     	
			     	class="btn btn-link" :to="{ path: '/candidats/'+program.id, query: { prog : program }}" >
			     	
			     	<img src="/images/eye.png" alt="eye" height="20">
		     	
		     	</router-link>
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
			console.log(this.programs);
			console.log(this.studByProg);
			console.log(this.user);	
        }
    }
</script>

<style>
</style>