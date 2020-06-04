package cnam.project.QIService.controllers;

import java.util.List;

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

import cnam.project.QIService.entities.Address;
import cnam.project.QIService.entities.University;
import cnam.project.QIService.repository.AddressRepository;
import cnam.project.QIService.repository.UniversityRepository;


@RestController
@RequestMapping("university")
public class UniversityController {
	
	private final UniversityRepository universityRepository;
	private final AddressRepository addressRepository;

	@PersistenceContext
	EntityManager entityManager;

    @Autowired
    public UniversityController(UniversityRepository universityRepository,AddressRepository addressRepository) {
		this.universityRepository = universityRepository;
		this.addressRepository=addressRepository;
    }
	
    @PostMapping
    public University create(@RequestBody University university) {
    	Address address=university.getAddress();
    	addressRepository.save(address);
        return universityRepository.save(university);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") University university) {
    	universityRepository.delete(university);
    }
    
    @GetMapping
    public List<University>list(){
    	return universityRepository.findAll();
    }
    
    @GetMapping("names")
    public List<String>getUniversityNames(){
    	return entityManager.createQuery("SELECT  name  FROM University").getResultList();
    	
    }
}


