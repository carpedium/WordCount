package com.sample.wordcount.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Response DTO to be used in /numberofwords operation
 * 
 * @see com.sample.wordcount.controller.WordCountRestController#getWordCountWithChar(InputDto, String)
 * 
 * @author Ankit Kumar Singh
 */
@Data @AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class WordCountResponseDto {

	@Schema(name = "Starting character", example = "A"  )
	String startingChar;
	
	@Schema(name = "No of Words Starting with given Char", example = "10")
	Long wordCountStartingWithInputChar;
	
	/*
	 * public WordCountResponseDto() { super(); }
	 * 
	 * 
	 * public WordCountResponseDto(String inputChar, Long
	 * wordCountStartingWithInputChar ) { super(); this.startingChar = inputChar;
	 * this.wordCountStartingWithInputChar = wordCountStartingWithInputChar; }
	 * 
	 * 
	 * public String getInputChar() { return startingChar; }
	 * 
	 * 
	 * public void setInputChar(String inputChar) { this.startingChar = inputChar; }
	 * 
	 * 
	 * public Long getWordCountStartingWithInputChar() { return
	 * wordCountStartingWithInputChar; }
	 * 
	 * 
	 * public void setWordCountStartingWithInputChar(Long
	 * wordCountStartingWithInputChar) { this.wordCountStartingWithInputChar =
	 * wordCountStartingWithInputChar; }
	 */

	}
