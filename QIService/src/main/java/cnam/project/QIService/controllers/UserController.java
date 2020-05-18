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


import cnam.project.QIService.entities.User;
import cnam.project.QIService.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
	private final UserRepository userRepository;

	
    @Autowired
    public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
    }
	
    @PostMapping
    public User create(
            @RequestBody User user
    ) {
   
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
    public User update(
    @PathVariable("id") User userFromBD,
    @RequestBody User user
    ) {

    BeanUtils.copyProperties(user, userFromBD, "id");
    return userRepository.save(userFromBD);
    }
    
    
    
    
    
}
