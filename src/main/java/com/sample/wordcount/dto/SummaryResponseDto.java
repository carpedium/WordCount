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

	@Schema(name = "startingChar", description = "Starting char (case-insensitive) to check against input strings (default=M/m). ", example = "A")
	String startingChar;

	@Schema(name = "wordCountStartingWithInputChar", description = "No of words starting with given input char", example = "10")
	Long wordCountStartingWithInputChar;

	@Schema(name = "minLength", description = "Input min length of String that would be used to get result set. if not provided, default value 5 would be used", example = "5")
	Integer minLength;

	@Schema(name = "wordsWithSize", description = "Result list of words with min length as specified in input (default=5)", example = "[ \"word_1\" , \"word_2\" ]")
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

}