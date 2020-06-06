<template>
<div class="container">
	<div class="row">
		<div class="col-sm">
			<div v-if="!success" class="card mx-auto shadow p-3 mb-5 bg-dark rounded text-light">
			
				<div class="alert alert-success alert-dismissible fade show" role="alert"> {{$t('alert')}}
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					 </button>
				</div>
				
				<div class="card-body">
				<h3 class="card-title text-center">{{$t('descriptionProg')}}</h3>
							
					<div class="text-center"><h2>{{program.name}}</h2></div>
					<div>
						<p><span class="text-primary">{{$t('duration')}}: </span>{{program.duration}}</p>
					</div>
					<div>
						<p><span class="text-primary">{{$t('level')}}: </span>{{program.level}}</p>	
					</div>
						<div>
						<p><span class="text-primary">{{$t('contact')}}: </span > 
								{{program.userUniv.givenName}} 
								{{program.userUniv.familyName}} 
							<span class="text-primary">:</span> 
								{{program.userUniv.email}}
						</p>
					</div>
									
					<div>
						<p><span class="text-primary">{{$t('faculty')}}:</span> {{program.faculty.name}}</p>
					</div>
					<div>
						<p><span class="text-primary">{{$t('university')}}: </span>{{program.faculty.university.name}}</p>
					</div>
					<div>
						<p><span class="text-primary">{{$t('universityAddress')}}: </span>
							{{program.faculty.university.address.postalAddress}}
							{{program.faculty.university.address.country}}
							{{program.faculty.university.address.city}} 
							{{program.faculty.university.address.number}} 
							{{program.faculty.university.address.street}} 
						</p>
					</div>	
									
					<div>
						<p><label for="message" ><span class="text-primary">{{$t('message')}}: </span></label>
						</br>
							<textarea id="message" name="message" rows="6" cols="35" placeholder="Hello!..." v-model="application.message"></textarea>
						</p>
					</div>
							
					<div class="form-group row">
						<div class="col-sm-10">
							<router-link class="btn btn-link" to="/search">
								<button type="submit" class="btn btn-primary">{{$t('back')}}</button>
							</router-link>
					
							<button type="submit" class="btn btn-primary" @click.stop="submit">{{$t('send')}}</button>
						</div>
					</div>
								
				</div>		
			</div>
			
				<div v-else class="card text-center">
				 	<div class="card-body">
				 		<h3 class="card-title">SUCCESS!!!</h3>
				 		<h5 class="card-title">CONGRATULATIONS YOUR MESSAGE HAS BEEN SEND</h5>
							
							<p class="card-text">check status of your application regulary</p>
				 	
						<p>check your application right now->
							 
							<router-link class="nav-link" to="/mainPage">
								<button  class="btn btn-success">PUSH</button>
							</router-link>	
						</p> 	
						
						<p>return to the main page->
							<button type="submit" class="btn btn-success" @click.stop="submit">PUSH</button> 	
						</p> 
						
						<p>search another the programs->
							<button type="submit" class="btn btn-success" @click.stop="submit">PUSH</button> 	
						</p> 
						
						<p>go out the program->
							<button type="submit" class="btn btn-success" @click.stop="submit">PUSH</button> 	
						</p> 
							
					</div>	
				</div>	 
		</div>				 	
	</div>					 	
</div>					 	
</template> 

<script>
       	import { mapState } from 'vuex'
       	
    	export default {
    	computed: mapState(['user']),
        data() {
            return {
            	success: false,
            	faculty:{
            		name:""
            	},
            	 program:{
                
	                name:"",
	                duration:"",
                	level:"",
                	userUniv:"",
                	faculty:{
                		university:{
                			address:""
                		}
                	}
                		
                },
                application:{
	                	studId:"",
	                	programId:"",
	                	message:""
	                	
                	} 		
 			}
        },
        methods:{
        	submit(event){
        		event.preventDefault();
        		let result=this.$http.post("/application/",this.application);
        		if(result)this.success=true;
        		
        		this.$router.push({ path: 'mainPage'});
        	}
        },
       async created(){
        	this.program=await this.$http.get("/program/"+this.$route.params.id);
        	this.program = this.program.data;
        	
        	this.faculty=await this.$http.get("/faculty/"+this.$route.params.id);
        	this.faculty = this.faculty.data;
        	
        	this.application.studId=this.user.id;
        	this.application.programId=this.program.id;
        }  
    }
 
</script>