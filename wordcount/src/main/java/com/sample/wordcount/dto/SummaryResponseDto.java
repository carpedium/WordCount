package com.sample.wordcount.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Response DTO to be used in /summary operation
 * 
 * @see com.sample.wordcount.controller.WordCountRestController#getSummary(InputDto,
 *      String, Integer)
 * 
 * @author Ankit Kumar Singh
 */
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class SummaryResponseDto {

	@Schema(name = "Starting character", example = "A")
	String startingChar;

	@Schema(name = "No of Words Starting with given Char", example = "10")
	Long wordCountStartingWithInputChar;

	@Schema(name = "Input Min length for String", example = "5")
	Integer minLength;

	@Schema(name = "List of words with min length", example = "[ \"word_1\" , \"word_2\" ]")
	List<String> wordsWithSize;

	public SummaryResponseDto() {
		super();
	}

	public SummaryResponseDto(ListWordResponseDto listWordResponseDto, WordCountResponseDto wordCountResponseDto) {
		super();
		this.startingChar = wordCountResponseDto.getStartingChar();
		this.wordCountStartingWithInputChar = wordCountResponseDto.getWordCountStartingWithInputChar();

		this.minLength = listWordResponseDto.getMinLength();
		this.wordsWithSize = listWordResponseDto.getWordsWithSize();
	}

	/*
	 * public String getStartingChar() { return startingChar; }
	 * 
	 * public void setStartingChar(String startingChar) { this.startingChar =
	 * startingChar; }
	 * 
	 * public Long getWordCountStartingWithInputChar() { return
	 * wordCountStartingWithInputChar; }
	 * 
	 * public void setWordCountStartingWithInputChar(Long
	 * wordCountStartingWithInputChar) { this.wordCountStartingWithInputChar =
	 * wordCountStartingWithInputChar; }
	 * 
	 * public Integer getMinLength() { return minLength; }
	 * 
	 * public void setMinLength(Integer minLength) { this.minLength = minLength; }
	 * 
	 * public List<String> getWordsWithSize() { return wordsWithSize; }
	 * 
	 * public void setWordsWithSize(List<String> wordsWithSize) { this.wordsWithSize
	 * = wordsWithSize; }
	 * 
	 */

}