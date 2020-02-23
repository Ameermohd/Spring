package com.luv2code.hibernatedemo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Student;

public class StudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Student theStudent = new Student("AA","BB","eee@email.com");
		
		try {
		session.beginTransaction();
		
		session.save(theStudent);
		
		session.getTransaction().commit();
		
		
		}
		finally {
			factory.close();
		}
		

	}

}
