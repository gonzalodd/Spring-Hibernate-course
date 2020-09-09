package com.luv2code.practicedemo;

public class UnluckyFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "This is not your lucky day! :/";
	}
	
	
}
