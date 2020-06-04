<template>
	<div>
	<h2>{{$t('listUniversity')}}</h2>
		<table class="table table-dark">
		  <thead>
		    <tr>
		    
		      <th scope="col">Name</th>
		      <th scope="col">Faculties</th>
		      
		    </tr>
		  </thead>
		  
		  <tbody>
		  	<tr v-for="university in universities":key="university.id">
		  	
		    	<td>{{university.name}}</td>
		     	<td> 
			     	<router-link class="btn btn-outline-dark mb-2" 
			     	
				     	:to="{path:'/faculties',query:{faculties: facById[university.id]}}" 
				     	
				     	v-if="facById[university.id]">see {{getFaculties(university.id).length}} faculties
			     	
			     	</router-link>
			     	
			     	<span v-else >no fac</span>
		     	
		     	</td>
		     	
		    </tr>
		  </tbody>
		</table>
	</div>  
</template>

<script>

    import {mapState} from 'vuex' 
     
    export default { 
    	
        data() {       
            return {    
                universities:"",
                facById:"" 	         
            }
        },
        methods: {	
        
        	async getFaculties(id){ 
        		const response=await this.$http.get("/faculty/"+id);
        		return response.data;
        	}
	   	},
	   		   		     
        async created(){
        
        	this.universities=await this.$http.get("/university");
        	this.universities=this.universities.data;
        	
        	const fac = await this.$http.get("/faculty/map");
        	this.facById = fac.data;	
        }
    }
</script>

<style>
</style>