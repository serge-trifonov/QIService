package cnam.project.QIService.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Student;
import cnam.project.QIService.entities.University;
import cnam.project.QIService.entities.User;
import cnam.project.QIService.repository.StudentRepository;
import cnam.project.QIService.repository.UniversityRepository;


@RestController
@RequestMapping("university")
public class UniversityController {
	
	
	
private final UniversityRepository universityRepository;

	
    @Autowired
    public UniversityController(UniversityRepository universityRepository) {
		this.universityRepository = universityRepository;
    }
	
    @PostMapping
    public University create(@RequestBody University university) {
        return universityRepository.save(university);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") University university) {
    	universityRepository.delete(university);
    }
    
    @GetMapping
    public List<University>list(){
    	return universityRepository.findAll();
    }
    
}


