package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showMyLoginPage")
	public String Loginform() {
		
		return "fancy-login";
	}
	@GetMapping("/access-denied")
	public String access() {
		
		return "accessdenied";
	}

}