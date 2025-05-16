package com.sample.wordcount.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * Custom ErrorDto Required to pass on custom Error Code and messages in Response Body
 * 
 * @see com.sample.wordcount.exception.CustomExceptionHandler#handleInvalidInputException(com.sample.wordcount.exception.types.InvalidInputException)
 * 
 * @author Ankit Kumar Singh
 */
@AllArgsConstructor @Data
public class ErrorResponseDto {

	@Schema(name = "App Error Code", example = "ERR00X"  )
	String errorCode;

	@Schema(name = "App Error Msg", example = "Error Message"  )
	String errorMessage;
	
	/*
	 * public ErrorResponseDto(String errorCode, String errorMessage) { super();
	 * this.errorCode = errorCode; this.errorMessage = errorMessage; }
	 * 
	 * public String getErrorCode() { return errorCode; }
	 * 
	 * public void setErrorCode(String errorCode) { this.errorCode = errorCode; }
	 * 
	 * public String getErrorMessage() { return errorMessage; }
	 * 
	 * public void setErrorMessage(String errorMessage) { this.errorMessage =
	 * errorMessage; }
	 */
}
