package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;

public class CreateCoursesDemo {

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
		
		
		Course temp1= new Course("Guitar");
		
		Course temp2= new Course("Games");
		
		//Adding the courses to Instructor
		inst.addCourse(temp1);
		inst.addCourse(temp2);
		
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
