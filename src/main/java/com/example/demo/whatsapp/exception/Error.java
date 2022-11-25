package com.example.demo.whatsapp.exception;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "message", "type", "code", "error_data", "error_subcode", "fbtrace_id" })
@Generated("jsonschema2pojo")
public class Error implements Serializable {

	private final static long serialVersionUID = 8314099476550112L;

	@JsonProperty("message")
	private String message;
	@JsonProperty("type")
	private String type;
	@JsonProperty("code")
	private Integer code;
	@JsonProperty("error_data")
	private ErrorData error_data;
	@JsonProperty("error_subcode")
	private Integer error_subcode;
	@JsonProperty("fbtrace_id")
	private String fbtrace_id;

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("code")
	public Integer getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(Integer code) {
		this.code = code;
	}

	public ErrorData getError_data() {
		return error_data;
	}

	public void setError_data(ErrorData error_data) {
		this.error_data = error_data;
	}

	public Integer getError_subcode() {
		return error_subcode;
	}

	public void setError_subcode(Integer error_subcode) {
		this.error_subcode = error_subcode;
	}

	public String getFbtrace_id() {
		return fbtrace_id;
	}

	public void setFbtrace_id(String fbtrace_id) {
		this.fbtrace_id = fbtrace_id;
	}


}
