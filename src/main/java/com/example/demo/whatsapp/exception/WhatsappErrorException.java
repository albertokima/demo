package com.example.demo.whatsapp.exception;

import java.io.Serializable;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "error" })
@Generated("jsonschema2pojo")
public class WhatsappErrorException implements Serializable {

	private final static long serialVersionUID = -8661631460844846172L;

	@JsonProperty("error")
	private Error error;

	public WhatsappErrorException(Integer code, String status) {
		this.error = new Error();
		this.error.setCode(code);
		this.error.setMessage(status);
		this.error.setType("OAuthException");
	}
	
	public WhatsappErrorException() {
	}

	@JsonProperty("error")
	public Error getError() {
		return error;
	}

	@JsonProperty("error")
	public void setError(Error error) {
		this.error = error;
	}

}