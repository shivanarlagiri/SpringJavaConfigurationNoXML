package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mylogger.properties")
public class SportConfig {

	//create beans/
	@Bean
	public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
			@Value("${printed.logger.level}") String printedLoggerLevel) {
		
		MyLoggerConfig myLogger=new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
		return myLogger;
	}
	
	
	//add the fortune service bean
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
		
	} 
	
	//Here fortuneservice is dependency injected into swimcoach object
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
}
