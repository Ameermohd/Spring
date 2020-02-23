package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

import sun.misc.Contended;

@Controller
@RequestMapping("/customer")
public class CustomerController{
	
	@Autowired
	private CustomerService service;
	
	//@RequestMapping("/list") //This handles all requests
	@GetMapping("/list") //It handles only GET requests
	public String listCustomers(Model theModel)
	{
		//get the customers from the service
		List<Customer> customerList = service.getcustomers();
	
		//add the list to the model
		theModel.addAttribute("customers",customerList);
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel)
	{
		Customer thecustomer = new Customer();
		themodel.addAttribute("customer",thecustomer);
		return "customer-form";
		
		
	}

	@PostMapping("/saveCustomer")
	public String saveForm(@ModelAttribute("customer") Customer thecustomer) {
		
		service.saveCustomer(thecustomer);
		
		//redirecting to list view
		return "redirect:/customer/list";

		
	}
	
	@GetMapping("/showformforupdate")
	public String showformforupate(@RequestParam("customerId") int Id,Model themodel) {
		
		//get the customer
		
		Customer thecustomer = service.getcustomer(Id);
		
		//add to the model
		
		themodel.addAttribute("customer",thecustomer);
		
		return "customer-form";
	}
	@GetMapping("/showformfordelete")
	public String showformfordelete(@RequestParam("customerId") int Id,Model themodel) {
	service.deleteCutomer(Id);
		
		//redirecting to list view
		return "redirect:/customer/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
