package cnam.project.QIService.controllers;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cnam.project.QIService.entities.User;


@Controller
@RequestMapping("/")
public class HomeController {   


    @GetMapping   
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();
        model.addAttribute("userInfo", data);
        model.addAttribute("isDevMode", true);
        return "index"; 
    }
    
}
