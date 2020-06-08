package cnam.project.QIService.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Application;
import cnam.project.QIService.entities.Response;
import cnam.project.QIService.entities.User;
import cnam.project.QIService.mailservice.MailSender;
import cnam.project.QIService.repository.ApplicationRepository;
import cnam.project.QIService.repository.ProgramRepository;
import cnam.project.QIService.repository.StudentRepository;

@RestController
@RequestMapping("application")
public class ApplicationController {
	
	private final ApplicationRepository applicationRepository;
	private final StudentRepository studentRepository;
	private final ProgramRepository programRepository;
	
	@Autowired
	private MailSender mailSender;
	
    @Autowired
    public ApplicationController(ApplicationRepository applicationRepository,
    		StudentRepository studentRepository,ProgramRepository programRepository) {
    	
		this.applicationRepository = applicationRepository;
		this.studentRepository = studentRepository;
		this.programRepository = programRepository;	
    }
    
    @PostMapping
    public Application create(@RequestBody Application application) {
    	application.setResponse(Response.PENDING);
    	Application savedApplication=applicationRepository.save(application);
    	
    	String messageName=studentRepository.getOne(savedApplication.getStudId()).getFamilyName()+" "+
    			studentRepository.getOne(savedApplication.getStudId()).getGivenName();	
    	String messageProg=programRepository.getOne(savedApplication.getProgramId()).getName();
	
    	String message="***Important***\n have a new application to "+messageProg+" from: "+messageName;
    	
    	mailSender.send("domarco@bk.ru", "New Application", message);
    	
        return savedApplication;
    }
    
    @PutMapping("{id}")
    public Application update(@PathVariable("id")Application appFromDB,@RequestBody Application app ) {
    BeanUtils.copyProperties(app, appFromDB, "id");

    return applicationRepository.save(appFromDB);

    } 
}

