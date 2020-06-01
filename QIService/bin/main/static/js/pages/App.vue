<template>
   <div>
   <div class="text-center">
	<h3 class="title">QIService</h3>
   </div>
    <nav class="navbar navbar-expand-lg  mb-3 navbar-dark bg-dark">
	  <a class="navbar-brand" href="#">MENU</a>
	  
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  
	  <div class="collapse navbar-collapse" id="navbarText">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
	      </li>
	      
	      <li class="nav-item">
 	       <router-link class="nav-link" to="mainPage">{{$t('mainPage')}}</router-link> 
	      </li>
	      
	      
	      
	      <li class="nav-item" v-if="user&&user.role==='ADMIN'">
 	       <router-link class="nav-link" to="university">{{$t('addUniversity')}}</router-link> 
	      </li>
	      
	      <li class="nav-item" v-if="user&&user.role==='ADMIN'">
 	       <router-link class="nav-link" to="users">{{$t('users')}}</router-link> 
	      </li>
	      
	      
	      
	       <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
 	       <router-link class="nav-link" to="faculty">{{$t('addFaculty')}}</router-link> 
	      </li>
	      
	      <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
 	       <router-link class="nav-link" to="program">{{$t('addProgram')}}</router-link> 
	      </li>
	      
	      <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
 	       <router-link class="nav-link" to="programCandidat">{{$t('programCandidat')}}</router-link> 
	      </li>
	      
	      <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
 	       <router-link class="nav-link" to="candidats">{{$t('candidats')}}</router-link> 
	      </li>
	      
	      
	      
	      
	      
	      
	      <li class="nav-item" v-if="user&&user.role==='STUDENT'">
 	       <router-link class="nav-link" to="student">Student Register </router-link> 
	      </li>

	      <li class="nav-item" v-if="user&&user.role==='STUDENT'">
 	       <router-link class="nav-link" to="search">Search</router-link> 
	      </li>
	      

	      <li class="nav-item" v-if="user&&user.role==='STUDENT'">
 	       <router-link class="nav-link" to="programs">List all programs</router-link> 
	      </li>
	      
	      <li class="nav-item" v-if="user&&user.role==='STUDENT'">
 	       <router-link class="nav-link" to="progSend">ProgSend</router-link> 
	      </li>
	      
	      

	      
	    </ul>
	    
	  </div>
	</nav>
	
	<router-view></router-view>
   </div>
</template>

<script>
	import {mapState} from 'vuex'
    export default {
    
    computed: mapState(['user']),
    
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
