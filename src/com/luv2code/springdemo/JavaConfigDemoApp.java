package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {


		//create context
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean
		Coach theCoach=context.getBean("swimCoach", Coach.class);
		
		//call the methods
		System.out.println("get workout:: "+theCoach.getDailyWorkout());
		
		System.out.println("get Fortune::: "+ theCoach.getDailyFortune());
		
		//close the context.
		context.close();

	}

}
