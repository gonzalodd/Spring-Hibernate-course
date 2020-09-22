package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {
	
	public static void main(String[] args) {
		
		// 	create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			// begin transaction
			session.beginTransaction();
			
			// get the instructor details object
			
			int theId = 2;
			InstructorDetail  tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("tempsInstrucorDetail: " 
								+ tempInstructorDetail);
					
			// print the associated instructor
			System.out.println("the associated instructor: " + 
								tempInstructorDetail.getInstructor());
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		finally {
			
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
		
	}

}
