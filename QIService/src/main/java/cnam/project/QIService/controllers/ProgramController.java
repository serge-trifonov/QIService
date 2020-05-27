package cnam.project.QIService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Program;
import cnam.project.QIService.repository.ProgramRepository;


@RestController
@RequestMapping("program")
public class ProgramController {
	private final ProgramRepository programRepository;

	
    @Autowired
    public ProgramController(ProgramRepository programRepository) {
		this.programRepository = programRepository;
    }
    
	@GetMapping("{id}")
    public Program getProgram(@PathVariable("id")Program program) {
		
		return program;
		
	}
    @PostMapping
    public Program create(@RequestBody Program program) {
    
    	System.out.println("program name"+program.getLevel());
        return programRepository.save(program);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Program program) {
    	programRepository.delete(program);
    }

}
