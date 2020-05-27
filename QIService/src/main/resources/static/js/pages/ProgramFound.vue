<template>
   <div style="width: 95%;" class="mx-auto shadow p-3 mb-5 bg-dark rounded text-light" >
   
    	<div class="alert alert-warning alert-dismissible fade show" role="alert">
  			<strong> Hello future student</strong> Program for you below.
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    			<span aria-hidden="true">&times;</span>
 			 </button>
		</div>
		
		<h2>Description of the program </h2>
			
				<div>
					<h2>{{program.name}}</h2>
				</div>
				
				<div>
					<p>Duration: {{program.duration}}</p>
				</div>
				
				<div>
					<p>Level: {{program.level}}</p>	
				</div>
				
				
				<div>
		
					<p>Responsable: {{program.userUniv}}</p>
		
				</div>
				
				<div>
				
					<p>Faculty: {{faculty.name}}</p>
				
				</div>
			
			
		
		
		
		
		<div>
		
			<p>Address:</p>
		
		</div>
		
		
		
		
			
		<div>
		<label for="message">Send your message here:</label>
			<textarea id="message" name="message" rows="5" cols="33">
				Hello!...
       		</textarea>
		
		</div>
		
		
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit">RETURN</button>
			</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary" @click.stop="submit">SEND</button>
			</div>
		</div>
	
   </div>
   

   
   
   		
</template> 


<script>
    
       	
    	export default {
    	
        data() {
            return {
            	faculty:{
            		name:""
            	},
            	 program:{
                
	                name:"",
	                duration:"",
                	level:"",
                	userUniv:"",
                	faculty:""
                	
                	
                }  		
 			}
        },
        methods:{
        	submit(event){
        		event.preventDefault();
        	}
        },
       async created(){
        	this.program=await this.$http.get("/program/"+this.$route.params.id);
        	this.program = this.program.data;
        	
        	this.faculty=await this.$http.get("/faculty/"+this.$route.params.id);
        	this.faculty = this.faculty.data;
        	
        	
        
        }
       
    }
      
    
</script>