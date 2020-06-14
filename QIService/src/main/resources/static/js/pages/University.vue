<template>
<div class="container">
	<div class="row">
		<div class="col-sm">
			<div class="card">
				<div class="card-body text-center">
					<h5 v-if="!edit" class="card-title">University registration</h5>
					<h5 v-else class="card-title">University modification</h5>
					    <form action="">
					    
							<div class="form-group row">
								<label for="universityName" class="col-sm-2 col-form-label">{{$t('universityNameEnter')}}</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" v-model="university.name" required>
								</div>
							</div>
							
							<div class="form-group">
								<label for="status" class="col-sm-1 col-form-label"></label>
								<Address :parentAddress="university.address"/>	
							</div>
							<div class="form group">
								<button v-if="!edit" type="submit" class="btn btn-success" @click.stop="submit">{{$t('valid')}}</button>
								<button v-else type="submit" class="btn btn-success" @click.stop="editUniversity">EDIT</button>
							</div>	
						</form>
					</div>
				</div>
			</div>
		</div>			    
	</div>			    
</div>			    
</template>

<script>
    import { mapActions } from 'vuex'
    import Address from './Address'
    export default {
    	components:{Address},
        data() {
            return {
            	edit: false,
            	
                university:{
               		name: "",
					address:{ 
						number:"",
						street:"",
						postalAddress:"",
						city:"",
						country:""	
					}
               }
            }
        },
        methods: {
	    ...mapActions(['addUniversityAction','updateUniversityAction']),
	    
         async   submit(university) {
            
            	event.preventDefault();
            	await this.addUniversityAction(this.university);
            	this.$router.push({ path: '/universities'});
            },
            
         async   editUniversity(university) {
            
            	event.preventDefault();
            	
            	await this.updateUniversityAction(this.university);
            	
            	this.$router.push({ path: '/universities'});
            }
           
        },
        async created(){
        	if( this.$route.query.university) {
        		this.university = this.$route.query.university; 
        		this.edit = true;
        	}
        }
    }
</script>

<style>
</style>