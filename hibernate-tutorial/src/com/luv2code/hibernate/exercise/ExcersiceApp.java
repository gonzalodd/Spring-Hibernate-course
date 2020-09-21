package com.luv2code.hibernate.exercise;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.exercise.entity.Employee;

public class ExcersiceApp {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		/*
		// Creo nuevos empleados
		Employee emp1 = new Employee("Leandro", "Medina", "Atos");
		Employee emp2 = new Employee("Gaston", "Sturla", "Mercado Libre");
		Employee emp3 = new Employee("Marcelo", "Serrano", "Prisma Medios de Pagos");
		Employee emp4 = new Employee("Sebastian", "Francisco", "Finnegans");
		
		// Guardo los empleados en la BD
		session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		
		session.getTransaction().commit();*/
		
		// Recupero un objeto de la base de datos por prymary key
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		int id = 7;
		
		Employee myEmployee = session.get(Employee.class, id);
		
		System.out.println("Get complete: " + myEmployee.toString());
		
		session.getTransaction().commit();
		
		// Busco empleado por companía
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.createQuery("from Employee where company = 'Atos' ");
		
		
	}

}
