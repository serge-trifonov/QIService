package cnam.project.QIService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.project.QIService.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
	
	public List<Application>findByProgramIdIn(List<Long>list);

}
