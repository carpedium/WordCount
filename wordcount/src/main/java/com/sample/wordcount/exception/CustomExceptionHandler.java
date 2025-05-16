package com.sample.wordcount.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sample.wordcount.dto.ErrorResponseDto;
import com.sample.wordcount.exception.types.InvalidInputException;

/**
 * Custom Exception Handler for all the Exceptions in the application
 * 
 * @see com.sample.wordcount.exception.CustomExceptionHandler#handleInvalidInputException(com.sample.wordcount.exception.types.InvalidInputException)
 * 
 * @author Ankit Kumar Singh
 */

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	/* Takes care of Any Field Level Validations */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, String> validationErrors = new HashMap<>();
		List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

		validationErrorList.forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String validationMsg = error.getDefaultMessage();
			validationErrors.put(fieldName, validationMsg);
		});
		return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
	}
	
	
	/* CustomHandling of Custom Exception */
	@ExceptionHandler(value = { InvalidInputException.class })
	public ResponseEntity<ErrorResponseDto> handleInvalidInputException(InvalidInputException e) {

		ErrorResponseDto errDto = new ErrorResponseDto(e.getErrorCode(), e.getMessage());
		return new ResponseEntity<ErrorResponseDto>(errDto, HttpStatus.BAD_REQUEST);

	}
	
	
	/* CustomHandling of All Unknown Exceptions */	
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorResponseDto> handleAllException(Exception e) {
		ErrorResponseDto errDto = new ErrorResponseDto(ErrorConstants.UNKNOWN_ERROR_CODE, ErrorConstants.UNKNOWN_ERROR_MSG);
		return new ResponseEntity<ErrorResponseDto>(errDto, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	

}
