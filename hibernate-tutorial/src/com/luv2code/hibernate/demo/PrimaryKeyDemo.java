package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// 	create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create 3 students object
			System.out.println("Creating 3 student object...");
			Student theStudent = new Student("Paul", "Wall", "paul@mail.com");
			Student theStudent2 = new Student("Gonzalo", "Duval", "gonzalo@mail.com");
			Student theStudent3 = new Student("Damian", "Nu�ez", "damian@mail.com");
			
			// begin transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(theStudent);
			session.save(theStudent2);
			session.save(theStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
