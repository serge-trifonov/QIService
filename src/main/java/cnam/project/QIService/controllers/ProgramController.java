package cnam.project.QIService.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Program;
import cnam.project.QIService.entities.University;
import cnam.project.QIService.entities.UserUniv;
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
    public Program create(@RequestBody Program program, @AuthenticationPrincipal UserUniv user) {
    	program.setUserUniv(user);
        return programRepository.save(program);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Program program) {
    	programRepository.delete(program);
    }
    
    @PutMapping("{id}")
	public Program update(@PathVariable("id") Program programFromDB, @RequestBody Program program) {
		
		BeanUtils.copyProperties(program, programFromDB, "id");
		return programRepository.save(programFromDB);
	}
    
    @GetMapping("/progsByFacultyId")
	public Map<Long, List<Program>> getFacultyByUniversityId() {

		Map<Long, List<Program>> map = new HashMap<>();
		for (Program prog : programRepository.findAll()) {

			if (map.containsKey(prog.getFacultyId())) {
				map.get(prog.getFacultyId()).add(prog);
			} else {
				ArrayList<Program> listProg = new ArrayList<>();
				listProg.add(prog);

				map.put(prog.getFacultyId(), listProg);
			}
		}
		return map;
	}    
}
