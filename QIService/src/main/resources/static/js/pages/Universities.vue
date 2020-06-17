<template>
	<div>
	
		<h2>{{$t('universities')}}</h2>
	
		<div v-if="!user" class="alert alert-danger alert-dismissible fade show" role="alert"> 
				{{$t('alert2')}}
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	
		<table class="table table-dark">
			 <thead>
			    <tr>
				    <th scope="col">Name</th>
				    <th scope="col">Faculties</th>
				   	<th v-if="user&&user.role==='ADMIN'" scope="col">Action</th>    
			 	</tr>
			 </thead>
			  
			 <tbody>
			  	<tr v-for="university in universities":key="university.id">
			  	
			    	<td>{{university.name}}</td>
			     	<td v-if="user"> 
				     	<router-link class="btn btn-outline-dark mb-2 text-white" 
				     	
					     	:to="{path:'/faculties',query:{faculties: facById[university.id]}}" 
					     	
					     	v-if="facById[university.id]">
					     	
					     	<img src="/images/eye2.png" alt="edit" height="25"></a>
					     	
					     	 {{getFaculties(university.id).length}}
				     	
				     	</router-link>
				     	
				     	<span v-else >no fac</span>
			     	</td>
			     	<td v-else >-</td>
			     	
			     	<td v-if="user&&user.role==='ADMIN'">
			     		<a href="#" @click="askToRemove(university)" class="responsible">
			     		<img src="/images/delete2.png"  alt="edit" height="25"></a>
			     		
			     		<a href="#" @click="edit(university)" class="responsible">
						<img src="/images/edit2.png" alt="edit" height="25"></a>
	
			     	</td>	
				</tr>
			</tbody>
		</table>
		
		<modal-window v-if="showModal"
			:popupTitle="'Suppression '+universityToDelete.name"
			:popupBody="$t('questionDelete')+universityToDelete.name+'?'"
			@close="showModal = false" @remove="remove(universityToDelete)">
		</modal-window>
	</div>  
</template>

<script>

    import {mapState,mapActions} from 'vuex' 
   	import modalWindow from '../modal/modalWindow'
    export default { 
    	computed: mapState(['universities','user']),
    	components:{modalWindow},
        data() { 
        	      
            return {    
            
                universityToDelete:"",
            	showModal:false,
                facById:"" 	         
            }
        },
        methods: {	
        
        	...mapActions(['removeUniversityAction']),
        	
        	async getFaculties(id){ 
        		const response=await this.$http.get("/faculty/"+id);
        		return response.data;
        	},
        	remove(university){
        		this.removeUniversityAction(university);
        		this.showModal=false;
        	
        	},
        	askToRemove(university){
        		this.universityToDelete=university;
        		this.showModal=true;
        	
        	},
        	edit(university){
        		this.$router.push(
        				{ path: '/university', query: { university }}
        			)
        	}
	   	},
	   		   		     
        async created(){     	
        	const fac = await this.$http.get("/faculty/map");
        	this.facById = fac.data;	
        }
    }
</script>

<style>
</style>