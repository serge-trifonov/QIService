package cnam.project.QIService.controllers;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cnam.project.QIService.entities.Program;
import cnam.project.QIService.entities.User;
import cnam.project.QIService.repository.ProgramRepository;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ProgramRepository programRepository;
	@GetMapping   
    public String main(Model model, @AuthenticationPrincipal User user) {
    	
    	List<Program>listProg=programRepository.findAll();
    	model.addAttribute("programs",listProg);
    	System.out.println("hello wor");
        HashMap<Object, Object> data = new HashMap<>();
        data.put("user", user);
        model.addAttribute("userInfo", data);
        model.addAttribute("isDevMode", true);
        return "index"; 
    }
    
}
