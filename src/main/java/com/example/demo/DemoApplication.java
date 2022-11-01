package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController(value = "webhook")
public class DemoApplication {

	@GetMapping
	public ResponseEntity<?> home(HttpServletRequest request, @RequestParam String mode, @RequestParam String challenge, @RequestParam String token) {
		System.out.println("mode: " + mode + " - challenge: " + challenge + "verify_token: " + token);
		return ResponseEntity.ok().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
