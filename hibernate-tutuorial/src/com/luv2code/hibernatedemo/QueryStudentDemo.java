package com.luv2code.hibernatedemo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		
		try {
		session.beginTransaction();
		
		List<Student> theStudents = session.createQuery("from Student s where s.lastname LIKE '%Duck%'").getResultList();
		session.getTransaction().commit();
		
		for(Student temp: theStudents)
		{
		System.out.println(temp);
		}
		
		}
		finally {
			factory.close();
		}
		

	}

}
