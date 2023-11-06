package com.leecottrell.azureconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class AzureconnectApplication {
	public static void main(String[] args) {
		SpringApplication.run(AzureconnectApplication.class, args);
	}
	@GetMapping("/")
	String home(){
		return "<h1>Database is alive, visit <a href='/henry'>/henry</a> for the API";
	}
}
