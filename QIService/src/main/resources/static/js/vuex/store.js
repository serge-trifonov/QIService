import Vue from 'vue'
import Vuex from 'vuex'
import programApi from 'api/program'
import studentApi from 'api/student'
import universityApi from 'api/university'
import userApi from 'api/user'
import userUnivApi from 'api/userUniv'
import facultyApi from 'api/faculty'
import addressApi from 'api/address'

Vue.use(Vuex)

export default new Vuex.Store({
   
	state: {
		allprograms: programs,
		user: userInfo.user,
		faculties:[]
		
		},
		
    actions: {
    	
        async addProgramAction({commit}, program) {
            const result = await programApi.add(program)
            const data = await result.json()
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
	    }
        
        
    }
})