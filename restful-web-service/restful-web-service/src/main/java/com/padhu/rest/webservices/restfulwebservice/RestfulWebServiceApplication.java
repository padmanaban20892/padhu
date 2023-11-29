package com.padhu.rest.webservices.restfulwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServiceApplication {

	public static void main(String[] args) {
		System.out.println("Main1...");
		SpringApplication.run(RestfulWebServiceApplication.class, args);
	}
	
	public static void main(String arg1, String arg2) {
		System.out.println("Main2...");
		SpringApplication.run(RestfulWebServiceApplication.class, arg1,arg2);
		}

}
