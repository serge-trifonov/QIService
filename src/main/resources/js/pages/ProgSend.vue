<template>
	<div>
		<h2>{{$t('candidate')}} {{user.givenName}} {{user.familyName}}</h2>
			<table class="table table-dark">
			
		  		<thead>
		    		<tr> 
				      <th scope="col">{{$t('prog')}}</th>
				      <th scope="col">{{$t('status')}}</th>
				      <th scope="col">Action</th>
		    		</tr>
		  		</thead>
		   
		  	<tbody>
			    <tr v-for="app in applications" :key="app.id">
			     
			   		<td scope="row">{{app.program.name}}</td>
			    	<td scope="row">{{app.response}}</td>
			    	<td scope="row">
			    		<a href="#" @click="askToRemove(app)">
		     			<img src="/images/delete2.png"  alt="edit" height="25"></a>
			    	</td>
				</tr>
		    </tbody>
	    
		</table>
		
		<modal-window v-if="showModal"
			:popupTitle="'Suppression '+applicationToDelete.program.name"
			:popupBody="$t('questionDelete')+applicationToDelete.program.name+'?'"
			@close="showModal = false" @remove="remove(applicationToDelete)">
		</modal-window>
		
	</div>
</template>

<script>
    import {mapState,mapActions} from 'vuex'
    import modalWindow from '../modal/modalWindow'
  
    export default {
   		computed: mapState(['applications','user']),
   		components:{modalWindow},
   		data() { 
        	      
            return {    
                applicationToDelete:"",
            	showModal:false,         
            }
        },
   		 methods: {	
 
        	...mapActions(['removeApplicationAction']),
 
        	async remove(application){
        		this.removeApplicationAction(application);
        		this.showModal=false;
        		
        	},
        	askToRemove(application){
        		this.applicationToDelete=application;
        		this.showModal=true;     	
        	}	
	   	} 
	}  
			    
</script>

<style>
</style>