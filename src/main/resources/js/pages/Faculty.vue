<template>
   <div class="container">
   		<div class="row">
   			<div class="col-sm">
   				<div class="card">
   					<div class="card-body">
   					<h5 v-if="!edit" class="card-title text-center ">{{$t('facultyRegistration')}}</h5>
   					<h5 v-else class="card-title text-center ">{{$t('facultyModification')}}</h5>
					    	<form action="">
					    	
								<div class="form-group row">
									<label for="facultyName" class="col-sm-2 col-form-label">{{$t('facultyNameEnter')}}</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" v-model="faculty.name" required>
										</div>
								</div>
															
								<div  class="form-group text-center">			
									<button v-if="!edit"type="submit" class="btn btn-success" @click.stop="submit" >{{$t('add')}}</button>
									<button v-else type="submit" class="btn btn-success" @click.stop="editFaculty" >{{$t('edit')}}</button>
												
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
                faculty:"",
                edit:false
            }
        },
        
        methods: {
	    ...mapActions(['addFacultyAction']),
           async submit(event) {
            	event.preventDefault();
            	await this.addFacultyAction(this.faculty);
            	this.$router.push({ path: 'faculties'});
            },
            
            async   editFaculty() {      
            	event.preventDefault();  	
            	await this.$http.put("/faculty/"+this.faculty.id,this.faculty);
            	this.$router.push({ path: '/faculties'});
	
            }
        },      
        created(){	               
	         if( this.$route.query.faculty) {
        		this.faculty = this.$route.query.faculty; 
        		this.edit = true;
        	} 
        	else{
        		this.faculty={name: "",universityId:this.user.universityId} 
        	}                 	
        }   
    }
</script>

<style>
</style>
