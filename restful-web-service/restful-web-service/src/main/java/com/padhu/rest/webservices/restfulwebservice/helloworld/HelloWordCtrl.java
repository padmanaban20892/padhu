package com.padhu.rest.webservices.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordCtrl {
	
	@RequestMapping(method=RequestMethod.GET, path="hello-word")
	public String helloWord() {
		return "Hello Word";
	}
	
	
	@GetMapping(path="hello-word-get")
	public HelloWordBean gethelloWord() {
		return new HelloWordBean("Hello World");
	}
	

}
