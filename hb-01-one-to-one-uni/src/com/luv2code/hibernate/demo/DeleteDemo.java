package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {
	
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
			
			// create objects
			Instructor tempInstructor = 
					new Instructor("Damian", "Nuñez", "dnuñez@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com/dnuñezzz",
							"Play videogames");
			/*
			Instructor tempInstructor = 
					new Instructor("Gonzalo", "Duval", "gduval@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com/gduval",
							"Love to code!!!");
			*/
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// begin transaction
			session.beginTransaction();
			
			// save instructor
			//
			// Note: this will ALSO save the details object because of CascateType.ALL
			//
			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}

}
