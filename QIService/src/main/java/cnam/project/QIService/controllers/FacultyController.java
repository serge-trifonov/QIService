package cnam.project.QIService.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Faculty;
import cnam.project.QIService.repository.FacultyRepository;




@RestController
@RequestMapping("faculty")
public class FacultyController {
	
	
	private final FacultyRepository facultyRepository;
	
	@PersistenceContext
    EntityManager entityManager;
	
    @Autowired
    public FacultyController(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
    }
	
    @PostMapping
    public Faculty create( @RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    
    @GetMapping("{id}")
    public List<Faculty> getFaculties(@PathVariable("id") long id) {
    	
    	List<Faculty>list=facultyRepository.findByUniversityId(id);
    	return list;	
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Faculty faculty) {
    	facultyRepository.delete(faculty);
    }
    
    @GetMapping
    public List<String>getFaculiesNames(){
    	return entityManager.createQuery("SELECT  DISTINCT name  FROM Faculty").getResultList();
    	
    }
    
    
   
}

