<template>
   <div>
    <form style="width: 90%;" class="mx-auto" v-if="searchActiv">
		
		<div class="form-group row">
			<label for="searchCity" class="col-sm-2 col-form-label">{{$t('cityNameEnter')}}</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="searchParam.city" >
			</div>
		</div>
		
		<div class="form-group row">
			<label for="searchCountry" class="col-sm-2 col-form-label">{{$t('countryNameChoice')}}</label>
			<div class="col-sm-10">
				<select  class="form-control" id="searchCountry" v-model="searchParam.country" >
			        <option selected>{{$t('choice')}}</option>
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
			<label for="searchLevel" class="col-sm-2 col-form-label">{{$t('levelChoice')}}</label>
			<div class="col-sm-10">	
				<select class="form-control" id="level" v-model="searchParam.level">
					<option selected>{{$t('choice')}}</option>
					<option value="BAC">BAC</option>
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
			<label for="searchFaculty" class="col-sm-2 col-form-label">{{$t('facultyNameChoice')}}</label>
			<div class="col-sm-10">
				<select class="form-control" id="facultyName" v-model="searchParam.faculty">
					<option selected>{{$t('choice')}}</option>
					<option v-for="fac in faculties">{{fac}}</option>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<label for="searchProgram" class="col-sm-2 col-form-label">{{$t('programNameEnter')}}</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="searchParam.program" required>
			</div>
		</div>

		<div class="form-group row">
			<label for="searchUniversity" class="col-sm-2 col-form-label">{{$t('universityNameChoice')}}</label>
			<div class="col-sm-10">
				<select class="form-control" id="universityName" v-model="searchParam.university">
					<option selected>{{$t('choice')}}</option>
					<option v-for="un in universities">{{un}}</option>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit">{{$t('searche')}}</button>
			</div>
	</div>
	</form>
	
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="button" class="btn btn-outline-secondary" v-if='!searchActiv' @click.stop="newSearch">{{$t('newSearche')}}</button>
			</div>
		</div>
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
            	const result=await this.$http.post("/search",this.searchParam);
            	this.searchProg=result.data;	
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
        }  
    }
  
</script>

<style>
</style>