package com.ecomm.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecomm.security.listeners.LoggingListener;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SecurityApplication.class);
		app.addListeners(new LoggingListener());
		app.run(args);
	}

}
