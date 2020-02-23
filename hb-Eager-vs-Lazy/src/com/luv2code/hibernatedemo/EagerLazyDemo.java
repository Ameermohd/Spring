package com.luv2code.hibernatedemo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		
		
		try {
		session.beginTransaction();
		
		//get the Instructor
		int id=5;
		Instructor inst = session.get(Instructor.class, id);
		
		session.getTransaction().commit();	
		
		System.out.println(inst.getCourse());//Due to Eager Loading
		//we can fetch data even after the session is closed
		//because everything is already loaded

		}
		finally {
			factory.close();
		}
		

	}

}
