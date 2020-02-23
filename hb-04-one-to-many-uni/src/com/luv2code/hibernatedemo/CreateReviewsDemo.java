package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;
import com.luv2code.hibernatedemo.entity.Review;

public class CreateReviewsDemo {

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
		
		//get the Course
		int id=12;
		
		Course theCourse = session.get(Course.class, id);
		
		Review temp1 = new Review("Nice!");
		
		Review temp2 = new Review("Awesome!");
		
		//Adding the reviews to course
		theCourse.addReview(temp1);
		theCourse.addReview(temp2);
	
		//saving it in db
		session.save(temp1);
		session.save(temp2);
		
		
		
		session.getTransaction().commit();

		
		session = factory.getCurrentSession();
		
		
		
		
		
		}
		finally {
			factory.close();
		}
		

	}

}
