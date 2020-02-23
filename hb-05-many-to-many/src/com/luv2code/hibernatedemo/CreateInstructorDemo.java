package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;
import com.luv2code.hibernatedemo.entity.Review;
import com.luv2code.hibernatedemo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructordetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		Instructor theInstructor = new Instructor("Darling", "Darling", "daffy.darling@luv2code.com");
		
		Instructordetail theInstructordetail = new Instructordetail("youtubechannel","youtube");	
		
		theInstructor.setInstructorDetail(theInstructordetail);
		try {
		session.beginTransaction();
		
	
		session.save(theInstructor);
		
		
		session.getTransaction().commit();
		
		}
		finally {
			factory.close();
		}
		

	}

}
