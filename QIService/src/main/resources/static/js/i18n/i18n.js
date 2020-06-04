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
			
			candidats:'Candidates',
			valid:'VALIDATE',
			
			facultyNameEnter:'Enter the new name of the faculty',
			universityNameEnter:'Enter the name of the university',
			
			facultyNameChoice:'Choose the  name of the faculty',
			programNameChoice:'Choose the  name of the program',
			universityNameChoice:'Choose the  name of the university',
			countryNameChoice:'Choose the country',
			
			cityNameEnter:'Entrer the  city',
			programNameEnter:'Enter the name of the program',
			
			duration:'Choose the duration',
			choice:'Choice...',
			levelChoice:'Choose the level',
			prog:'Program',
			university:'University',
			universityAddress:'University\'s address',
			duration:'Duration',
			level:'Level',
			status:'Status',
			searche:'SEARCHE',
			newSearche:'NEW SEARCHE',
			responsable:'Responsable',
			contact:'Contact',
			faculty:'Faculty',

			cand:'Candidate',
			noApplication:'No application',
			name:'Name',
			surname:'Surname',
			age:'Age',
			gender:'Gender',
			currentLevel:'Current level',
			address:'Address',
			photo:'Photo',
			accept:'ACCEPT',
			refuse:'REFUSE',
			decision:'Decision...',
			register:'Sign up',
			number:'Number',
			street:'Street',
			zipCode:'Zip code',
			city:'City',
			country:'Country',
			search:'Search',
			
			listProgram:'Programs',
			listUniversity:'Universities',
			listFaculty:'Faculties',
			listProgramCandidat:'Programs-candidates',
			
			progSend:'Check the applications send',
			alert:'Hello our future student.Program for you is below.You can send message to\
					the responsable of the program! You\'ll get the answer via email! Good luck!',
			descriptionProg:'Description of the program',
			message:'Write your message here',
			send:'SEND',
			back:'RETURN',
			users:'Users',
			user:'User'
			
			
		},
		fr : {
			addUniversity:'Ajouter une université',
			user:'Utilisateurs',
			mainPage:'Première page',
			addFaculty:'Ajouter une nouvelle faculté',
			addProgram:'Ajouter une nouvelle programme',
			
			candidats:'Candidats',
			valid:'VALIDER',
			
			facultyNameEnter:'Introduire le nouveau nom de la faculté',
			universityNameEnter:'Introduire le nom de l\'université',
			
			facultyNameChoice:'Choisissez le nom de la faculté',
			programNameChoice:'Choisissez le nom du program',
			universityNameChoice:'Choisissez le nom de l\'université',
			countryNameChoice:'Choisissez le pays',
			
			cityNameEnter:'Introduire la ville',
			programNameEnter:'Introduire le nom du programme',
			
			duration:'Choisissez la duration',
			choice:'Choix...',
			levelChoice:'Choisissez le niveau',
			prog:'Programme',
			university:'Université',
			universityAddress:'Adresse de l\'université',
			duration:'Durée',
			level:'Niveau',
			status:'Statut',
			searche:'RECHERCHE',
			newSearche:'NOUVEAU RECHERCHE',
			responsable:'Responsible',
			contact:'Contact',
			faculty:'Faculté',
			
			cand:'Candidat',
			noApplication:'Aucune application',
			name:'Prénom',
			surname:'Nom',
			age:'Âge',
			gender:'Sexe',
			currentLevel:'Le niveau en cours',
			address:"Adresse",
			photo:'Photo',
			accept:'ACCEPTER',
			refuse:'REFUSER',
			decision:'Décision...',
			register:'S\'enregistrer',
			number:'Numéro',
			street:'Rue',
			zipCode:'Code postale',
			city:'Ville',
			country:'Pays',
			search:'Rechercher',
			
			
			listUniversity:'Universités',
			listFaculty:'Facultés',
			listProgram:'Programmes',
			listProgramCandidat:'Programmes-candidats',
			
			progSend:'Verifier les demandes envoyées',
			alert:'Salut notre nouveau student.La programme que t\'as choici est là-bas.\
					Tu peux écrire ton message en envoyer le demande à le responsable! Tu \
					receverras la reponse par email! Bonne chanche!',
			descriptionProg:'Description du programme',
			message:'Ecrire ton message ici',
			send:'ENVOYER',
			back:'REVENIR',
			users:'Utilisateurs',
			user:'Utilisateur',
		}
		
	}
})