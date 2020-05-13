import Vue from 'vue'
import Vuex from 'vuex'
import programApi from 'api/program'
import studentApi from 'api/student'
import universityApi from 'api/university'

Vue.use(Vuex)

export default new Vuex.Store({
   
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
	    }
        
        
    }
})