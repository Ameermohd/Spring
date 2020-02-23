package com.luv2code.hibernatedemo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;

public class EagerLazyHQLDemo {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		
		
		try {
		session.beginTransaction();
		
		int theId=5;
		// get courses for a given instructor
        Query<Course> query = session.createQuery("select c from Course c "
                                                + "where c.instructor.id=:theInstructorId",    
                                                Course.class);
        
        query.setParameter("theInstructorId", theId);
        
        List<Course> tempCourses = query.getResultList();
		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Session is Closed");
		System.out.println(tempCourses);//Lazy Loading Even after the session is closed 
		//we are able to get the data because we are using HQL to load 
		//the data in memory
		}
		finally {
			factory.close();
		}
		

	}

}
