package cnam.project.QIService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Application;
import cnam.project.QIService.entities.Response;
import cnam.project.QIService.repository.ApplicationRepository;

@RestController
@RequestMapping("application")
public class ApplicationController {
	
	private final ApplicationRepository applicationRepository;
	
    @Autowired
    public ApplicationController(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
    }

    @PostMapping
    public Application create(@RequestBody Application application) {
    	application.setResponse(Response.PENDING);
        return applicationRepository.save(application);
    }
    
    
    
}

