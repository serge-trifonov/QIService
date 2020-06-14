<template>
   <div>
	   	<table class="table table-striped">
	   	
		  	<thead>
				<tr>
					<th scope="col">{{$t('prog')}}</th>
					<th scope="col">{{$t('university')}}</th>
					<th scope="col">{{$t('duration')}}</th>
					<th scope="col">{{$t('level')}}</th>
				</tr>
		  	</thead>
		  	
	  		<tbody>
			    <tr v-for="program in programsToShow" :key="program.id" >
			      <td scope="row">{{program.name}}</td>
			      <td>{{program.faculty?program.faculty.university.name:'-'}}</td>
			      <td>{{program.duration}}</td>
			      <td>{{program.level}}</td>
			    </tr>   
	  		</tbody>
		</table>
   </div>
</template>

<script>
	import {mapState} from 'vuex'
    export default {
    
	    computed: mapState(['programs']),
	    
	        data() {
	            return {	
	            	programsToShow:""
	            }
	        },
		async created(){
			if(this.$route.query.programs){
				this.programsToShow = this.$route.query.programs;
			}
			else{
				this.programsToShow=this.programs;
			}
		}
    }
</script>

<style>
</style>
