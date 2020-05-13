
<template>
   <div>
    	<form>
		<div class="form-group row">
			<label for="name" class="col-sm-2 col-form-label">student's name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="student.name" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="surname" class="col-sm-2 col-form-label">student's surname</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="student.surname" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="age" class="col-sm-2 col-form-label">student's age</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="student.age" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="sex" class="col-sm-2 col-form-label">student's sex</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="student.sex" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="address" class="col-sm-2 col-form-label">student's address</label>
			<div class="col-sm-10">
				<input type="text" class="form-control">
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
    import { mapActions } from 'vuex'
    export default {
        data() {
            return {
                student:{
               		name: "",
					surname: "",
               		age: "",
					sex: ""
               		
					
               }
            }
        },
        methods: {
	    ...mapActions(['addStudentAction']),
            submit(student) {
            	event.preventDefault();
		console.log(this.student);
            	this.addStudentAction(this.student)
            }
        }
    }
</script>

<style>
</style>