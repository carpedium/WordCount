package com.sample.wordcount.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Response DTO to be used in /words operation
 * 
 * @see com.sample.wordcount.controller.WordCountRestController#getWordsWithMinSize(InputDto, Integer)
 * 
 * @author Ankit Kumar Singh
 */

@JsonInclude(Include.NON_NULL)
	
@Data @AllArgsConstructor
public class ListWordResponseDto {

	@Schema(name = "Input Min length for String", example = "5"  )
	Integer minLength;
	@Schema(name = "List of words with min length", example = "[ \"word_1\" , \"word_2\" ]"  )
	List<String> wordsWithSize;
	
	/*
	 * public ListWordResponseDto() { super(); }
	 * 
	 * 
	 * public ListWordResponseDto( Integer stringLength, List<String> wordsWithSize)
	 * { super();
	 * 
	 * this.minLength = stringLength; this.wordsWithSize = wordsWithSize; }
	 * 
	 * public Integer getStringLength() { return minLength; }
	 * 
	 * 
	 * public void setStringLength(Integer stringLength) { this.minLength =
	 * stringLength; }
	 * 
	 * 
	 * public List<String> getWordsWithSize() { return wordsWithSize; }
	 * 
	 * 
	 * public void setWordsWithSize(List<String> wordsWithSize) { this.wordsWithSize
	 * = wordsWithSize; }
	 * 
	 */
	
}
