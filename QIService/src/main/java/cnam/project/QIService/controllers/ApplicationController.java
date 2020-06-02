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

@RestController
@RequestMapping("application")
public class ApplicationController {
	
	private final ApplicationRepository applicationRepository;
	@Autowired
	private MailSender mailSender;
	
    @Autowired
    public ApplicationController(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
    }

    @PostMapping
    public Application create(@RequestBody Application application) {
    	application.setResponse(Response.PENDING);
    	Application savedApplication=applicationRepository.save(application);
    	String message="***Important***\n has a new application";
    	mailSender.send("remontkkm@aol.fr", "New Application", message);
        return applicationRepository.save(application);
    }
    
    @PutMapping("{id}")
    public Application update(@PathVariable("id")Application appFromDB,@RequestBody Application app ) {
    BeanUtils.copyProperties(app, appFromDB, "id");

    return applicationRepository.save(appFromDB);

    }
    
    
    
}

