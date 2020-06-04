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
		applications: userInfo.applications
				
	},
	mutations:{
		addProgMutation(state, prog) {
			state.allprograms = [...state.allprograms,prog];
			state.programs = [...state.programs,prog]
		},
			
		updateProgMutation(state, prog) {
			let updateIndex = state.allprograms.findIndex(item => item.id === prog.id);

			state.allprograms = [...state.allprograms.slice(0, updateIndex),prog,...state.allprograms.slice(updateIndex + 1)];
			updateIndex = state.programs.findIndex(item => item.id === prog.id)
			state.programs = [...state.programs.slice(0, updateIndex),prog,...state.programs.slice(updateIndex + 1)]
		},
			
		removeProgMutation(state, domain) {
			let deletionIndex = state.allprograms.findIndex(item => item.id === prog.id);

			if (deletionIndex > -1) {
				state.allprograms = [...state.allprograms.slice(0, deletionIndex),...state.allprograms.slice(deletionIndex + 1)];
				deletionIndex = state.allprograms.findIndex(item => item.id === prog.id)
			}

			if (deletionIndex > -1) {
				state.allprograms = [...state.allprograms.slice(0, deletionIndex),...state.allprograms.slice(deletionIndex + 1)]
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
        
        async addUniversityAction({commit}, university) {
	    	const result = await universityApi.add(university)
	    	const data = await result.json()
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
	    },
    
	    async updateAppReponse({commit}, application) {
	    	const result = await applicationApi.update(application)
	    	const data = await result.json()
	    }   
    }
})