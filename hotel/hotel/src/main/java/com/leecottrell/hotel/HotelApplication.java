package com.leecottrell.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HotelApplication {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<String> getRespond(){
		return new ResponseEntity<String>("<h1>It works</h1>", HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

	

}
