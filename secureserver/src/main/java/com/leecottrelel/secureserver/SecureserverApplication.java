package com.leecottrelel.secureserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.tomcat.util.codec.binary.Base64;


@RestController	
@SpringBootApplication
public class SecureserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureserverApplication.class, args);
	}
	private String userName;
	private String password;
	private boolean validatePassword(String auth){
		boolean valid = false;
		String userPass = auth.substring(6);	//why 6? - strip BASIC out
		byte[] decryptArray = Base64.decodeBase64(userPass);
		String decryptString = new String(decryptArray);
		int colon = decryptString.indexOf(":");	//find location of colon
		userName = decryptString.substring(0, colon);
		password = decryptString.substring(colon+1);
		if(userName.equalsIgnoreCase("lee") && password.equals("5d41402abc4b2a76b9719d911017c592")){
			valid = true;
		}
		else{		
			valid = false;
		}
		return valid;	
	}

	@GetMapping(value="/")
	public ResponseEntity<String> GetMethod(@RequestHeader("Authorization") String auth) {

		
		if(validatePassword(auth)){
			//do your code here
			return new ResponseEntity<String>("Welcome " + userName, HttpStatus.ACCEPTED);
		}
		else{
			return new ResponseEntity<String> ("Not authorized, go away!", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
		}
	}
	

}
