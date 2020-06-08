<template>
   <div class="container">
   		<div class="row">
   			<div class="col-sm">
   				<div class="card">
   					<div class="card-body">
   					<h5 class="card-title text-center ">Faculty registration</h5>
					    	<form action="">
					    	
								<div class="form-group row">
									<label for="facultyName" class="col-sm-2 col-form-label">{{$t('facultyNameEnter')}}</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" v-model="faculty.name" required>
										</div>
								</div>
												
											
								<div  class="form-group text-center">			
									<button type="submit" class="btn btn-success" @click.stop="submit" >{{$t('valid')}}</button>
												
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
                faculty:""
            }
        },
        
        methods: {
	    ...mapActions(['addFacultyAction']),
	    
            submit(event) {
            	event.preventDefault();
            	this.addFacultyAction(this.faculty);
            	this.$router.push({ path: 'faculties'});
            }
        },
        
        created(){
	        this.faculty={
	               		name: "",
	               		universityId:this.user.universityId
	               };    	
        }
    }
</script>

<style>
</style>
