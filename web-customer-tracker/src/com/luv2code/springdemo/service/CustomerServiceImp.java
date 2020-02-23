package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.sun.xml.internal.ws.developer.Serialization;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	public CustomerDAO customerdao;
	
	@Override
	@Transactional
	public List<Customer> getcustomers() {
		
		return customerdao.getCustomers();
	}

	
	@Transactional
	@Override
	public void saveCustomer(Customer thecustomer) {
	
		customerdao.saveCustomer(thecustomer);
		
		
	}


	@Override
	@Transactional
	public Customer getcustomer(int id) {
		return customerdao.getcustomer(id);
	}


	@Override
	@Transactional
	public void deleteCutomer(int id) {
		customerdao.deleteCustomer(id);
	}

}
