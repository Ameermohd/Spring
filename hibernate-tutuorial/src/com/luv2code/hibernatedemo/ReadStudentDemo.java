package com.luv2code.hibernatedemo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Student theStudent = new Student("Daffy","Duck","daffy@email.com");
		
		try {
		session.beginTransaction();
		
		System.out.println(theStudent);
		
		session.save(theStudent);
		
		session.getTransaction().commit();
		
		System.out.println(theStudent);//Hibernate will assign the Student ID after the DB commmit
		
		//New code for retriveing the student object from db
		
		session =factory.getCurrentSession();
		session.beginTransaction();
		
		Student myStudent = session.get(Student.class, theStudent.getId()); //Retriveing the student from DB
		
		System.out.println(myStudent); 
		
		session.getTransaction().commit();
		
		}
		finally {
			factory.close();
		}
		

	}

}
