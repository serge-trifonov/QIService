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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Student> getCandidats() {
		return candidats;
	}

	public void setCandidats(List<Student> candidats) {
		this.candidats = candidats;
	}

	public List<Student> getAccepted() {
		return accepted;
	}

	public void setAccepted(List<Student> accepted) {
		this.accepted = accepted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	

}
