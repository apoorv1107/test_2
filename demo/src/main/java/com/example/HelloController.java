package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String sayHello(String name){
		System.out.println("testing GIT");
		return "hello "+name;
		
	}
}
