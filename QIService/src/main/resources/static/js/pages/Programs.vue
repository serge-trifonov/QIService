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
			    <tr v-for="program in allprograms" :key="program.id" >
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
	    computed: mapState(['allprograms']),
	    
	        data() {
	            return {	
	            	programs:""
	            }
	        },
		async created(){
			this.programs = this.$route.query.faculties;
		}
    }
</script>

<style>
</style>
