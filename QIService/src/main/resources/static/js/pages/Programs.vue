<template>
   <div>
	   	<table class="table table-striped">
		  	<thead>
				<tr>
					<th scope="col">{{$t('prog')}}</th>
					<th scope="col">{{$t('university')}}</th>
					<th scope="col">{{$t('duration')}}</th>
					<th scope="col">{{$t('level')}}</th>
					<th v-if="user&&user.role==='UNIVERSITY'" scope="col">Action</th>
				</tr>
		  	</thead>
		  	
	  		<tbody>
			    <tr v-for="program in programsToShow" :key="program.id" >
			      <td scope="row">{{program.name}}</td>
			      <td>{{program.faculty?program.faculty.university.name:'-'}}</td>
			      <td>{{program.duration}}</td>
			      <td>{{program.level}}</td>
			      
			      <td v-if="user&&user.role==='UNIVERSITY'">
		     		<a href="#" @click="askToRemove(program)">
		     		<img src="/images/delete3.png"  alt="remove" height="25"></a>
		     		
		     		<a href="#" @click="edit(program)">
					<img src="/images/edit3.png" alt="edit" height="25"></a>
		     	</td>
			    </tr>   
	  		</tbody>
		</table>
		
		<modal-window v-if="showModal"
			:popupTitle="'Suppression '+programToDelete.name"
			:popupBody="$t('questionDelete')+programToDelete.name+'?'"
			@close="showModal = false" @remove="remove(programToDelete)">
		</modal-window>
		
		
   </div>
</template>

<script>
	import {mapState,mapActions} from 'vuex'
	import modalWindow from '../modal/modalWindow'
	
    export default {
    
	    computed: mapState(['programs','user']),
	    components:{modalWindow},
	    
	        data() {
	            return {		
	            	programsToShow:"",
	            	facultyId:"",
	            	
	            	programToDelete:"",
            		showModal:false
	            }
	        },
	        
	        methods: {	
	       		...mapActions(['removeProgramAction']),	 
	        	async remove(program){
	
	        		await this.removeProgramAction(program);
	        		if(this.facultyId!==""){
	        			this.programsToShow=this.programs.filter(p=>p.facultyId===this.facultyId);
	        		}
					else{
						this.programsToShow=this.programs;
					}
	        		this.$forceUpdate();
	        		this.showModal=false;
	        	},
	        	
	        	askToRemove(program){
        			this.programToDelete=program;
        			this.showModal=true;
        	
        		},
	        	
	        	async edit(program){
	        		this.$router.push({ path: '/program', query: { program }})
	        	}	
	   		},
    
		async created(){
			if(this.$route.query.programs){
				
				this.programsToShow = this.$route.query.programs;
				if(this.programsToShow.length>0){
				
					this.facultyId=this.programsToShow[0].facultyId;
				}
			}
			else{
				this.programsToShow=this.programs;
			}
		}
    }
</script>

<style>
</style>
