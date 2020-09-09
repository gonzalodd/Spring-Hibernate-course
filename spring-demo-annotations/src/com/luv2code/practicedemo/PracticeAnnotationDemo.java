package com.luv2code.practicedemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationDemo {

	public static void main(String[] args) {
		
		// read the config xml file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("practiceApplicationContext.xml");
		
		// retireve the bean from the container
		Coach theCoach = context.getBean("basketballCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
