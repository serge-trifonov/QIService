<template>
<div class="container">
	<div class="row">
		<div class="col-sm">
			<div class="card">
				<div class="card-body text-center">
					<h5 class="card-title">University registration</h5>
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
								<button type="submit" class="btn btn-success" @click.stop="submit">{{$t('valid')}}</button>
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
	    ...mapActions(['addUniversityAction']),
	    
            submit(university) {
            
            	event.preventDefault();
            	this.addUniversityAction(this.university);
            	this.$router.push({ path: 'universities'});
            }
        }
    }
</script>

<style>
</style>