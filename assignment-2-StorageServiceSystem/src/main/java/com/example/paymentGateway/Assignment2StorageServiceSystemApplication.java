package com.example.paymentGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assignment2StorageServiceSystemApplication {

	public static void main(String[] args) {
		ApplicationContext	context = SpringApplication.run(Assignment2StorageServiceSystemApplication.class, args);
		
		StroageService defaultStroage = context.getBean(StroageService.class);
		defaultStroage.storeFile("Assignment.txt");
		
		StroageService localStroage1 = context.getBean("localStorage", StroageService.class);
		StroageService localStroage2 = context.getBean("localStorage", StroageService.class);	
	}
}
