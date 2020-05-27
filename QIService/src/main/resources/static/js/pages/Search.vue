<template>
   <div>
    	<form style="width: 90%;" class="mx-auto" v-if="searchActiv">
		
		
		<div class="form-group row">
			<label for="searchCity" class="col-sm-2 col-form-label">CITY</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="searchParam.city" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="searchCountry" class="col-sm-2 col-form-label">COUNTRY</label>
			<div class="col-sm-10">
				
				<select id="searchCountry" class="form-control"  v-model="searchParam.country">
			        <option selected>Choose...</option>
			        <option value="espagne">Espagne</option>
			        <option value="chine">Chine</option>
			        <option value="japon">Japon</option>
			        <option value="canada">Canada</option>
			        <option value="france">France</option>
			        <option value="maroc">Maroc</option>
			        <option value="russia">Russia</option>
			      </select>
				
			</div>
		</div>
		
		<div class="form-group row">
			<label for="searchLevel" class="col-sm-2 col-form-label">LEVEL</label>
			<div class="col-sm-10">
				
				<select class="form-control" id="level" v-model="searchParam.level" required>
				
				<option selected value="BAC">Choose...</option>
				<option value="L1">L1</option>
				<option value="L2">L2</option>
				<option value="L3">L3</option>
				<option value="M1">M1</option>
				<option value="M2">M2</option>
				<option value="D">D</option>
				
			</select>

			</div>
		</div>
		
		
		
		<div class="form-group row">
			<label for="searchFaculty" class="col-sm-2 col-form-label">FACULTY'S NAME</label>
			<div class="col-sm-10">
				<select class="form-control" id="facultyName" v-model="searchParam.faculty">
				
					<option selected>Choose...</option>
					<option v-for="fac in faculties">{{fac}}</option>
					
			        

				</select>
			</div>
		</div>
		
		
		
		
		
		<div class="form-group row">
			<label for="searchProgram" class="col-sm-2 col-form-label">PROGRAM</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="searchParam.program" required>
			</div>
		</div>
		
		
		
		
		
		<div class="form-group row">
			<label for="searchUniversity" class="col-sm-2 col-form-label">UNIVERSITY</label>
			<div class="col-sm-10">
				<select class="form-control" id="universityName" v-model="searchParam.university">
				
					<option selected>Choose...</option>
					<option v-for="un in universities">{{un}}</option>
					
			        

				</select>
			</div>
		</div>
		
		
		
		
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit">SEARCH</button>
			</div>
		</div>
	</form>
	
	
	<button type="button" class="btn btn-outline-secondary" v-if='!searchActiv' @click.stop="newSearch">New search</button>
	
	
	<div v-for="program in searchProg" class="bg-light mx-auto" style="width: 90%;">
	
	
	<router-link class="nav-link" :to="'program/'+program.id">{{program.name}}</router-link>
	
   		
   		</div>
	
   </div>
   
   
   
   		
   		
   		
   		
   		
   		
</template>

<script>
    
       	
    	export default {
    	
        data() {
            return {
            
           		faculties:"",
           		universities:"",
           		searchProg:[],
           		searchActiv:true,
            
                searchParam:{
                
	                city:"",
	                country:"",
                	level:"BAC",
                	faculty:"",
                	program:"",
                	university:""
                	
                },
                
            }
        },
        methods: {
	    
           async submit(event) {
           		
            	event.preventDefault();
            	this.searchActiv=false;
            	console.log(this.searchParam);
            	
            	const result=await this.$http.post("/search",this.searchParam);
            	this.searchProg=result.data;
            	
            	console.log(this.searchProg);
				
            },
            newSearch(){
            	this.searchActiv=true;
            	this.searchProg=[];
            
            }
            
        },
        async created(){
        
        	this.faculties=await this.$http.get("/faculty");
        	this.faculties = this.faculties.data;
        	
        	this.universities=await this.$http.get("/university/names");
        	this.universities = this.universities.data;
        	
        	
        	
        	
        	
        	console.log(this.searchProg);
	        
	        	
        }
       
    }
      
    
</script>

<style>
</style>