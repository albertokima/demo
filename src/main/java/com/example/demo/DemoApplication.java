package com.example.demo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController(value = "webhook")
public class DemoApplication {

	@GetMapping
	public ResponseEntity<String> home(HttpServletRequest request, @RequestHeader Map<String,String> hub) {
		System.out.println("mode: " + hub.get("mode") + " - challenge: " + hub.get("challenge") + "verify_token: " + hub.get("verify_token"));
		return ResponseEntity.ok("demo");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
