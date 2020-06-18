package cnam.project.QIService.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("hello")
public class HelloController {

	private List<Map<String, String>> hellos = new ArrayList<Map<String, String>>() {
		{
			add(new HashMap<String, String>() {
				{
					put("id", "1");
					put("text", "Hello World");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("id", "2");
					put("text", "Bonjour le Monde");
				}
			});
			add(new HashMap<String, String>() {
				{
					put("id", "3");
					put("text", "Hola mundo");
				}
			});
		}
	};

	@GetMapping
	public List<Map<String, String>> list() {
		return hellos;
	}
}
