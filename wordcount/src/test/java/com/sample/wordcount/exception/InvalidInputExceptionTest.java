package com.sample.wordcount.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.wordcount.exception.types.InvalidInputException;

@SpringBootTest
public class InvalidInputExceptionTest {

	@Test
	@DisplayName("getSummary 1 : test with default char=M, Len=5")
	public void test_InvalidInputExceptionTest() throws Exception {

		InvalidInputException ex = new InvalidInputException(ErrorConstants.REQUEST_BODY_EMPTY_CODE, ErrorConstants.REQUEST_BODY_EMPTY_MSG);
		
		assertTrue((ex.getErrorCode().equals(ErrorConstants.REQUEST_BODY_EMPTY_CODE)) && (ex.getMessage().equals(ErrorConstants.REQUEST_BODY_EMPTY_MSG)));

	}

}
