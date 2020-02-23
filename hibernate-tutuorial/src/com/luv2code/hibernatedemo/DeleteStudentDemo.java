package com.luv2code.hibernatedemo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		//Student theStudent = new Student("Daffy","Duck","daffy@email.com");
				
		try {

			
		session.beginTransaction();

		session.createQuery("delete from Student where firstname='Daffy'").executeUpdate();
		
		//session.save(theStudent);
		session.getTransaction().commit();
		
		session = factory.getCurrentSession();
		session.beginTransaction();

		Student mystudent = session.get(Student.class, 6);
		
		session.delete(mystudent);
		
		session.getTransaction().commit();

		
		
		}
		finally {
			factory.close();
		}
		

	}

}
