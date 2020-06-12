<template>
	<div>
	<h2>{{$t('listUniversity')}}</h2>
		<table class="table table-dark">
		  <thead>
		    <tr>
		    
		      <th scope="col">Name</th>
		      <th scope="col">Faculties</th>
		      <th scope="col">Action</th>
		      
		    </tr>
		  </thead>
		  
		  <tbody>
		  	<tr v-for="university in universities":key="university.id">
		  	
		    	<td>{{university.name}}</td>
		     	<td> 
			     	<router-link class="btn btn-outline-dark mb-2 text-white" 
			     	
				     	:to="{path:'/faculties',query:{faculties: facById[university.id]}}" 
				     	
				     	v-if="facById[university.id]">
				     	
				     	<img src="/images/eye2.png" alt="edit" height="25"></a>
				     	
				     	 {{getFaculties(university.id).length}}
			     	
			     	</router-link>
			     	
			     	<span v-else >no fac</span>
		     	
		     	</td>
		     	<td>
		     		<img src="/images/delete2.png" alt="edit" height="25"></a>
		     		<img src="/images/edit2.png" alt="edit" height="25"></a>
		     	
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
        	
        	console.log(this.facById);
        }
    }
</script>

<style>
</style>