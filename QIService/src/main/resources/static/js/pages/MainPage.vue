<template>
<div class="container">

	<div  style="margin: 5px;" >
		<img src="/images/banner6.jpg" class="img-fluid" alt="banner image">
	</div>
	
	<div class="row border border-dark m-2">
		<div v-if="user&&user.currentLevel" class="col-sm border border-dark m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
			 	
				<div class="card-body">
					<img class="card-img-top" src="/images/image3.png" height="140"alt="profile img">
					<h5 class="card-title">PROFILE</h5>
					<p class="card-text">Edit delete</p>	
					<router-link class="nav-link" to="/student">
						<button type="button" class="btn btn-success  btn-block">EDIT</button>
					</router-link>	
				</div>	
			</div>
		</div>
				
		<div v-if="user&&user.currentLevel&&applications&&applications.length>0 "class="col-sm border border-dark m-2">
			<div class="card text-center text-white bg-secondary" style="max-width: 15rem;">
			 	
				<div class="card-body">				
					<img class="card-img-top" src="/images/applications.jpg" height="140" alt="applications img">
					<h5 class="card-title">APPLICATIONS</h5>
									
					<p class="card-text">{{applications.length}} applications</p>							
					<router-link class="nav-link" to="/progSend">
						<button type="button" class="btn btn-success btn-block">CHECK </button>
					</router-link>	
				</div>
			</div>
		</div>
				
		<div v-if="user&&user.currentLevel" class="col-sm border border-dark m-2">
			<div class="card text text-center bg-secondary text-white"style="max-width: 15rem;">

				<div class="card-body">				
					<img class="card-img-top" src="/images/search.jpeg" height="140" alt="search img">
					<h5 class="card-title">SEARCH</h5>
						
					<p class="card-text">Find send</p>
					<router-link class="nav-link" to="/search">
						<button type="button" class="btn btn-success btn-block">SEARCH</button>
					</router-link>	
				</div>	
			</div>
		</div>	
			
		
	
	<span v-if="user&&user.role==='STUDENT'&&!user.currentLevel" >
		<div class="card">
			<h3 class="card-title text-center">YOU SHOUND CREATE PROFILE</h3>
			<p class="card-text"> <router-link class="nav-link" to="/student">create</router-link></p>	
		</div>	
	</span>	
	
	
	
	
		
		<div v-if="user&&user.role==='UNIVERSITY'" class="col-sm border border-dark m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/faculty.jpg" height="140" alt="faculty img">
					<h5 class="card-title">FACULTY</h5>
					<p class="card-text">ADD EDIT DELETE</p>
					<router-link class="nav-link" to="/faculty">
						<button type="button" class="btn btn-success  btn-block">ADD</button>
					</router-link>	
				</div>		
			</div>	
		</div>
			
		<div v-if="user&&user.role==='UNIVERSITY'" class="col-sm border border-dark m-2">		
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/program.jpg" height="140" alt="program img">
					<h5 class="card-title">PROGRAM</h5>
					<p class="card-text">ADD EDIT DELETE</p>
					<router-link class="nav-link" to="/program">
						<button type="button" class="btn btn-success  btn-block">ADD</button>
					</router-link>	
				</div>		
			</div>	
		</div>
			
		<div v-if="user&&user.role==='UNIVERSITY'" class="col-sm border border-dark m-2">		
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/candidat.jpg" height="140" alt="candidat img">
					<h5 class="card-title">CANDIDATES</h5>
					<p class="card-text">ADMIT REFUSE</p>
					<router-link class="nav-link" to="/programCandidat">
						<button type="button" class="btn btn-success  btn-block">SEE</button>
					</router-link>	
				</div>		
			</div>	
		</div>
			
		<div v-if="user&&user.role==='UNIVERSITY'" class="col-sm border border-dark m-2">		
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/faculties.jpg" height="140" alt="card img">
					<h5 class="card-title">FACULTIES</h5>
					<p class="card-text">LIST PROGRAMS</p>
					<router-link class="nav-link" to="/faculties">
						<button type="button" class="btn btn-success  btn-block">SEE</button>
					</router-link>	
				</div>		
			</div>	
		</div>
	
		
		
	
		<div v-if="user&&user.role==='ADMIN'" class="col-sm border border-dark m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/users1.png" height="140" alt="card img">
					<h5 class="card-title">USERS</h5>
					<h6 class="card-subtitle"></h6>
					<p class="card-text">EDIT DELETE</p>
					<router-link class="nav-link" to="/users">
						<button type="button" class="btn btn-success  btn-block">EDIT</button>
					</router-link>	
				</div>		
			</div>	
		</div>
			
		<div v-if="user&&user.role==='ADMIN'" class="col-sm border border-dark m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/universityAdd.jpg" height="140" alt="card img">
					<h5 class="card-title">UNIVERSITY</h5>
					<p class="card-text">ADD</p>
					<router-link class="nav-link" to="/university">
						<button type="button" class="btn btn-success  btn-block">ADD</button>
					</router-link>	
				</div>		
			</div>	
		</div>		
	
		<div v-if="!user||user.role!=='UNIVERSITY'"class="col-sm border border-dark m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
				
					<img class="card-img-top" src="/images/university2.jpg" height="140" alt="card img">
					
					<h5 class="card-title">UNIVERSITIES</h5>
					
					<p v-if="user&&user.role==='ADMIN'"class="card-text">EDIT DELETE SEE</p>
					
					
					<p v-else class="card-text">SEE</p>
					
					<router-link class="nav-link" to="/universities">
						<button type="button" class="btn btn-success  btn-block">EDIT</button>
					</router-link>	
				</div>		
			</div>	
		</div>
	</div>
												
</div> 	
</template>

<script>
    import {mapState} from 'vuex'
     
    export default {
    	computed: mapState(['user','applications']),
    	
        data() {
        	return{
        	
        	}                   
        },
        
        methods: {
	        	submit(event){
					event.preventDefault();
	
	        }	
	   	},
        async created(){

		
        }
    }
</script>

 <style>
	
</style>