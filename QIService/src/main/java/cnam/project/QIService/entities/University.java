package cnam.project.QIService.entities;

import java.util.List;

import javax.persistence.*;



import lombok.Data;

@Entity
@Table
@Data
public class University {
	private String name;
	private String status;
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<Student> candidats;
	@OneToMany
	private List<Student> accepted;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	
	
	
	

}
