<template>

   <div>
   
	   <div class="text-center">
	   		<div class="float-right">
	   			<a href="#" @click="setLocale('en')"><img src="/images/en.png" alt="english" height="15" width="20"></a>
				<a href="#" @click="setLocale('fr')"><img src="/images/fr.png" alt="french" height="15" width="20"></a>
				
			</div>
			<h3 class="title">QIService</h3>
	   </div>
	   
	   <nav class="navbar navbar-expand-lg  mb-3 navbar-dark bg-dark">
		  <a class="navbar-brand" href="#"></a>
		  
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  
		  <div class="collapse navbar-collapse text-white" id="navbarText">
		    <ul class="navbar-nav mr-auto ">
		    
		      <li class="nav-item active">   
		        <a class="nav-link" href="#">
		         <span class="sr-only">(current)</span></a>
		      </li>
		      
		      <li class="nav-item">
	 	       <router-link class="nav-link" to="/">
	 	       		<img src="/images/home2.png" alt="edit" height="25"></a>
	 	       </router-link> 
		      </li>
		      
		      <li class="nav-item" v-if="user&&user.role==='ADMIN'" >
	 	       <router-link class="nav-link" to="/users">{{$t('users')}}</router-link> 
		      </li>
		      
		      <li class="nav-item" v-if="user&&user.role==='ADMIN'">
	 	       <router-link class="nav-link" to="/university">{{$t('addUniversity')}}</router-link> 
		      </li>
		      
		       <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
	 	       <router-link class="nav-link" to="/faculty">{{$t('addFaculty')}}</router-link> 
		      </li>
		      
		      <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
	 	       <router-link class="nav-link" to="/program">{{$t('addProgram')}}</router-link> 
		      </li>
		      
		      <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
	 	       <router-link class="nav-link" to="/programCandidat">{{$t('listProgramCandidat')}}</router-link> 
		      </li>
		      
		      
		      <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
	 	      	<router-link class="nav-link" to="/faculties">{{$t('faculties')}}</router-link> 
		      </li>
		      
		      <li class="nav-item" v-if="user&&user.role==='UNIVERSITY'">
	 	      	<router-link class="nav-link" to="/programs">{{$t('programs')}}</router-link> 
		      </li>
		      

		      <li class="nav-item" v-if="user&&user.role==='STUDENT'">
	 	       <router-link class="nav-link" to="/student">PROFILE</router-link> 
		      </li>
	
		      <li class="nav-item" v-if="user&&user.role==='STUDENT'">
	 	       <router-link class="nav-link" to="/search">{{$t('search')}}</router-link> 
		      </li>

		      <li class="nav-item" v-if="user&&user.role==='STUDENT'">
	 	       	<router-link class="nav-link" to="/progSend">{{$t('progSend')}}</router-link> 
		      </li>
		      

		      <li class="nav-item" v-if="user&&user.role!='UNIVERSITY'">
	 	      	<router-link class="nav-link" to="/universities">{{$t('universities')}}</router-link> 
		      </li>
		        
		    </ul>
		    
		  </div>
		  
		  <div v-if="user" class="pull-right text-white">{{user.familyName}} {{user.givenName}} 
			  ({{user.role}}
			  <span v-if="user.role==='UNIVERSITY'">{{user.university.name}}</span>)&nbsp;
			  <a href="/logout">{{$t('logout')}}</a>
		</div>
		<div v-else class="pull-righ text-white">
			  <a href="/login">{{$t('login')}}</a>
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
         methods: {
		     setLocale(locale){
	
				this.$i18n.locale = locale;
			}
          
        },
       
		created(){
			console.log(this.user);
		}
    }
</script>

<style>
</style>
