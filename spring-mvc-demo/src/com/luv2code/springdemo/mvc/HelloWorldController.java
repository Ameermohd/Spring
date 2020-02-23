package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {
	
	@RequestMapping("/showform")
	public String showForm()
	{
		return "helloworld-form";
	}
	//1.Normal processing
	@RequestMapping("/processform")
	public String processForm()
	{
		return "helloworld";
	}
	//2.Changing the incoming parameter from the HTML-FORM
	@RequestMapping("/processformVersion2")
	public String YoShout(HttpServletRequest request, Model model){
		
		String data = request.getParameter("Studentname");
		
		model.addAttribute("message", "YO! "+data.toUpperCase());
		
		return "helloworld";
		
		
	}
	//3.Another way of changing parameter using spring annotation @Requestparam
	@RequestMapping("/processformVersion3")
	public String YoShout2(@RequestParam("Studentname") String theparam, Model model){
		
		
		model.addAttribute("message", "YA HOO...! "+theparam.toUpperCase());
		
		return "helloworld";
		
		
	}

}
