<template>
   <div>
    	<form style="width: 90%;" class="mx-auto">
    	
		<div class="form-group row">
			<label for="programName" class="col-sm-2 col-form-label">{{$t('programNameEnter')}}</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" v-model="program.name" required>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="duration" class="col-sm-2 col-form-label">{{$t('duration')}}</label>
			<div class="col-sm-10">
				
				
				<select class="form-control" id="duration" v-model="program.duration" required>
				
					<option selected>{{$t('choice')}}</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="5">5</option>
					
				
				</select>
			</div>
			
		</div>
		
		<div class="form-group row">
			<label for="facultyName" class="col-sm-2 col-form-label">{{$t('facultyNameChoice')}}</label>
			<div class="col-sm-10">
				<select class="form-control" id="facultyId" v-model="program.facultyId">
				
					<option selected>{{$t('choice')}}</option>
			        <option :value="fac.id" v-for="fac in faculties">{{fac.name}}</option>

				</select>
			</div>
		</div>
		
		
		<div class="form-group row">
			<label for="level" class="col-sm-2 col-form-label">{{$t('levelChoice')}}</label>
			<div class="col-sm-10">
				<select class="form-control" id="level" v-model="program.level" required>
				
					<option selected>{{$t('choice')}}</option>
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
				<button type="submit" class="btn btn-primary" @click.stop="submit" >{{$t('valid')}}</button>
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
                program:{
               		name: "",
					duration: "",
					level:""
               },
               faculties:[]
            }
        },
        methods: {
	    ...mapActions(['addProgramAction']),
            submit(event) {
            	event.preventDefault();
				console.log(this.program);
            	this.addProgramAction(this.program);
            }
        },
       async created(){
        	const response=await this.$http.get("/faculty/"+this.user.universityId);
        	this.faculties=response.data;
        	console.log(this.faculties);
        }
    }
</script>

<style>
</style>
