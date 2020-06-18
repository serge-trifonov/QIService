<template>
   <div class="container">
   		<div class="row">
   			<div class="col-sm">
   				<div class="card">
   					<div class="card-body">
   						<h5 v-if="!edit" class="card-title text-center">{{$t('programRegistration')}}</h5>
   						<h5 v-else class="card-title text-center">{{$t('programModification')}}</h5>
   			
					    	<form action="">
					    	
							<div class="form-group row">
								<label for="programName" class="col-sm-2 col-form-label">{{$t('programNameEnter')}}</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" v-model="program.name" required>
								</div>
							</div>
											
							<div class="form-group row">
								<label for="duration" class="col-sm-2 col-form-label">{{$t('duration')}}</label>
								<div class="col-sm-10">
									
									<select class="form-control" id="duration" v-model="program.duration" required>
									
										<option selected>{{$t('choice')}}</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="5">5</option>
										
									</select>
								</div>
							</div>
											
							<div class="form-group row">
								<label for="facultyName" class="col-sm-2 col-form-label">{{$t('facultyNameChoice')}}</label>
								<div class="col-sm-10">
									<select class="form-control" id="facultyId" v-model="program.facultyId">
									
										<option selected>{{$t('choice')}}</option>
								        <option :value="fac.id" v-for="fac in faculties">{{fac.name}}</option>
					
									</select>
								</div>
							</div>
											
							<div class="form-group row">
								<label for="level" class="col-sm-2 col-form-label">{{$t('level')}}</label>
								<div class="col-sm-10">
									<select class="form-control" id="level" v-model="program.level" required>
									
										<option selected>{{$t('choice')}}</option>
										<option value="L1">L1</option>
										<option value="L2">L2</option>
										<option value="L3">L3</option>
										<option value="M1">M1</option>
										<option value="M2">M2</option>
										<option value="D">D</option>
									
									</select>
								</div>
							</div>
										
							<div  class="form-group text-center">
								
								<button v-if="!edit" type="submit" class="btn btn-success" @click.stop="submit" >{{$t('add')}}</button>
								<button v-else type="submit" class="btn btn-success" @click.stop="editProgram" >{{$t('edit')}}</button>
								
							</div>			
						</form>
					</div>
				</div>
			</div>
		</div>
   </div>
</template>

<script>

    import { mapActions,mapState } from 'vuex'
    export default {
    computed: mapState(['user']),
        data() {
            return {
            	edit:false,
                program:{
               		name: "",
					duration: "",
					level:""
               },
               faculties:[]
            }
        },
        
        methods: {
	    ...mapActions(['addProgramAction','updateProgramAction']),
	    
           async submit(event) {
           
            	event.preventDefault();
            	this.program.faculty = this.faculties.find(faculty=>faculty.id === this.program.facultyId);
            	await this.addProgramAction(this.program);
            	this.$router.push({ path: 'programs'});
            	
            },
            async   editProgram() {      
            	event.preventDefault();  	
            	await this.updateProgramAction(this.program);
            	 this.$router.push({ path: '/programs'});
            }
        },
        
       async created(){
       
       		if(this.$route.query.program){
        		this.program = this.$route.query.program;
        		this.edit=true;
        	}
        	
        	const responseFaculty=await this.$http.get("/faculty/"+this.user.universityId);
			this.faculties=responseFaculty.data;	
        }
    }
</script>

<style>
</style>
