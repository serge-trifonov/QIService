package cnam.project.QIService.entities;

public enum Gender {
	M("Male"),F("Female");
	
	String gender;
	Gender(String gender){
		this.gender=gender;
	}
	public String toString() {
		return gender;
	}
}
