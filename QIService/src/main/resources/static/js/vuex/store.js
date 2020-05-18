import Vue from 'vue'
import Vuex from 'vuex'
import programApi from 'api/program'
import studentApi from 'api/student'
import universityApi from 'api/university'
import userApi from 'api/user'

Vue.use(Vuex)

export default new Vuex.Store({
   
	state: {
		allprograms: programs,
		user: userInfo.user
		},
		
    actions: {
    	
        async addProgramAction({commit}, program) {
            const result = await programApi.add(program)
            const data = await result.json()
        },async addStudentAction({commit}, student) {
            const result = await studentApi.add(student)
            const data = await result.json()
        },async addUniversityAction({commit}, university) {
	    	const result = await universityApi.add(university)
	    	const data = await result.json()
	    },async updateUserAction({commit}, user) {
	    	const result = await userApi.update(user)
	    	const data = await result.json()
    }
        
        
    }
})