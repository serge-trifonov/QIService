<template>
	<div>
		<div v-if="user&&user.currentLevel" class="container text-center">
			<div class="row">
				<div class="col-sm">
				
					<div class="card text-center" style="width:18rem;">
						<div class="card-body" length:>
						
							<img class="card-img-top" src="/images/image1.jpg" alt="card img">
							<h5 class="card-title">Profile</h5>
							<h6 class="card-subtitle">Create edit profile</h6>
							<p class="card-text">Create profile</p>
							<p class="card-text">Edit profile</p>
							<p class="card-text">Delete profile</p>
							
							<button type="button" class="btn btn-success">
								CREATE
							</button>	
						</div>	
					</div>
				</div>
				
				<div class="col-sm">
					<div class="card text-center" style="width:18rem;">
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
				
				<div class="col-sm">
					<div class="card text-center" style="width:18rem;">
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

        	console.log("main page");
        		
        }
    }
</script>

 <style>
	
</style>