package com.sample.wordcount.exception.types;

public class InvalidInputException extends RuntimeException {
	private String errorCode;
	
	public InvalidInputException(String code, String msg) {
		super(msg);
		this.errorCode=code;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
