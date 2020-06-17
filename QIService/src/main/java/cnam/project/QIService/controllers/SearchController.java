package cnam.project.QIService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Program;
import cnam.project.QIService.entities.SearchMethod;
import cnam.project.QIService.entities.SearchParam;
import cnam.project.QIService.repository.ProgramRepository;

@RestController
@RequestMapping("search")
public class SearchController {
	
		@Autowired
		ProgramRepository programrepo;
		
		@Autowired
    	SearchMethod search;
	
	@PostMapping
    public List<Program> createSearch(@RequestBody SearchParam searchParam) {
		
    	return search.programFound(searchParam);
    }
}
