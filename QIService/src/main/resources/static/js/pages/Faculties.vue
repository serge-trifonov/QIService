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
		  	<tr v-for="faculty in faculties":key="faculty.name">
		  	
		    	<td>{{faculty.name}}</td>
		    	<td><router-link class="btn btn-outline-dark mb-2 text-white" 
			     	
				     	:to="{path:'/programs',query:{programs: progById[faculty.id]}}" 
				     	
				     	v-if="progById[faculty.id]">{{progById[faculty.id].length}} programs
			     	
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
    	computed: mapState(['user']),
     	params:["faculties"],
     
        data() {       
            return {    
                 faculties:"",
                 progById:""
                  
                 	         
            }
        },
        
        methods: {	
	   		},
	   		     
        async created(){
        	
        	if(this.$route.query.faculties){
        		this.faculties = this.$route.query.faculties;
        	
        	}
        	else{
        		this.faculties=await this.$http.get("/faculty/"+this.user.university.id);
        		this.faculties=this.faculties.data;
        	}
        	console.log(this.faculties);
        	
        	
        	var result= await this.$http.get("/program/progsByFacultyId");
        	this.progById = result.data;
        	
        	
        	
        	
        	
        	
        }
        
    }
</script>

<style>
</style>