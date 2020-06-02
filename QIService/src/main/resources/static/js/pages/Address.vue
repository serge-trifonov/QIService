<template>
       
	<form>
	
	  	<div class="form-group col-md-6">
		     <label for="inputNumber">{{$t('number')}}</label>
		     <input type="number" class="form-control" id="number" placeholder="123" @change="updateAddress" v-model="address.number">
		 </div>
	    
		 <div class="form-group col-md-6">
		     <label for="inputStreet">{{$t('street')}}</label>
		     <input type="text" class="form-control" id="inputStreet" placeholder="Main steet" @change="updateAddress" v-model="address.street">
		 </div>
	 
		<div class="form-group col-md-6">
			<label for="inputPost">{{$t('zipCode')}}</label>
			<input type="text" class="form-control" id="inputPost" placeholder="123456" @change="updateAddress" v-model="address.postalAddress">
		</div>
	  
		<div class="form-group col-md-6">
			 <label for="city">{{$t('city')}}</label>
			  <input type="text" class="form-control" id="city" placeholder="London" @change="updateAddress" v-model="address.city">
		</div>
	  
	    <div class="form-group col-md-4">
	      	<label for="inputState">{{$t('country')}}</label>
	      	
			     <select id="inputCountry" class="form-control" @change="updateAddress" v-model="address.country">
			        <option selected>{{$t('choice')}}</option>
			        <option value="espagne">Espagne</option>
			        <option value="chine">Chine</option>
			        <option value="japon">Japon</option>
			        <option value="canada">Canada</option>
			        <option value="france">France</option>
			        <option value="maroc">Maroc</option>
			        <option value="russia">Russia</option>
			      </select>
	    </div>
  		
	</form> 
		
</template>


<script>
    import { mapActions } from 'vuex'
    
    export default {
    	name:'Address',
    	props: ['parentAddress'],
        data() {
            return {
                address:""
            }
        },
        methods: {
	    ...mapActions(['addressAction']),
            updateAddress(event) {
            	
            	event.preventDefault();
				console.log(this.address);
            	
            }
        },
        created(){
        
        	this.address=this.parentAddress;
	        }
	        	
        }
    
    
</script>

