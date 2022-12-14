package com.example.demo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.whatsapp.WhatsappClient;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private WhatsappClient waba;
	
	private static final String verify_token = "demo";

	@GetMapping("/webhook")
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

	@PostMapping("/webhook")
	public ResponseEntity<?> home(HttpServletRequest request, @RequestBody Object entry) {
		try
		{
			Gson gson = new Gson();
			for(Entry<String, JsonElement> json: gson.toJsonTree(entry).getAsJsonObject().entrySet()) {
				System.out.println(json.getKey() + ":" + json.getValue());
			}
			//System.out.println(entry);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}				
		return ResponseEntity.ok().build();
	}

	@PostMapping("whatsapp")
	public ResponseEntity<?> whatsapp(HttpServletRequest request, @RequestBody Object message) {
		return ResponseEntity.ok(waba.enviarMensagem(message));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
