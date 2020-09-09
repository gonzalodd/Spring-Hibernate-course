package com.luv2code.practicedemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeSportConfig {
	
	@Bean
	public FortuneService unluckyFortuneService() {
		return new UnluckyFortuneService();
	}
	
	@Bean
	public Coach volleyballCoach() {
		return new VolleyballCoach(unluckyFortuneService());
	}
}
