import Vue from 'vue'
import VueI18n from 'vue-i18n'

Vue.use(VueI18n)

export const i18n = new VueI18n({
locale : 'en',
fallbackLocale : 'fr',
messages : {
en : {
	addUniversity:'Add a university',
	users:'Users',
	mainPage:'Main page',
	addFaculty:'Add a new faculty',
	addProgram:'Add a new program',
	programCandidat:'List programs-candidates',
	candidats:'List candidates',
	valid:'VALIDATE',
	facultyNameEnter:'Enter the new name of the faculty',
	facultyNameChoice:'Choose the new name of the faculty',
	programNameEnter:'Enter the new name of the program',
	duration:'Choose the duration',
	choice:'Choice...',
	levelChoice:'Choose the level'
	
},
fr : {
	addUniversity:'Ajouter une université',
	user:'Utilisateurs',
	mainPage:'Première page',
	addFaculty:'Ajouter une nouvelle faculté',
	addProgram:'Ajouter une nouvelle programme',
	programCandidat:'Liste programmes-candidats',
	candidats:'Liste candidats',
	valid:'VALIDER',
	facultyNameEnter:'Introduire le nouveau nom de la faculté',
	facultyNameChoice:'Choisissez le nouveau nom de la faculté',
	programNameEnter:'Introduire le nouveau nom du programme',
	duration:'Choisissez la duration',
	choice:'Choix...',
	levelChoice:'Choisissez le niveau'
}

}
})