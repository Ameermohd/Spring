package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer thecustomer);

	public Customer getcustomer(int id);

	public void deleteCustomer(int id);

}
