import Vue from 'vue'
import VueI18n from 'vue-i18n'

Vue.use(VueI18n)

export const i18n = new VueI18n({
	locale : 'en',
	fallbackLocale : 'fr',
	messages : {
		en : {
			
			users:'Users',
			mainPage:'MAIN PAGE',
			
			addUniversity:'ADD UNIVERSITY',
			addFaculty:'ADD FACULTY',
			addProgram:'ADD PROGRAM',
			
			candidats:'Candidates',
			
			
			facultyNameEnter:'Faculty\'s name',
			universityNameEnter:'Enter the name of the university',
			cityNameEnter:'Entrer the  city',
			programNameEnter:'Program\'s name',
			
			facultyNameChoice:'Faculty\'s name',
			programNameChoice:'Choose the  name of the program',
			universityNameChoice:'Choose the  name of the university',
			countryNameChoice:'Choose the country',
			
			
			
			duration:'Choose the duration',
			choice:'Choice...',
			
			prog:'Program',
			university:'University',
			universityAddress:'University\'s address',
			duration:'Duration',
			level:'Level',
			status:'Status',
			
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
			
			number:'Number',
			street:'Street',
			zipCode:'Zip code',
			city:'City',
			country:'Country',
			search:'SEARCH',
			address:'Address',
			
			listProgram:'Programs',
			
			
			listProgramCandidat:'PROGRAMS-CANDIDATES',
			
			progSend:'APPLICATIONS',
			
			alert:'Hello our future student.Program for you is below.You can send message to\
					the responsable of the program! You\'ll get the answer via email! Good luck!',
			alert2:'To see the list of faculties and programs you have to registrer',
			
			descriptionProg:'Description of the program',
			message:'Write your message here',
			send:'SEND',
			back:'RETURN',
			users:'USERS',
			user:'User',
			profile:'PROFILE',
			edit:'EDIT',
			check:'CHECK',
			search:'SEARCH',
			find:'FIND SEND',
			quantity:'QUANTITY',
			universities:'UNIVERSITIES',
			university:'UNIVERSITY',
			see:'SEE',
			createProfile:'YOU SHOULD CREATE PROFILE',
			add:'ADD',
			faculty:'FACULTY',
			program:'PROGRAM',
			candidates:'CANDIDATES',
			admit:'ADMIT',
			refus:'REFUS',
			status:'STATUS',
			faculties:'FACULTIES',
			programs:'PROGRAMS',
			users:'USERS',
			facultyRegistration:'Faculty registration',
			facultyModification:'Faculty modification',
			programRegistration:'Program registration',
			programModification:'Program modification',
			universityRegistration:'University registration',
			universityModification:'University modification',
			questionDelete:'Are you sure to delete '
			
			
		},
		fr : {
			
			user:'Utilisateurs',
			mainPage:'PREMIERE PAGE',
			
			addUniversity:'AJOUTER UNIVERSITÉ',
			addFaculty:'AJOUTER FACULTÉ',
			addProgram:'AJOUTER PROGRAMME',
			
			candidats:'Candidats',
			
			
			facultyNameEnter:'Nom de la faculté',
			universityNameEnter:'Introduire le nom de l\'université',
			cityNameEnter:'Introduire la ville',
			programNameEnter:'Nom du programme',
			
			
			facultyNameChoice:'Nom de la faculté',
			programNameChoice:'Choisissez le nom du program',
			universityNameChoice:'Choisissez le nom de l\'université',
			countryNameChoice:'Choisissez le pays',
			
			
			
			duration:'Choisissez la duration',
			choice:'Choix...',
			
			prog:'Programme',
			university:'Université',
			universityAddress:'Adresse de l\'université',
			duration:'Durée',
			level:'Niveau',
			status:'Statut',
			
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
			
			number:'Numéro',
			street:'Rue',
			zipCode:'Code postale',
			city:'Ville',
			country:'Pays',
			search:'RECHERSHE',
			address:'Adresse',
			
			
			
			
			listProgram:'Programmes',
			listProgramCandidat:'PROGRAMMES-CANDITATS',
			
			progSend:'POSTULATIONS',
			
			alert:'Salut notre nouveau student.La programme que t\'as choici est là-bas.\
					Tu peux écrire ton message en envoyer le demande à le responsable! Tu \
					receverras la reponse par email! Bonne chanche!',
			alert2:'Pour voir la liste de facultés et programmes vous devez vous instrire',
			
			descriptionProg:'Description du programme',
			message:'Ecrire ton message ici',
			send:'ENVOYER',
			back:'REVENIR',
			users:'UTILISATEURS',
			user:'Utilisateur',
			profile:'PROFIL',
			edit:'MODIFIER',
			check:'VERIFIER',
			search:'RECHERCHE',
			find:'TROUVER ENVOYER',
			quantity:'QUANTITE',
			universities:'UNIVERSITÉS',
			university:'UNIVERSITÉ',
			see:'VOIR',
			createProfile:'VOUS DEVEZ CREER PROFIL',
			add:'AJOUTER',
			faculty:'FACULTÉ',
			program:'PROGRAMME',
			candidates:'CANDIDATS',
			admit:'ADMETTRE',
			refus:'REFUSE',
			status:'STATUT',
			faculties:'FACULTÉS',
			programs:'PROGRAMMES',
			users:'UTILISATEUERS',
			facultyRegistration:' L\'enregistrement de la faculté',
			facultyModification:'Modification de la faculté',
			programRegistration:' L\'enregistrement du programme',
			programModification:'Modification du programme',
			universityRegistration:' L\'enregistrement du l\'univesité',
			universityModification:'Modification de l\'université',
			questionDelete:'Voulez-vous vraiement supprimer '
		}
		
	}
})