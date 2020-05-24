
<template>
   <div>
    	<form style="width: 95%;" class="mx-auto">
		<div class="form-group row">
			<label for="name" class="col-sm-2 col-form-label">student's name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="user.givenName" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="surname" class="col-sm-2 col-form-label">student's surname</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="user.familyName" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="age" class="col-sm-2 col-form-label">student's age</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="user.age" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="sex" class="col-sm-2 col-form-label">student's sex</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="user.sex" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="address" class="col-sm-2 col-form-label">student's address</label>
			<div class="col-sm-10">
				<input type="text" class="form-control">
			</div>
		</div>
		
		<div class="form-group row">
			<label for="status" class="col-sm-2 col-form-label">Address</label>
			<div class="col-sm-10">
				<Address/>	
			</div>
		</div>
		
		
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit">Valider</button>
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
	    ...mapActions(['addStudentAction']),
            submit(event) {
            	event.preventDefault();
            	this.addStudentAction(this.user)
            }
        },
        created(){
        	console.log(this.user);
        }
      
    }
</script>

<style>
</style>