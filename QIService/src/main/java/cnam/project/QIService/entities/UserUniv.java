package cnam.project.QIService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Data
public class UserUniv extends User{
	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "university_id", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private University university;
	@Column(name = "university_id")
	private Long universityId;
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

	
}
