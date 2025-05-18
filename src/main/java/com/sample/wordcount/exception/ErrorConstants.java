package com.sample.wordcount.exception;

public interface ErrorConstants {

	String REQUEST_BODY_INVALID_CODE = "ERR02";
	String REQUEST_BODY_INVALID_MSG = "Request Body is incorrect. Please refer to Readme.md";
	
	String REQUEST_BODY_EMPTY_CODE = "ERR00";
	String REQUEST_BODY_EMPTY_MSG  = "Request Body is Empty";
	
	String INPUT_LIST_EMPTY_CODE = "ERR01";
	String INPUT_LIST_EMPTY_MSG  = "There are no words in the input";
	String INPUT_LIST_NULL_MSG = "Input List is Null";;
	
	String UNKNOWN_ERROR_CODE = "ERR500";
	String UNKNOWN_ERROR_MSG = "Unknown Error";
	
	
}
