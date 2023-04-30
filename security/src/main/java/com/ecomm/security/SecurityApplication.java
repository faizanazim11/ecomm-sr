package com.ecomm.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecomm.security.listeners.LoggingListener;

@SpringBootApplication
public class SecurityApplication {

	
	/**
	 * The main function is the entry point of a Java application.
	 * It's responsible for creating and starting the Spring Boot application.
	 
	 *
	 * @param String[] args Pass arguments to the application
	 *
	 * @return Void
	 *
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SecurityApplication.class);
		app.addListeners(new LoggingListener());
		app.run(args);
	}

}
