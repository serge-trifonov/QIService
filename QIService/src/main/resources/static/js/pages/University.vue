<template>
   <div>
    	<form style="width: 90%;" class="mx-auto">
    	
		<div class="form-group row">
			<label for="universityName" class="col-sm-2 col-form-label">{{$t('universityNameEnter')}}</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="university.name" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="status" class="col-sm-2 col-form-label">{{$t('status')}}</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="university.status" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="status" class="col-sm-2 col-form-label">{{$t('address')}}</label>
			
			<div class="col-sm-10">
				<Address :parentAddress="university.address"/>	
				
			</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit">{{$t('valid')}}</button>
			</div>
		</div>

	</form>
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
					status: "",
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
            	this.addUniversityAction(this.university)
            }
        }
    }
</script>

<style>
</style>