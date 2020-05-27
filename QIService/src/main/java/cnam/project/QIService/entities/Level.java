package cnam.project.QIService.entities;

public enum Level {
	
	
	BAC("Bacalaureat"),L1("Licence 1"),L2("Licence 2"),L3("Licence 3"),M1("Master 1"),M2("Master 2"),D("Doctorat");
	
	String title;
	Level(String title){
		this.title=title;
	}
	public String toString() {
		return this.title;
	}
	
	
}
