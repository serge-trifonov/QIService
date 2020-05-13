package cnam.project.QIService.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Student;
import cnam.project.QIService.repository.StudentRepository;



@RestController
@RequestMapping("student")
public class StudentController {
	
private final StudentRepository studentRepository;

	
    @Autowired
    public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
    }
	
    @PostMapping
    public Student create(
            @RequestBody Student student
    ) {
    	System.out.println("student "+student);
    	System.out.println("student name"+student.getName());
        return studentRepository.save(student);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Student student) {
    	studentRepository.delete(student);
    }

}
