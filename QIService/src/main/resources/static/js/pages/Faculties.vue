<template>
	<div>
	
	<h2>{{$t('listFaculty')}}</h2>
	
		<table class="table table-dark">
		  <thead>
		    <tr >
		    
		      <th scope="col">Name</th>
		      <th scope="col">Programs</th>
		       
		    </tr>
		  </thead>
		  
		  <tbody>
		  	<tr v-for="fac in faculties":key="fac.name">
		  	
		    	<td>{{fac.name}}</td>
		    	<td><router-link class="btn btn-outline-dark mb-2" 
			     	
				     	:to="{path:'/programs',query:{programs: progById[faculty.id]}}" 
				     	
				     	v-if="progById[faculty.id]">see{{getPrograms(faculty.id).length}} programs
			     	
			     	</router-link>
			     	
			     	<span v-else >no prog</span></td>
		     	
		    </tr>
		  </tbody>
		</table>
	</div>  
</template>

<script>

    import {mapState} from 'vuex'  
    
    export default { 
    
     params:["faculties"],
     
        data() {       
            return {    
                 faculties:""  	         
            }
        },
        
        methods: {	
	   		},
	   		     
        async created(){
        	this.faculties = this.$route.query.faculties;
        }
    }
</script>

<style>
</style>