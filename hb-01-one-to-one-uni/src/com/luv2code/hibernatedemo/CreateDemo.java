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
		
		Instructor theInstructor = new Instructor("Daffy", "Duck", "daffy@luv2code.com");
		
		Instructordetail theInstructordetail = new Instructordetail("Daffytube","Swimming");		
		
		theInstructor.setInstructorDetail(theInstructordetail);
		
		
		
		try {
		session.beginTransaction();
		
		//This will also save Instructor detail
		//beacuse of CascadeType.ALL
		session.save(theInstructor);
		
		
		session.getTransaction().commit();

		
		session = factory.getCurrentSession();
		
		session.beginTransaction();

		//session.createQuery("delete from Instructor where id='2'").executeUpdate();
		
		Instructor temp =session.get(Instructor.class, 5);
		
		//session.delete(temp);
		
		session.getTransaction().commit();
		
		}
		finally {
			factory.close();
		}
		

	}

}
