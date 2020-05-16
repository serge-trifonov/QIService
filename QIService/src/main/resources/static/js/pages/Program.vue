<template>
   <div>
    	<form>
    	
		<div class="form-group row">
			<label for="programName" class="col-sm-2 col-form-label">Le nom de programme</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="program.name" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="duration" class="col-sm-2 col-form-label">La duration</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="program.duration" required>
			</div>
			
		</div>
		
		<div class="form-group row">
			<label for="level" class="col-sm-2 col-form-label">Le niveau</label>
			<div class="col-sm-10">
			<select class="form-control" id="level" v-model="program.level" required>
				
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
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit" >Valider</button>
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
                program:{
               		name: "",
					duration: "",
					level:""
               }
            }
        },
        methods: {
	    ...mapActions(['addProgramAction']),
            submit(program) {
            	event.preventDefault();
		console.log(this.program);
            	this.addProgramAction(this.program)
            }
        }
    }
</script>

<style>
</style>
