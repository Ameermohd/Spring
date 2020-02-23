package com.luv2code.hibernatedemo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
				
		try {
		session.beginTransaction();

		session.createQuery("update Student s set firstname ='Gogeta' where s.firstname='AA'").executeUpdate();
		
		session.getTransaction().commit();
		
		
		}
		finally {
			factory.close();
		}
		

	}

}
