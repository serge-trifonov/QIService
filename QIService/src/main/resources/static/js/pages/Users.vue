
<template>

<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">N</th>
      <th scope="col">User</th>
      <th scope="col">Role</th>
      <th scope="col">Email</th>
      <th scope="col">qis</th>
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="(user,index) in users">
      <th scope="row">{{index+1}}</th>
      <td>{{user.givenName}} {{user.familyName}}</td>
      <td v-if="user.id!=idToEdit">{{user.role}}</td>
      <td v-else ><select class="form-control" id="level" v-model="user.role">
      				<option value="UNIVERSITY">UNIVERSITY</option>
					<option value="STUDENT">STUDENT</option>
					<option value="ADMIN">ADMIN</option>
				</select></td>
      <td>{{user.email}}</td>
      <td>{{user.qis}}</td>
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
                users:[],
                idToEdit:''
               		
					
               
            }
        },
        methods: {
        	...mapActions(['updateUserAction']),
	   		edit(id){
	   			this.idToEdit=id;	
	   		},
	   		submit(user){
	   			this.updateUserAction(user);
	   			this.idToEdit="";
	   		}
        },
        async created(){
        	
			const result = await this.$http.get("/users");
			this.users = result.data
			console.log(result);
        }
    }
</script>

<style>
</style>