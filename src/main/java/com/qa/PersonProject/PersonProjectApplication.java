package com.qa.PersonProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class PersonProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonProjectApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, its me!";
	}

	@GetMapping("/helloyou")
	public String sayHelloYou(@RequestParam(name = "firstName", defaultValue = "World")String firstName) {
		return String.format("Hello, its me! %s", firstName);
	}

	@GetMapping("/fullname")
	public String sayHelloName(
			@RequestParam(name = "firstName", defaultValue = "World") String firstName,
			@RequestParam(name = "lastName", defaultValue = "Doe") String lastName) {
		return String.format("Hello, its me! %s %s", firstName, lastName);
	}


}
