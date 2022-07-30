package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	
	private FortuneService fortuneService;
	
	
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Swim team  " + team+" with email id "+email+" have 100 meters swimming warmup everyday";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
