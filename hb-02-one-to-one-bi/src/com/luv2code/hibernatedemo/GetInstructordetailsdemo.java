package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;

public class GetInstructordetailsdemo {

	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructordetail.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
	
		
		try {
		session.beginTransaction();

		//session.createQuery("delete from Instructor where id='2'").executeUpdate();
		
		Instructordetail temp =session.get(Instructordetail.class, 4);
		
		System.out.println(temp);
		
		System.out.println("\n\n=============");
		if(temp!=null)
		{
			System.out.println(temp.getInstructor());
		}
		session.getTransaction().commit();
		
		}
		finally {
			session.close();//Memory leak
			factory.close();
		}
		

	}

}
