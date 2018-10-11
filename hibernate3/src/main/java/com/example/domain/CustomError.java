package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomError {
	@JsonProperty("field")
	private String field;
	@JsonProperty("code")
	private String code;
	@JsonProperty("params")
	private String[] params;
	@JsonProperty("default_message")
	private String defaultMessage;
	public CustomError() {
		super();
	}
	public CustomError(String field, String code, String[] params, String defaultMessage) {
		super();
		this.field = field;
		this.code = code;
		this.params = params;
		this.defaultMessage = defaultMessage;
	}
	public CustomError(String field, String code, String defaultMessage) {
		super();
		this.field = field;
		this.code = code;
		this.defaultMessage = defaultMessage;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String[] getParams() {
		return params;
	}
	public void setParams(String[] params) {
		this.params = params;
	}
	public String getDefaultMessage() {
		return defaultMessage;
	}
	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
	public static  CustomError[] errorsFromException(Exception e) {
		CustomError error = new CustomError("", "", e.getMessage());
		CustomError[] errors = {error};
		return errors;
	}
}
