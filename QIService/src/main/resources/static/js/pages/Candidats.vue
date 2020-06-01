<template>
<div>
<h2>{{prog.name}}</h2>
<table class="table table-dark">
  <thead>
    <tr>
      
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
    
      
      
      <td scope="row">{{stud.givenName}}</td>
      <td scope="row">{{stud.familyName}}</td>
      <td scope="row">{{stud.age}}</td>
      <td scope="row">{{stud.gender}}</td>
      <td scope="row">{{stud.currentLevel}}</td>
      <td >address</td>
      <td >photo</td>
      
      	<select class="form-control" id="decision" v-model="reponseByStud[prog.id][stud.id].response" required>
				
			<option selected >Decision...</option>
			<option value="ACCEPTED">accept</option>
			<option value="REFUSED">refus</option>
				
		</select>
   
    </tr>
    </tbody>
    
	</table>
	
	<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit">VALID</button>
			</div>
		</div>
	
    </div>
  
   
</template>

<script>
    import {mapState, mapActions} from 'vuex'
    
    export default {
    
   
    computed: mapState(['studByProg','reponseByStud']),
    params: ['prog'],
    
    
        data() {
        
            return {
            	prog:"",
            	students:[],
            	decision:{
            		
            	}          
            }
        },
        methods: {
        ...mapActions(['updateAppReponse']),
        
	        	submit(event){
		   			
					event.preventDefault();
					
					this.students.forEach(student=>{
						if(this.reponseByStud[prog.id][student.id].response !== 'PENDING') {
						
							
							
							this.updateAppReponse(this.reponseByStud[prog.id][student.id]);
						}
					});
					
					
		   			
		   			
		   			
		   			
		   		
	        }	
	   	},
	   		
	   		
        
        async created(){
        	
        	
        	this.students= this.studByProg[this.$route.params.id];
			this.prog = this.$route.query.prog;
        	
        	
        	
        	
        }
    }
</script>

<style>
</style>