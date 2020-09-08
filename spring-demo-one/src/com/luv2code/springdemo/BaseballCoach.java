package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	// define a private field for the dependecy
	private FortuneService fortuneService;
	
	// define the constructor for the dependecy injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortunte() {
		
		// use my fortuneService to give the fortune 
		
		return fortuneService.getFortune();
	}
	
}
