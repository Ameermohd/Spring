package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;

public class CreateDemo {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructordetail.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		Instructor theInstructor = new Instructor("Darling", "Duck", "daffy@luv2code.com");
		
		Instructordetail theInstructordetail = new Instructordetail("Daffydarling","Swimming");		
		
		theInstructor.setInstructorDetail(theInstructordetail);
		
		theInstructordetail.setInstructor(theInstructor);
		
		
		
		try {
		session.beginTransaction();
		
		//This will also save Instructor 
		//beacuse of CascadeType.ALL and
		//In this scenario we are using Bi-Directional mapping
		session.save(theInstructordetail);
		
		session.getTransaction().commit();		
		session = factory.getCurrentSession();
		
		
		}
		finally {
			factory.close();
		}
		

	}

}
