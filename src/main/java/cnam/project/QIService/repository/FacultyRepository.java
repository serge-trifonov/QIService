package cnam.project.QIService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.project.QIService.entities.Faculty;
import cnam.project.QIService.entities.Program;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{

	public List<Faculty> findByUniversityId(Long id);	
}
