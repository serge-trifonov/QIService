<template>
   <div>
    	<form>
		<div class="form-group row">
			<label for="universityName" class="col-sm-2 col-form-label">Le nom d'université</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="university.name" required>
			</div>
		</div>
		<div class="form-group row">
			<label for="status" class="col-sm-2 col-form-label">Formation</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="university.status" required>
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
                university:{
               		name: "",
					status: ""
               }
            }
        },
        methods: {
	    ...mapActions(['addUniversityAction']),
            submit(university) {
            	event.preventDefault();
		console.log(this.university);
            	this.addUniversityAction(this.university)
            }
        }
    }
</script>

<style>
</style>