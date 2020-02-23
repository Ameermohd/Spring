package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;
import com.luv2code.hibernatedemo.entity.Review;
import com.luv2code.hibernatedemo.entity.Student;

public class CreateStudentsCourseDemo {

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
		
		//get the Course
		int id=10;
		
		Course temp1 = session.get(Course.class, id);
		
		Course temp2 = session.get(Course.class, 11);
		
		Student st1 = new Student("Donal","Duck","dduck@gmail.com");
		
		Student st2 = new Student("Micky","Mouse","Mouse@gmail.com");
		
		Student st3 = new Student("Scooby","Dog","Dog@gmail.com");
		
		//Adding courses to students
		st1.addCourse(temp1);
		
		st2.addCourse(temp2);

		st3.addCourse(temp1);
		
		st3.addCourse(temp2);
		
		//Adding the courses to Instructor
		
		session.save(st1);
		session.save(st2);
		session.save(st3);
		
		
		
		session.getTransaction().commit();

		
		session = factory.getCurrentSession();
		
		
		
		
		
		}
		finally {
			factory.close();
		}
		

	}

}
