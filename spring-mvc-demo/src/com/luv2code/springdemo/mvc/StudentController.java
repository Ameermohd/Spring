package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showform")
	public String showform(Model model)
	{
		model.addAttribute("Student",new Student());
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processform(@ModelAttribute("Student")Student thestudent)
	{
		//System.out.println("Student : "+thestudent.getFirstname()+" "+thestudent.getLastname());
		System.out.println(thestudent.getOperatingsystems());
		return "student-confirmation";
	}
	
	
	
	

}
