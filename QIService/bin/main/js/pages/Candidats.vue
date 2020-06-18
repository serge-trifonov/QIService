<template>
<div>
	<h2>{{prog.name}}</h2>
	<table class="table table-dark">
	 	<thead>
		    <tr>
		      
		      <th scope="col">{{$t('name')}}</th>
		      <th scope="col">{{$t('surname')}}</th>
		      <th scope="col">{{$t('age')}}</th>
		      <th scope="col">{{$t('gender')}}</th>
		      <th scope="col">{{$t('currentLevel')}}</th>
		      <th scope="col">{{$t('address')}}</th>
		      <th scope="col">{{$t('photo')}}</th>
		      <th scope="col">{{$t('accept')}}/{{$t('refuse')}}</th>
		      
		    </tr>
		</thead>
	  
	 	<tbody>
		    <tr v-for="stud in students" :key="stud.id">
		    
		      	<td scope="row">{{stud.givenName}}</td>
		      	<td scope="row">{{stud.familyName}}</td>
		      	<td scope="row">{{stud.age}}</td>
		      	<td scope="row">{{stud.gender}}</td>
		      	<td scope="row">{{stud.currentLevel}}</td>
		      	<td >address</td>
		      	<td >photo</td>
		      
				<select class="form-control" id="decision" v-model="reponseByStud[prog.id][stud.id].response" required>
						
					<option selected >{{$t('decision')}}</option>
					<option value="ACCEPTED">{{$t('accept')}}</option>
					<option value="REFUSED">{{$t('refuse')}}</option>
						
				</select>
		    </tr>
		</tbody>
	</table>
	
	<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit">{{$t('valid')}}</button>
			</div>
		</div>
	
    </div>
  
   
</template>

<script>
    import {mapState, mapActions} from 'vuex'
    
    export default {
    
    	computed: mapState(['studByProg','reponseByStud']),
    	params: ['prog'],
 
        data() {
            return {
            	prog:"",
            	students:[],
            	decision:{
            		
            	}          
            }
        },
        methods: {
        ...mapActions(['updateAppReponse']),
        
	        	submit(event){
		   			
					event.preventDefault();
					
					this.students.forEach(student=>{
						if(this.reponseByStud[prog.id][student.id].response !== 'PENDING') {
						
							this.updateAppReponse(this.reponseByStud[prog.id][student.id]);
						}
					});	
	        }	
	   	},

        async created(){
        	
        	this.students= this.studByProg[this.$route.params.id];
			this.prog = this.$route.query.prog;	
        }
    }
</script>

<style>
</style>