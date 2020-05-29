<template>

<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">N</th>
      <th scope="col">Name</th>
      <th scope="col">Surname</th>
      <th scope="col">Age</th>
      <th scope="col">Gender</th>
      <th scope="col">Current' Level</th>
      <th scope="col">Address</th>
      <th scope="col">Photo</th>
      <th scope="col">ACCEPT/REFUSE</th>
      
    </tr>
  </thead>
  
  
  <tbody>
    <tr v-for="stud in students" :key="stud.id">
    
      <td ></td>
      <td scope="row">{{stud.givenName}}</td>
      <td scope="row">{{stud.familyName}}</td>
      <td scope="row">{{stud.age}}</td>
      <td scope="row">{{stud.gender}}</td>
      <td scope="row">{{stud.currentLevel}}</td>
      <td >address</td>
      <td >photo</td>
      
      <select class="form-control" id="decision" v-model="decision[stud.id]" required>
				
				<option selected >Decision...</option>
				<option value="accept">accept</option>
				<option value="refuse">refus</option>
				
				
			</select>
      
      
      
      
      
      
     
    </tr>
    
</table>
	
    
  </tbody>
   
</template>

<script>
    import {mapState} from 'vuex'
    
    export default {
    
   
    computed: mapState(['studByProg']),
    
    
        data() {
        
            return {
            	students:[],
            	decision:{
            		
            	}
               		
					
               
            }
        },
        methods: {
        
        
	        	submit(event){
		   			
					event.preventDefault();
					
		   			console.log("submit button");
		   			
		   			console.log(this.decision);
		   			
		   		
	        }	
	   	},
	   		
	   		
        
        async created(){
        	
        	
        	this.students= this.studByProg[this.$route.params.id];
        	console.log(this.students);
        	
        	
        }
    }
</script>

<style>
</style>