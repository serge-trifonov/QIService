package cnam.project.QIService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	
    @Autowired
    public FacultyController(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
    }
	
    @PostMapping
    public Faculty create( @RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Faculty faculty) {
    	facultyRepository.delete(faculty);
    }
}

