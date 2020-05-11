package cnam.project.QIService.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Student {
	private String name;
	private String surname;
	private int age;
	private String sex;
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<Program> demands;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	 
	
	

}
