package cnam.project.QIService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Program {
	
	private static final long serialVersionUID = 1L;
		
	private String name;
	private int duration;	
	private Level level;
	private UserUniv userUniv;
		
	@JoinColumn(name = "faculty_id", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Faculty faculty;
	
	@Column(name = "faculty_id")
	private Long facultyId;
	
	public UserUniv getUserUniv() {
		return userUniv;
	}

	public void setUserUniv(UserUniv userUniv) {
		this.userUniv = userUniv;
	}

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public String getName() {
		return name;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}


	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
