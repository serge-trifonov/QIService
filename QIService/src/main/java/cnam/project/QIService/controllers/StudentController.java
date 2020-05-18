package cnam.project.QIService.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Student;
import cnam.project.QIService.entities.User;
import cnam.project.QIService.repository.StudentRepository;
import cnam.project.QIService.repository.UserRepository;



@RestController
@RequestMapping("student")
public class StudentController {
	
private final StudentRepository studentRepository;
private final UserRepository userRepository;

	
    @Autowired
    public StudentController(StudentRepository studentRepository,UserRepository userRepository) {
		this.studentRepository = studentRepository;
		this.userRepository=userRepository;
    }
	
    @PostMapping
    public Student create(
    		@AuthenticationPrincipal User user,
            @RequestBody Student student
    ) {
    	Student newStudent=studentRepository.save(student);
    	user.setQis(newStudent);
    	userRepository.save(user);
        return newStudent;
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Student student) {
    	studentRepository.delete(student);
    }

}
