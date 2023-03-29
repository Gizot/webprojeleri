package com.gizo.security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping
	public String index() {
		return "index sayfasına hoşgeldiniz";
		
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard sayfasına hoşgeldiniz"; 
		
	}

}
