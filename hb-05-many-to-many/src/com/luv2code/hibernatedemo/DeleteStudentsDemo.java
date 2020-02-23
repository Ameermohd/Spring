package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;
import com.luv2code.hibernatedemo.entity.Review;
import com.luv2code.hibernatedemo.entity.Student;

public class DeleteStudentsDemo {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructordetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		
		
		try {
		session.beginTransaction();
		
		int id=2;
		
		Student st1 = session.get(Student.class, id);
		session.delete(st1);
		
		session.getTransaction().commit();	
		}
		finally {
			factory.close();
		}
		

	}

}
