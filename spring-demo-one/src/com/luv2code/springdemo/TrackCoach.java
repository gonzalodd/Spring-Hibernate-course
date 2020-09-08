package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	// define a private field for the dependecy
	private FortuneService fortuneService;
	
	// define the constructor for the dependecy injection
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	public TrackCoach() {
		
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortunte() {
		
		// use my fortuneService to give the fortune 
		
		return "Just Do It: " + fortuneService.getFortune();
	}

}
