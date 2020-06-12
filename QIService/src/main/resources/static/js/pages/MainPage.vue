<template>
<div>

	<div  style="margin: 5px;" >
		<img src="/images/banner6.jpg" class="img-fluid" alt="banner image">
	</div>

	<div>{{user.role}}</div>

	<div v-if="user&&user.currentLevel" class="container">
	
		<div class="row  border border-dark" >
			<div class="col-sm-3 border border-dark m-2">
				<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				 <div class="card-header">PROFILE</div>
					<div class="card-body">
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title"></h5>
						<h6 class="card-subtitle"></h6>
						<p class="card-text">Edit delete</p>
						
						<router-link class="nav-link" to="/student">
							<button type="button" class="btn btn-success  btn-block">EDIT</button>
						</router-link>	
					</div>	
				</div>
			</div>
				
			<div v-if="applications&&applications.length>0 "class="col-sm-3 border border-dark m-2">
			
				<div class="card text-center text-white bg-secondary" style="max-width: 15rem;">
				 <div class="card-header">APPLICATIONS</div>
					<div class="card-body">				
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title"></h5>
						<h6 class="card-subtitle"></h6>					
						<p class="card-text">{{applications.length}} applications</p>							
						<router-link class="nav-link" to="/progSend">
							<button type="button" class="btn btn-success btn-block">CHECK </button>
						</router-link>
						
					</div>
				</div>
			</div>
				
			<div class="col-sm-3 border border-dark m-2">
				<div class="card text text-center bg-secondary text-white"style="max-width: 15rem;">
				 <div class="card-header">SEARCH</div>
					<div class="card-body">				
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title"></h5>
						<h6 class="card-subtitle"></h6>
						<p class="card-text">Find  program</p>
						<router-link class="nav-link" to="/search">
							<button type="button" class="btn btn-success btn-block">SEARCH</button>
						</router-link>	
					</div>	
				</div>
			</div>
			
		</div>		
	</div>	
	
	
	<div v-if="user&&user.role==='STUDENT'&&!user.currentLevel" class="card">
		<h3 class="card-title text-center">YOU SHOUND CREATE PROFILE</h3>
		<p class="card-text"> <router-link class="nav-link" to="/student">create</router-link></p>	
	</div>	
	
	
	<div v-if="user&&user.role==='UNIVERSITY'" class="container">
	
		<div class="row  border border-dark">
			<div class="col-sm-3 border border-dark m-2">
				
				<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-header">ADD</div>
					<div class="card-body">
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title"></h5>
						<h6 class="card-subtitle"></h6>
						<p class="card-text">Faculty</p>
						
						<router-link class="nav-link" to="/faculty">
							<button type="button" class="btn btn-success  btn-block">ADD</button>
						</router-link>	
					</div>		
				</div>	
			</div>
			
			<div class="col-sm-3 border border-dark m-2">		
				<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-header">ADD</div>
					<div class="card-body">
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title"></h5>
						<h6 class="card-subtitle"></h6>
						<p class="card-text">Program</p>
						
						<router-link class="nav-link" to="/program">
							<button type="button" class="btn btn-success  btn-block">ADD</button>
						</router-link>	
					</div>		
				</div>	
			</div>
			
			<div class="col-sm-3 border border-dark m-2">		
				<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-header">CANDIDATS</div>
					<div class="card-body">
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title"></h5>
						<h6 class="card-subtitle"></h6>
						<p class="card-text">Program-Candidat</p>
						
						<router-link class="nav-link" to="/programCandidat">
							<button type="button" class="btn btn-success  btn-block">ADD</button>
						</router-link>	
					</div>		
				</div>	
			</div>
			
	</div>
	
		
	
	
	
	
	</div>	
	
				
	<div v-if="user&&user.role==='ADMIN'" class="container"><p>hello admin</p>
		<div></div>
		
	
	
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

        	console.log(this.user);
        	console.log(this.user.currentLevel);
        	
        		
        }
    }
</script>

 <style>
	
</style>