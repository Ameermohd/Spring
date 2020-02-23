package com.luv2code.springsecurity.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String Showhome() {
		return "home";
	}
}
