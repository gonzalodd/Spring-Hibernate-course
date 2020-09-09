package com.luv2code.practicedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;
	
	public BasketballCoach() {
		System.out.println(">> BasketballCoach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your shoots for 10 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
