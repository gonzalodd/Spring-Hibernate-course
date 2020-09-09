package com.luv2code.practicedemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class VolleyJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracticeSportConfig.class);
		
		// retrieve the bean from spring container
		VolleyballCoach theCoach = context.getBean("volleyballCoach", VolleyballCoach.class);
		
		// call method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
		
	}

}
