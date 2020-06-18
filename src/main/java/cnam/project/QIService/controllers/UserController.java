package cnam.project.QIService.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.project.QIService.entities.Address;
import cnam.project.QIService.entities.Student;
import cnam.project.QIService.entities.User;
import cnam.project.QIService.entities.UserUniv;
import cnam.project.QIService.repository.AddressRepository;
import cnam.project.QIService.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;

    @Autowired
    public UserController(UserRepository userRepository,AddressRepository addressRepository) {
		this.userRepository = userRepository;
		this.addressRepository=addressRepository;
    }
	
    @PostMapping
    public User create(@RequestBody User user) {
   
        return userRepository.save(user);
    }
    
    @GetMapping
    public List<User>list() {
   
        return userRepository.findAll();
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") User user) {
    	
    	userRepository.delete(user);
    }
    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") User userFromBD,@RequestBody User user) {
    	
    	System.out.println("user");
    	
    	userRepository.delete(userFromBD);
    	return userRepository.save(user);
    }
    
    @PutMapping("univ/{id}")
    public User updateUserUniv(@PathVariable("id") User userFromBD,@RequestBody UserUniv user) {
    	
    	userRepository.delete(userFromBD);
    	return userRepository.save(user);
    }   
    
    @PutMapping("stud/{id}")
    public User updateUserStud(@PathVariable("id") User userFromBD,@RequestBody Student user) {
    	
    	Address address=user.getAddress();
    	addressRepository.save(address);
    	userRepository.delete(userFromBD);
    	return userRepository.save(user);
    }   
}
