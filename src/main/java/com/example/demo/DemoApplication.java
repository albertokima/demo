package com.example.demo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/webhook")
public class DemoApplication {

	private static final String verify_token = "demo";
	private static final String whatsapp_token = "EABZCZAzT6fLAUBAF8qXZAHnHmAuDfTLcaCFbZAIDBkoGogwtRY7Rpv7lxu40FUvRU5PooANTojZCMHCEEMvLYCeDM38xf0usq1SLOA7vkyEZAaNvGmDmPcqgpoReiyEC81UAH6f7WjESm1zM0VwkZAlEq8RBAnlAwayvstjK6mv9ABZAWUNbEOEwyxrB1WhRNxmhzvqC8hXhSYY5pZCawNksUGqR4S2GeyQIZD";

	@GetMapping
	public ResponseEntity<String> validate(HttpServletRequest request, @RequestParam Map<String,String> hub) {
		hub.entrySet().forEach(h->{
			System.out.println(h.getKey() + ":" + h.getValue());
		});

		// Parse params from the webhook verification request
		String mode = hub.get("hub.mode");
		String token = hub.get("hub.verify_token");
		String challenge = hub.get("hub.challenge");
		
		// Check if a token and mode were sent
		if (mode != null && token != null) {
		    // Check the mode and token sent are correct
			if (mode.equals("subscribe") && token.equals(verify_token)) {
				// Respond with 200 OK and challenge token from the request
				System.out.println("WEBHOOK_VERIFIED");
				return ResponseEntity.ok(challenge);
			} else {
				// Responds with '403 Forbidden' if verify tokens do not match
				return ResponseEntity.status(403).build();
		    }
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping
	public ResponseEntity<?> home(HttpServletRequest request, @RequestBody Object entry) {
		System.out.println(entry.toString());
		try
		{
			Map<String, String> properties = BeanUtils.describe(entry);//Fetching object class details
			for(Map.Entry<String, String> e : properties.entrySet())
				System.out.println(e.getKey() + "->" + e.getValue());
		}
		catch(Exception e)
		{
			System.out.print(e);
		}				
		return ResponseEntity.ok().build();
//		return ResponseEntity.badRequest().build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
