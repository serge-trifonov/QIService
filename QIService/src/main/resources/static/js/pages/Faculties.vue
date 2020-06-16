<template>
	<div>
	
	<h2>{{$t('faculties')}}</h2>
	
		<table class="table table-dark">
		  	<thead>
			    <tr >
			    
			      <th scope="col">Name</th>
			      <th scope="col">Programs</th>
			      <th v-if="user&&user.role==='UNIVERSITY'"scope="col">Action</th>
			       
				</tr>
		  	</thead>
		  
			  <tbody>
			  	<tr v-for="faculty in faculties":key="faculty.name">
			    	<td>{{faculty.name}}</td>
			    	<td><router-link class="btn btn-outline-dark mb-2 text-white" 
				     	
					     	:to="{path:'/programs',query:{programs: progById[faculty.id]}}" 
					     	
					     	v-if="progById[faculty.id]">{{progById[faculty.id].length}} programs
				     	
				     	</router-link>
				     	
				     	<span v-else >no prog</span>
				     </td>
				     
				     <td v-if="user&&user.role==='UNIVERSITY'">
			     		<a href="#" @click="askToRemove(faculty)">
			     		<img src="/images/delete2.png"  alt="edit" height="25"></a>
			     		
			     		<a href="#" @click="edit(faculty)">
						<img src="/images/edit2.png" alt="edit" height="25"></a>
			     	</td>
			    </tr> 
			</tbody>
		</table>
		
		<modal-window v-if="showModal"
			:popupTitle="'Suppression '+facultyToDelete.name"
			:popupBody="$t('questionDelete')+facultyToDelete.name+'?'"
			@close="showModal = false" @remove="remove(facultyToDelete)">
		</modal-window>
		
	</div>  
</template>

<script>

    import {mapState} from 'vuex'  
    import modalWindow from '../modal/modalWindow'
    
    export default { 
		computed: mapState(['user']),
		components:{modalWindow},
     	params:["faculties"],
     
        data() {       
            return {    
                faculties:"",
                progById:"",
                
                facultyToDelete:"",
            	showModal:false
    	         
            }
        },  
        methods: {	
        
        	async remove(faculty){
        		
        		await this.$http.delete("/faculty/"+faculty.id);
        		
        		this.faculties=await this.$http.get("/faculty/"+this.user.university.id);
        		this.faculties=this.faculties.data;
        		this.showModal=false;

        	},
        	askToRemove(faculty){
        		this.facultyToDelete=faculty;
        		this.showModal=true;
        	
        	},
        	async edit(faculty){
        		this.$router.push({ path: '/faculty', query: { faculty }});
        	}	
	   	},
	   		     
        async created(){
        	
        	if(this.$route.query.faculties){
        		this.faculties = this.$route.query.faculties;	
        	}
        	else{
        		this.faculties=await this.$http.get("/faculty/"+this.user.university.id);
        		this.faculties=this.faculties.data;
        	}
        	
        	var result= await this.$http.get("/program/progsByFacultyId");
        	this.progById = result.data;	
        },    
    }
</script>

<style>
</style>