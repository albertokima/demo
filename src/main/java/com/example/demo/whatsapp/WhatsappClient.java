package com.example.demo.whatsapp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.whatsapp.exception.WhatsappErrorException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;

@Component
public class WhatsappClient {

	private static final String authToken = "EABZCZAzT6fLAUBAGI5ZBVHxAdl6zXWGw78uxKMAQ7fEPkaFTa718u49OQJNtzaaZCYIClKZB9moM0qOFJDeWHuwZByCU86EuUZCBimcU5LlcZBuWnhsh3xgGETVCtH75moSFQheCHffHdWIPiXyaUGAyP0QYdSAf4jHp70HARZBLfKPguGNVjS5MCoxnD3cZCYFMIhEwRIgYx36iHpgdOHxJu4wiX834yw0iUZD";
	private static final String version = "v15.0";
	private static final String phoneNumberId = "110483841864847";

	public ObjectNode enviarMensagem(Object request) {
		HttpHeaders headers = new HttpHeaders();
	    //headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	    //headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
	    headers.set("Authorization", "Bearer " + authToken);
	    final HttpEntity<Object> entity = new HttpEntity<Object>(request, headers);
	    //System.out.println(entity.getHeaders());
	    //System.out.println(entity.getBody());
		String url = "https://graph.facebook.com/{version}/{phone-id}/messages";
		RestTemplate template = new RestTemplate();
		try {
			ResponseEntity<ObjectNode> response = template.exchange(url, HttpMethod.POST, entity, ObjectNode.class, version, phoneNumberId);
			//System.out.println(response);
			return response.getBody();
		} catch (HttpStatusCodeException e) {
			String body = e.getResponseBodyAsString();
			System.err.println(body);
			WhatsappErrorException wee = new WhatsappErrorException();
			if (body == null || body.length()==0) {
				wee = new WhatsappErrorException(e.getRawStatusCode(), e.getStatusText());
			} else {
				wee = new Gson().fromJson(body, WhatsappErrorException.class);
			}
	        final ObjectMapper mapper = new ObjectMapper();
	        final ObjectNode root = mapper.createObjectNode();
	        root.set("error", mapper.convertValue(wee.getError(), JsonNode.class));			
			return root;
		}
	}

}
