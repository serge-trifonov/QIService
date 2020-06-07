<template>
<div>


	<div  style="margin-top: 10px;" >
	<img src="/images/banner.jpg" class="img-fluid max-width: 100%;" alt="banner image">
	</div>





	<div v-if="user&&user.currentLevel" class="container">
	
		<div class="row text-center border border-dark" >
			<div class="col-sm border border-dark m-2">
			
				<div class="card" >
					<div class="card-body">
					
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title">Profile</h5>
						<h6 class="card-subtitle">Create edit delete</h6>
						<p class="card-text">Create profile</p>
						
						
						<button type="button" class="btn btn-success">
							CREATE
						</button>	
					</div>	
				</div>
			</div>
				
			<div class="col-sm border border-dark m-2">
				<div class="card">
					<div class="card-body">
					
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title">Check</h5>
						<h6 class="card-subtitle">Check your applications</h6>
						
						<p v-if="applications&&applications.length > 0 "class="card-text">
							You have {{applications.length}} applications</p>
						<p v-else> You don't have 0 application. For find use search</p>
						
						<button type="button" v-if="applications&&applications.length > 0" class="btn btn-primary">
							CHECK  APP
						</button>
						
						<button type="button" v-else class="btn btn-success">
							 SERCH PROGR
						</button>
					</div>
				</div>
			</div>
				
			<div class="col-sm border border-dark m-2">
				<div class="card text">
					<div class="card-body">
					
						<img class="card-img-top" src="/images/image1.jpg" alt="card img">
						<h5 class="card-title">Search</h5>
						<h6 class="card-subtitle">Search program</h6>
						<p class="card-text">Find your program</p>
						
						<button type="button" class="btn btn-success">
							SEARCH
						</button>
					</div>	
				</div>
			</div>
			
		</div>		
	</div>	
	
	
						<div v-else>
							<div class="container">
								
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

        	console.log(this.user);
        	console.log(this.user.currentLevel);
        		
        }
    }
</script>

 <style>
	
</style>