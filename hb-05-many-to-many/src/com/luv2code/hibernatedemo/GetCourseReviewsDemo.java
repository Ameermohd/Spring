package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;
import com.luv2code.hibernatedemo.entity.Review;

public class GetCourseReviewsDemo {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructordetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		
		
		try {
		session.beginTransaction();
		
		//get the Instructor
		int id=12;
		Course theCourse = session.get(Course.class, id);
		
		System.out.println(theCourse);
		
		System.out.println(theCourse.getReviews());
		
		
		
		session.getTransaction().commit();	
		}
		finally {
			factory.close();
		}
		

	}

}
