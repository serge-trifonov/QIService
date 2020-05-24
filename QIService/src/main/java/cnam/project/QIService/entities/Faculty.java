package cnam.project.QIService.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Faculty implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@JoinColumn(name = "university_id", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private University university;
	@Column(name = "university_id")
	private Long universityId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Program>programs;
	
	
	
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public Long getUniversityId() {
		return universityId;
	}
	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}
	public Set<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = (long) id;
	}
	@Override
	public String toString() {
		return "Faculty [name=" + name + ", id=" + id + "]";
	}
	
	

}
