package cnam.project.QIService.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cnam.project.QIService.entities.Application;
import cnam.project.QIService.entities.Program;
import cnam.project.QIService.entities.Response;
import cnam.project.QIService.entities.Role;
import cnam.project.QIService.entities.Student;
import cnam.project.QIService.entities.User;
import cnam.project.QIService.entities.UserUniv;
import cnam.project.QIService.repository.ApplicationRepository;
import cnam.project.QIService.repository.ProgramRepository;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ProgramRepository programRepository;
	@Autowired
	private ApplicationRepository applicationRepository;
	
	
	@GetMapping   
    public String main(Model model, @AuthenticationPrincipal User user) {
    	
    	List<Program>listProg=programRepository.findAll();
    	model.addAttribute("programs",listProg);
    	
        HashMap<Object, Object> data = new HashMap<>();
        
        
        
        data.put("user", user);
        
        if(user!=null&&user.getRole()==Role.STUDENT) {
        	data.put("applications",applicationRepository.findByStudId(user.getId()));
        }
        
        
        
        
        
        
        if(user!=null&&user.getRole()==Role.UNIVERSITY) {
        	 List<Program>list=programRepository.findByUserUniv((UserUniv) user);
        	 data.put("userProgram",list);
        
        	 List<Application>listApp=applicationRepository.findByProgramIdIn(list.stream().map(p->p.getId()).collect(Collectors.toList()));
        
        	 HashMap<Long,List<Student>>mapProgStud=new HashMap<>();
        	 
        	 data.put("mapProgStud",mapProgStud);
        
	        listApp.forEach(l->{
	        	System.out.println(l.getId()+" "+l.getStudent());
	        	}
	        );
	        
	        Map <String, Application>reponseByStudent= listApp.stream().collect( Collectors.toMap(Application::getStudId,
        		Function.identity()));
	        data.put("reponseByStud",reponseByStudent);
	        
	        
	        for(Application app: listApp){
	        	if(mapProgStud.containsKey(app.getProgramId())){
	        		mapProgStud.get(app.getProgramId()).add(app.getStudent());
	        	}
	        	else{
	        		ArrayList<Student>listStud=new ArrayList<>();
	        		listStud.add(app.getStudent());
	        		
	        		mapProgStud.put(app.getProgramId(), listStud);
	        	}
	        	
	        }
   
        }
       
        model.addAttribute("userInfo", data);
        model.addAttribute("isDevMode", true);
       
        
        return "index"; 
    }
    
}
