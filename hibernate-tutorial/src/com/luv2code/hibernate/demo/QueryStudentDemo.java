package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// 	create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// begin transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// displays the students
			displayStudents(theStudents);
			
			// query students: lastname='Duval'
			theStudents = session.createQuery("from Student s where s.lastName='Duval'").getResultList();
			
			// displays the students
			System.out.println("\n\nStudents who has last name of Duval");
			displayStudents(theStudents);
			
			// query students: lastName 'Duval' OR fistName='Damian'
			theStudents = session.createQuery("from Student s where s.lastName='Duval'" +
												" OR s.firstName='Damian'").getResultList();
			
			// displays the students
			System.out.println("\n\nStudents who has last name of 'Duval' OR fistName 'Damian'");
			displayStudents(theStudents);
			
			// query students where email LIKE '%mail.com
						theStudents = session.createQuery("from Student s where s.email " +
															"LIKE '%mail.com'").getResultList();
			// displays the students
			System.out.println("\n\nStudents whose email ends with mail.com'");
			displayStudents(theStudents);
									
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
