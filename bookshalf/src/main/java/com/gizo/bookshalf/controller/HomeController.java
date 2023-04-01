package com.gizo.bookshalf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	
	@GetMapping("/") 
	public String index() {
		return "index";
	}
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@GetMapping("/admin_private")
	public String admin_private() {
		return "admin_private";
	}

	@GetMapping("/user_private")
	public String user_private() {
		return "user_private";
	}

}
