package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController(value = "webhook")
public class DemoApplication {

	@GetMapping
	public String home(HttpServletRequest request, @RequestBody String body) {
		System.out.println(request.toString());
		System.out.println(body);
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
