package cnam.project.QIService.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Application;
import cnam.project.QIService.entities.Faculty;
import cnam.project.QIService.entities.Student;
import cnam.project.QIService.entities.University;
import cnam.project.QIService.repository.FacultyRepository;
import cnam.project.QIService.repository.UniversityRepository;

@RestController
@RequestMapping("faculty")
public class FacultyController {
	
	
	private final FacultyRepository facultyRepository;
	
	private final UniversityRepository universityRepository;
	
	@PersistenceContext
    EntityManager entityManager;
	
    @Autowired
    public FacultyController(FacultyRepository facultyRepository,UniversityRepository universityRepository) {
		this.universityRepository = universityRepository;
		this.facultyRepository = facultyRepository;
    }
	
    @PostMapping
    public Faculty create( @RequestBody Faculty faculty) {
    	
    	Faculty savedFaculty=facultyRepository.save(faculty);
    	University universityFromBD=universityRepository.getOne(savedFaculty.getUniversityId());
    	
    	if(universityFromBD.getFaculties()==null) {
    	
    		Set<Faculty>faculties=new HashSet<>();
    		faculties.add(savedFaculty);
    	}
    	else {
    		universityFromBD.getFaculties().add(savedFaculty);
    	}
    	universityRepository.save(universityFromBD);
    	return	savedFaculty;			    
    }
    
    @GetMapping("{id}")
    public List<Faculty> getFaculties(@PathVariable("id") long id) {
    	
    	List<Faculty>list=facultyRepository.findByUniversityId(id);
    	return list;	
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Faculty faculty) {
    	facultyRepository.delete(faculty);
    }
    
    @GetMapping
    public List<String>getFaculiesNames(){
    	return entityManager.createQuery("SELECT  DISTINCT name  FROM Faculty").getResultList();
    	
    }
    @GetMapping("/map")
    public Map<Long,List<Faculty>>getFacultyByUniversityId(){
    	
    	Map<Long,List<Faculty>>map=new HashMap<>();
    	for(Faculty fac: facultyRepository.findAll()){
    		
        	if(map.containsKey(fac.getUniversityId())){
        		
        		map.get(fac.getUniversityId()).add(fac);
        	}
        	else{
        		ArrayList<Faculty>listFac=new ArrayList<>();
        		listFac.add(fac);
        		
        		map.put(fac.getUniversityId(), listFac);
        	}
        	
        }
    	return map;
    	
    }
   
}

