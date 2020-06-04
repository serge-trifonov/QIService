<template>
<div>
   <div v-if="!success" style="width: 95%;" class="mx-auto shadow p-3 mb-5 bg-dark rounded text-light" >
   	
    	<div class="alert alert-success alert-dismissible fade show" role="alert"> {{$t('alert')}}
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    			<span aria-hidden="true">&times;</span>
 			 </button>
		</div>
		
		<h2>{{$t('descriptionProg')}}</h2>
			
				<div>
					<h2>{{program.name}}</h2>
				</div>
				
				<div>
					<p><span class="text-primary">{{$t('duration')}}: </span>{{program.duration}}</p>
				</div>
				
				<div>
					<p><span class="text-primary">{{$t('level')}}: </span>{{program.level}}</p>	
				</div>
				
				<div>
					<p>
						<span class="text-primary">{{$t('contact')}}: </span > 
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
				<textarea id="message" name="message" rows="5" cols="33" placeholder="Hello!..." v-model="application.message"></textarea>
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
   <div v-else>
   		OK SUCCESS PUSH THE BUTTON
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