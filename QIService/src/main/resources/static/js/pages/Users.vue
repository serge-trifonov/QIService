
<template>

<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">N</th>
      <th scope="col">User</th>
      <th scope="col">Role</th>
      <th scope="col">Email</th>
      <th scope="col">University_Id</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  
  <tbody>
    <tr v-for="(user,index) in users">
      <th scope="row">{{index+1}}</th>
      <td>{{user.givenName}} {{user.familyName}}</td>
      <td v-if="user.id!=idToEdit">{{user.role}}</td>
      
      <td v-else ><select class="form-control" @change="changeRole(user)" id="level" v-model="user.role">
      				<option value="UNIVERSITY">UNIVERSITY</option>
					<option value="STUDENT">STUDENT</option>
					<option value="ADMIN">ADMIN</option>
				</select></td>
      <td>{{user.email}}</td>
      
      
      
      <td><div v-if="user.id===idToEdit&&user.role==='UNIVERSITY'">
      		<select class="form-control" id="level" v-model="user.universityId">
				<option v-for="univ in universities" :key="univ.id" :value="univ.id" >{{univ.name}}</option>
			</select></div>
      <td><a href="#" v-if="user.id!=idToEdit" @click.stop="edit(user.id)" class="img-btn"><img src="/images/edit.png" alt="edit" height="25"></a>
      <button v-else class="btn btn-outline-light mt-3" @click.stop="submit(user)"> Valider </button>
      </td>
    </tr>
  </tbody>
</table>
   
</template>

<script>
    import { mapActions } from 'vuex'
    export default {
        data() {
            return {
            	universities:[],
            	selectUniversity:false,
                users:[],
                idToEdit:''
               		
					
               
            }
        },
        methods: {
        	...mapActions(['updateUserAction','updateUserUnivAction']),
	   		edit(id){
	   			this.idToEdit=id;	
	   		},
	   		
	   		submit(user){
	   			if(user.role==='UNIVERSITY'){
	   				this.updateUserUnivAction(user);
	   			}
	   			else{
	   				this.updateUserAction(user);
	   			}

	   			this.idToEdit="";
	   			this.selectUniversity=false;
	   			
	   		},
	   		async changeRole(user){
	   			console.log(user.role);
	   			if(user.role==='UNIVERSITY'){	   	
	   					
		   			
					console.log(user);
		   			this.selectUniversity=true;
		   			
		   			
	   			}	   			
	   		}
        },
        
        async created(){
        
        	const response = await this.$http.get("/university");	   			
			this.universities = await response.json();
        	
			const result = await this.$http.get("/users");
			this.users = result.data
			console.log(result);
        }
    }
</script>

<style>
</style>