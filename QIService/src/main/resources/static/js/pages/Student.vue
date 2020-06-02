
<template>
   <div>
    	<form style="width: 90%;" class="mx-auto">
		<div class="form-group row">
			<label for="name" class="col-sm-2 col-form-label">{{$t('name')}}</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="user.givenName" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="surname" class="col-sm-2 col-form-label">{{$t('surname')}}</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="user.familyName" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="age" class="col-sm-2 col-form-label">{{$t('age')}}</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="user.age" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="gender" class="col-sm-2 col-form-label">{{$t('gender')}}</label>
			<div class="col-sm-10">
			<select class="form-control" id="gender" v-model="user.gender" required>
				
				<option value="M">M</option>
				<option value="F">F</option>
				
				
			</select>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="currentLevel" class="col-sm-2 col-form-label">{{$t('currentLevel')}}</label>
			<div class="col-sm-10">
			<select class="form-control" id="level" v-model="user.currentLevel" required>
				
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
			<label for="status" class="col-sm-2 col-form-label">{{$t('address')}}</label>
			<div class="col-sm-10">
				<Address :parentAddress="user.address"/>	
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
    import { mapActions,mapState } from 'vuex'
    import Address from './Address'
    export default {
    	components:{Address},
       	computed: mapState(['user']),
       	data() {
            return {
                
            }
        },
        methods: {
	    ...mapActions(['updateStudentAction']),
            submit(event) {
            	event.preventDefault();
            	this.updateStudentAction(this.user);
            }
        },
        created(){
        	this.user.address={ 
					number:"",
					street:"",
					postalAddress:"",
					city:"",
					country:""
						
					}
        	console.log(this.user);
        }
      
    }
</script>

<style>
</style>