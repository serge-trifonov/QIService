<template>
<div class="container">
	<div class="row">
		<div class="col-sm">
			<div class="card">
				<div class="card-body">   
					<h5 class="card-title text-center">{{$t('address')}}</h5>  
					 
					<form action="">
						<div class="form-group row">
							<label for="inputNumber" class="col-sm-2 col-form-label">{{$t('number')}}</label>
								<div class="col-sm-10"><input type="number" 
									  class="form-control" 
									   id="number" placeholder="123" 
									   @change="updateAddress" 
									   v-model="address.number">
								</div>
						</div>
							    
						<div class="form-group row">
							<label for="inputStreet" class="col-sm-2 col-form-label">{{$t('street')}}</label>
								<div class="col-sm-10"> <input type="text" 
									 class="form-control" 
									  id="inputStreet" 
									  placeholder="Main steet" 
									  @change="updateAddress" 
									  v-model="address.street">
								 </div>
						</div>
							 
						<div class="form-group row">
							<label for="inputPost" class="col-sm-2 col-form-label">{{$t('zipCode')}}</label>
								<div class="col-sm-10"><input type="text" 
									class="form-control" 
									id="inputPost" 
									placeholder="123456" 
									@change="updateAddress" 
									v-model="address.postalAddress">
								</div>
						</div>
							  
						<div class="form-group row">
							<label for="city" class="col-sm-2 col-form-label">{{$t('city')}}</label>
								<div class="col-sm-10"><input type="text" 
									class="form-control" 
									id="city" 
									placeholder="London" 
									@change="updateAddress" 
									v-model="address.city">
								</div>
						</div>
							  
						<div class="form-group row">
							<label for="inputState" class="col-sm-2 col-form-label">{{$t('country')}}</label>
								<div class="col-sm-10">
									<select id="inputCountry" class="form-control" 
										 @change="updateAddress" 
										  v-model="address.country">
										     		
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
						</div>
					</form>	
					
				</div>		
			</div>		
		</div>		
	</div>		
</div>		
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
            }
        },
        created(){
        
        	this.address=this.parentAddress;
	        }   	
        }  
</script>

