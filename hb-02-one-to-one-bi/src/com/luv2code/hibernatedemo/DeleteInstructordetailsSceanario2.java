package com.luv2code.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.Instructordetail;

public class DeleteInstructordetailsSceanario2 {

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
		
		Instructordetail temp = session.get(Instructordetail.class, 8);
		
		//In this scenario we are trying to delete instructor detail
		//but want to retain instructor  
		//Note: change cascade type, remove cascade type all
		if(temp!=null)
		{
			System.out.println(temp.getInstructor());
			temp.getInstructor().setInstructorDetail(null);//Removing the reference link
			//So that we can remove the detail otherwise we cannot remove the detail
			//as the Instructor and detail are linked together
			session.delete(temp);
		}
		session.getTransaction().commit();
		
		}
		finally {
			session.close();//Memory leak
			factory.close();
		}
		

	}

}
