package com.example.demo.whatsapp.exception;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "messaging_product", "details" })
@Generated("jsonschema2pojo")
public class ErrorData implements Serializable {

	private final static long serialVersionUID = 3410525999204008488L;

	@JsonProperty("messaging_product")
	private String messaging_product;
	@JsonProperty("details")
	private String details;

	public String getMessaging_product() {
		return messaging_product;
	}

	public void setMessaging_product(String messaging_product) {
		this.messaging_product = messaging_product;
	}

	@JsonProperty("details")
	public String getDetails() {
		return details;
	}

	@JsonProperty("details")
	public void setDetails(String details) {
		this.details = details;
	}

}
