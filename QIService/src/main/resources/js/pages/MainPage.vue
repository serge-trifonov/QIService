<template>
<div class="container">

	<div  style="margin: 5px;" >
		<img src="/images/banner6.jpg" class="img-fluid" alt="banner image">
	</div>
	
	<div class="row m-2">
		<div v-if="user&&user.currentLevel" class="col-sm m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
			 	
				<div class="card-body">
					<img class="card-img-top" src="/images/image3.png" height="140"alt="profile img">
					<h5 class="card-title">{{$t('profile')}}</h5>
					<p class="card-text">{{$t('edit')}}</p>	
					<router-link class="nav-link" to="/student">
						<button type="button" class="btn btn-success  btn-block">{{$t('edit')}}</button>
					</router-link>	
				</div>	
			</div>
		</div>
				
		<div v-if="user&&user.currentLevel&&applications&&applications.length>0 "class="col-sm m-2">
			<div class="card text-center text-white bg-secondary" style="max-width: 15rem;">
			 	
				<div class="card-body">				
					<img class="card-img-top" src="/images/applications.jpg" height="140" alt="applications img">
					<h5 class="card-title">{{$t('progSend')}}</h5>
									
					<p class="card-text"> {{$t('quantity')}} : {{applications.length}}</p>							
					<router-link class="nav-link" to="/progSend">
						<button type="button" class="btn btn-success btn-block">{{$t('check')}} </button>
					</router-link>	
				</div>
			</div>
		</div>
				
		<div v-if="user&&user.currentLevel" class="col-sm m-2">
			<div class="card text text-center bg-secondary text-white"style="max-width: 15rem;">

				<div class="card-body">				
					<img class="card-img-top" src="/images/search.jpeg" height="140" alt="search img">
					<h5 class="card-title">{{$t('search')}}</h5>
						
					<p class="card-text">{{$t('find')}}</p>
					<router-link class="nav-link" to="/search">
						<button type="button" class="btn btn-success btn-block">{{$t('searchAction')}}</button>
					</router-link>	
				</div>	
			</div>
		</div>	
			
		<span v-if="user&&user.role==='STUDENT'&&!user.currentLevel" >
			<div class="card">
				<h3 class="card-title text-center">{{$t('createProfile')}}</h3>
				<p class="card-text"> <router-link class="nav-link" to="/student">create</router-link></p>	
			</div>	
		</span>	
	
		<div v-if="user&&user.role==='UNIVERSITY'" class="col-sm m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/faculty.jpg" height="140" alt="faculty img">
					<h5 class="card-title">{{$t('faculty')}}</h5>
					<p class="card-text">{{$t('add')}}</p>
					<router-link class="nav-link" to="/faculty">
						<button type="button" class="btn btn-success  btn-block">{{$t('add')}}</button>
					</router-link>	
				</div>		
			</div>	
		</div>
			
		<div v-if="user&&user.role==='UNIVERSITY'" class="col-sm m-2">		
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/program.jpg" height="140" alt="program img">
					<h5 class="card-title">{{$t('program')}}</h5>
					<p class="card-text">{{$t('add')}}</p>
					<router-link class="nav-link" to="/program">
						<button type="button" class="btn btn-success  btn-block">{{$t('add')}}</button>
					</router-link>	
				</div>		
			</div>	
		</div>
			
		<div v-if="user&&user.role==='UNIVERSITY'" class="col-sm m-2">		
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/candidat.jpg" height="140" alt="candidat img">
					<h5 class="card-title">{{$t('candidates')}}</h5>
					<p class="card-text">{{$t('admit')}} {{$t('refus')}}</p>
					<router-link class="nav-link" to="/programCandidat">
						<button type="button" class="btn btn-success  btn-block">{{$t('edit')}}</button>
					</router-link>	
				</div>		
			</div>	
		</div>
			
		<div v-if="user&&user.role==='UNIVERSITY'" class="col-sm m-2">		
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/faculties.jpg" height="140" alt="card img">
					<h5 class="card-title">{{$t('faculties')}}</h5>
					<p class="card-text">{{$t('programs')}}</p>
					<router-link class="nav-link" to="/faculties">
						<button type="button" class="btn btn-success  btn-block">{{$t('edit')}}</button>
					</router-link>	
				</div>		
			</div>	
		</div>
	
		<div v-if="user&&user.role==='ADMIN'" class="col-sm m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/users1.png" height="140" alt="card img">
					<h5 class="card-title">{{$t('users')}}</h5>
					<h6 class="card-subtitle"></h6>
					<p class="card-text">{{$t('edit')}}</p>
					<router-link class="nav-link" to="/users">
						<button type="button" class="btn btn-success  btn-block">{{$t('edit')}}</button>
					</router-link>	
				</div>		
			</div>	
		</div>
			
		<div v-if="user&&user.role==='ADMIN'" class="col-sm m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
					<img class="card-img-top" src="/images/universityAdd.jpg" height="140" alt="card img">
					<h5 class="card-title">{{$t('university')}}</h5>
					<p class="card-text">{{$t('add')}}</p>
					<router-link class="nav-link" to="/university">
						<button type="button" class="btn btn-success  btn-block">{{$t('add')}}</button>
					</router-link>	
				</div>		
			</div>	
		</div>		
	
		<div v-if="!user||user.role!=='UNIVERSITY'"class="col-sm m-2">
			<div class="card text-center text-white bg-secondary"style="max-width: 15rem;">
				<div class="card-body">
				
					<img class="card-img-top" src="/images/university2.jpg" height="140" alt="card img">
					
					<h5 class="card-title">{{$t('universities')}}</h5>
					
					<p v-if="user&&user.role==='ADMIN'"class="card-text">{{$t('edit')}}</p>
					
					
					<p v-else class="card-text">{{$t('see')}}</p>
					
					<router-link class="nav-link" to="/universities">
						<button v-if="user&&user.role==='ADMIN'"type="button" class="btn btn-success  btn-block">{{$t('edit')}}</button>
						<button v-else type="button" class="btn btn-success  btn-block">{{$t('see')}}</button>
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