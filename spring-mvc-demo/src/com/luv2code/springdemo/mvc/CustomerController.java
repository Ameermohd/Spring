package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Added Init binder to prevent trim
	//white spaces coming in  
	@InitBinder
	public void initBinder(WebDataBinder databinder)
	{
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, trimmer);
	}
	
	@RequestMapping("/showform")
	public String showform(Model themodel) {
		
		themodel.addAttribute("Customer", new Customer());
		return "customer-form";
		
	}
	@RequestMapping("/processform")
	public String processform(@Valid  @ModelAttribute("Customer") Customer thecustCustomer,
			BindingResult result) {
		
		System.out.println("LOG: Binding redult "+result+"\n\n");
		
		if(!result.hasErrors())
		{
		return "customer-confirmation";}
		else
		{
			return "customer-form";
		}
	}

}

