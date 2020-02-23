package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository //Spring will find DAO class while component scanning
public class CustomerDAOimpl implements CustomerDAO {

	@Autowired//Injection session factory
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional 
	//Transactional is removed and it is added in serviceimpl class as that class
	//delegates calls to this method
	public List<Customer> getCustomers() {
		
		//get the session
		Session session = sessionFactory.getCurrentSession();
		
		//create query	
		Query<Customer> thequery = session.createQuery("from Customer order by firstname",Customer.class);
		
		//execute query and get resultset
		List<Customer> result = thequery.getResultList();
		
		//return result
		return result;
		
	}

	@Override
	public void saveCustomer(Customer thecustomer) {
		
		//get the session
		Session session = sessionFactory.getCurrentSession();
		
		//Hibernate will save if there is no primary key with the object
		//If the key is there it will update
		session.saveOrUpdate(thecustomer);
		
	}

	@Override
	public Customer getcustomer(int id) {
		//get the session
		Session session = sessionFactory.getCurrentSession();
		
		Customer thecustomer = session.get(Customer.class, id);
		
		return thecustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		//get the session
		Session session = sessionFactory.getCurrentSession();
		
		Customer thecustomer = session.get(Customer.class, id);

		session.delete(thecustomer);
		
	}
	
	

}
