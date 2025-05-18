package com.sample.wordcount.exception;

public class ErrorConstants {
	
	private ErrorConstants() {}

	public static final String REQUEST_BODY_INVALID_CODE = "ERR02";
	public static final String REQUEST_BODY_INVALID_MSG = "Request Body is incorrect. Please refer to Readme.md";
	
	public static final String REQUEST_BODY_EMPTY_CODE = "ERR00";
	public static final String REQUEST_BODY_EMPTY_MSG  = "Request Body is Empty";
	
	public static final String INPUT_LIST_EMPTY_CODE = "ERR01";
	public static final String INPUT_LIST_EMPTY_MSG  = "There are no words in the input";
	public static final String INPUT_LIST_NULL_MSG = "Input List is Null";
	
	public static final String UNKNOWN_ERROR_CODE = "ERR500";
	public static final String UNKNOWN_ERROR_MSG = "Unknown Error";
	
	
}
