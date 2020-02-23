package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getcustomers();
	
	public void saveCustomer(Customer thecustomer);

	public Customer getcustomer(int id);

	public void deleteCutomer(int id);

	
}
