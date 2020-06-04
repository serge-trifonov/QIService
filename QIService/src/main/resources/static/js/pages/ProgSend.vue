<template>
	<div>
		<h2>name student</h2>
			<table class="table table-dark">
		  		<thead>
		    		<tr> 
				      <th scope="col">{{$t('prog')}}</th>
				      <th scope="col">Status</th>
		    		</tr>
		  		</thead>
		  
		  
		  	<tbody>
			    <tr v-for="app in applications" :key="app.id">
			     
			      <td scope="row">{{app.program.name}}</td>
			      <td scope="row">{{app.response}}</td>
			
			    </tr>
		    </tbody>
	    
		</table>
	</div>
</template>

<script>
    import {mapState} from 'vuex'
  
    export default {
   		computed: mapState(['applications']),
        data() {
            return {
            	          
            }
        },
        methods: {
       
	        	submit(event){
					event.preventDefault();	
	        }	
	   	},
        async created(){	
        }
    }
</script>

<style>
</style>