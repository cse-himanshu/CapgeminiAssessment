package com.example.paymentGateway;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("coloudStorage")
@Primary
@Scope("singleton")
public class CloudStorageService implements StroageService{
	public CloudStorageService() {
		System.out.println("CloudStorageService Bean Created.");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("CloudStorageSerivce Bean Initialized");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("File Stored in Cloud Storage: " + fileName);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("CloudStorageService Bean Destroyed");
	}
}
