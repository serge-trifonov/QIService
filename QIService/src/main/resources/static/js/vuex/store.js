import Vue from 'vue'
import Vuex from 'vuex'
import programApi from 'api/program'
import studentApi from 'api/student'
import universityApi from 'api/university'
import userApi from 'api/user'
import userUnivApi from 'api/userUniv'
import facultyApi from 'api/faculty'
import addressApi from 'api/address'
import applicationApi from 'api/app'

Vue.use(Vuex)

export default new Vuex.Store({
   
	state: {
		allprograms: programs,
		user: userInfo.user,
		faculties:[],
		programs: userInfo.userProgram,
		studByProg: userInfo.mapProgStud,
		reponseByStud: userInfo.reponseByStud,
		applications: userInfo.applications,
		universities:userInfo.universities
				
	},
	mutations:{
		
		addProgMutation(state, prog) {
			state.allprograms = [...state.allprograms,prog];
			state.programs = [...state.programs,prog]	
		},
		addUniversityMutation(state,university){	
			state.universities = [...state.universities,university];
		},
		addFacultyMutation(state,faculty){	
			state.faculties = [...state.faculties,faculty];
		},				
		addApplicationMutation(state,application){	
			state.applications = [...state.applications,application];
		},
			
		updateProgMutation(state, prog) {
						
			let updateIndex = state.allprograms.findIndex(item => item.id === prog.id);
			state.allprograms = [...state.allprograms.slice(0, updateIndex),prog,...state.allprograms.slice(updateIndex + 1)];
			updateIndex = state.programs.findIndex(item => item.id === prog.id)
			state.programs = [...state.programs.slice(0, updateIndex),prog,...state.programs.slice(updateIndex + 1)]
		},
		
		updateUniversityMutation(state, university) {
			
			const updateIndex = state.universities.findIndex(item => item.id === university.id)
			state.universities = [...state.universities.slice(0, updateIndex),university,
				...state.universities.slice(updateIndex + 1)]
			},
			
		removeProgMutation(state, prog) {
					
			let deletionIndex = state.allprograms.findIndex(item => item.id === prog.id);

			if (deletionIndex > -1) {
				state.allprograms = [...state.allprograms.slice(0, deletionIndex),...state.allprograms.slice(deletionIndex + 1)];				
			}
			deletionIndex = state.programs.findIndex(item => item.id === prog.id)
			
			if (deletionIndex > -1) {
				state.programs = [...state.programs.slice(0, deletionIndex),...state.programs.slice(deletionIndex + 1)]
			}
		},
		
		removeUniversityMutation(state, university) {
			let deletionIndex = state.universities.findIndex(item => item.id === university.id);

			if (deletionIndex > -1) {
				state.universities = [...state.universities.slice(0, deletionIndex),...state.universities.slice(deletionIndex + 1)]
			}
		},
		
		removeApplicationMutation(state, application) {
			let deletionIndex = state.applications.findIndex(item => item.id === application.id);
			
			if (deletionIndex > -1) {
				state.applications = [...state.applications.slice(0, deletionIndex),...state.applications.slice(deletionIndex + 1)]
			}
		}		
	},
		
    actions: {
    	
        async addProgramAction({commit}, program) {
            const result = await programApi.add(program)
            const data = await result.json()
            commit('addProgMutation', data)
        }, 
        
        async addStudentAction({commit}, student) {
            const result = await studentApi.add(student)
            const data = await result.json()
        },
       
        async addApplicationAction({commit}, application) {
        	const result = await applicationApi.add(application)
        	const data = await result.json()
        	commit('addApplicationMutation', data)
        }, 
     
        async updateApplicationAction({commit}, application) {
	    	const result = await applicationApi.update(application)
	    	const data = await result.json()	
	    },
	    
	    async removeApplicationAction({commit},application){
	    	const result = await applicationApi.remove(application.id)
	    	if (result.ok) {
	    		commit('removeApplicationMutation', application)
	    	}
	    },
        
        async addUniversityAction({commit}, university) {      	
	    	const result = await universityApi.add(university)
	    	const data = await result.json()
	    	commit('addUniversityMutation',data)
	    },
	    
	    async updateUserAction({commit}, user) {
	    	const result = await userApi.update(user)
	    	const data = await result.json()
	    },
	    
	    async updateStudentAction({commit}, student) {
	    	const result = await studentApi.update(student)
	    	const data = await result.json()	
	    },
	    async updateUniversityAction({commit}, university) {
	    	
	    	const result = await universityApi.update(university)
	    	const data = await result.json() 
	    	commit('updateUniversityMutation',data)
	    },
	    
	    async updateUserUnivAction({commit}, user) {
	    	const result = await userUnivApi.update(user)
	    	const data = await result.json()   	
	    },
	    
	    async updateAddressAction({commit}, address) {
	    	const result = await addressApi.update(address)
	    	const data = await result.json()	
	    },
	    
	    async addFacultyAction({commit}, faculty) {
	    	const result = await facultyApi.add(faculty)
	    	const data = await result.json()
	    	commit('addFacultyMutation',data)
	    },
	    
	    async updateAppReponse({commit}, application) {
	    	const result = await applicationApi.update(application)
	    	const data = await result.json()
	    },
	    
	    async removeUniversityAction({commit},university){
	    	const result = await universityApi.remove(university.id)
	    	if (result.ok) {
	    		commit('removeUniversityMutation', university)
	    	}
	    },
	    async removeProgramAction({commit},program){
	    	const result = await programApi.remove(program.id)
	    	if (result.ok) {
	    		commit('removeProgMutation', program)
	    	}
	    },
	    async updateProgramAction({commit}, program) {
	    	const result = await programApi.update(program)
	    	const data = await result.json() 
	    	commit('updateProgMutation',data)
	    },
    }
})