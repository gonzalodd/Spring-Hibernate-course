package com.luv2code.practicedemo;

import com.luv2code.practicedemo.FortuneService;

public class VolleyballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public VolleyballCoach(FortuneService fortuneService2) {
		System.out.println(">> BasketballCoach: inside default constructor");
		fortuneService = fortuneService2;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your pass for 20 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
