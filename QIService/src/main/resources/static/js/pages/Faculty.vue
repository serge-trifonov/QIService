<template>
   <div>
    	<form>
    	
		<div class="form-group row">
			<label for="facultyName" class="col-sm-2 col-form-label">Faculty's name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="faculty.name" required>
			</div>
		</div>
			
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit" >Valider</button>
			</div>
		</div>
		</form>
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
		console.log(this.faculty);
            	this.addFacultyAction(this.faculty)
            }
        },
        created(){
        console.log(this.user);
	        this.faculty={
	               		name: "",
	               		universityId:this.user.universityId

	               };
	        	
        }
    }
</script>

<style>
</style>
