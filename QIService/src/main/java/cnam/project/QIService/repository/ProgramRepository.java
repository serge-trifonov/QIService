package cnam.project.QIService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.project.QIService.entities.Program;
import cnam.project.QIService.entities.UserUniv;


public interface ProgramRepository extends JpaRepository<Program, Long>{
	
	public List<Program>findByUserUniv(UserUniv userUniv);

}
