<template>
   <div>
   <div class="text-center">
	<h3 class="title">QIService</h3>
   </div>
    <nav class="navbar navbar-expand-lg  mb-3 navbar-dark bg-dark">
	  <a class="navbar-brand" href="#">Navbar w/ text</a>
	  
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  
	  <div class="collapse navbar-collapse" id="navbarText">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
	      </li>
	      
	      <li class="nav-item">
 	       <router-link class="nav-link" to="university">Ajouter un université</router-link> 
	      </li>
	      
	       <li class="nav-item">
 	       <router-link class="nav-link" to="faculty">Ajouter un faculté</router-link> 
	      </li>
	      
	      <li class="nav-item">
 	       <router-link class="nav-link" to="program">Ajouter un programme</router-link> 
	      </li>
	      
	      <li class="nav-item">
 	       <router-link class="nav-link" to="student">Ajouter un student</router-link> 
	      </li>
	      
	      
	      
	      
	      <li class="nav-item">
 	       <router-link class="nav-link" to="search">Search</router-link> 
	      </li>
	      
	      
	      
	      <li class="nav-item">
 	       <router-link class="nav-link" to="programs">Programs</router-link> 
	      </li>
	      
	      <li class="nav-item">
 	       <router-link class="nav-link" to="users">Users</router-link> 
	      </li>
	      

	      <li class="nav-item">
	        <a class="nav-link" href="#">Pricing</a>
	      </li>
	    </ul>
	    <span class="navbar-text">
	      Navbar text with an inline element
 	   </span>
	  </div>
	</nav>
	
	<router-view></router-view>
   </div>
</template>

<script>
	import {mapState} from 'vuex'
    export default {
    
        data() {
            return {
            	//prog:programs,
              //  messages: []
                //profile: frontendData.profile
            }
        },
	created(){
		console.log("created!!!!");
	}
    }
</script>

<style>
</style>
