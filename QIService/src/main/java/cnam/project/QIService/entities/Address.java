package cnam.project.QIService.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Address {
	private int number;
	private String street;
	private int postalAddress;
	private String city;
	private String country;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
  
	

}
