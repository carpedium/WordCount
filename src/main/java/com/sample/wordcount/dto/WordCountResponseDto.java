package com.sample.wordcount.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Response DTO to be used in /numberofwords operation
 * 
 * @see com.sample.wordcount.controller.WordCountRestController#getWordCountWithChar(InputDto,
 *      String)
 * 
 * @author Ankit Kumar Singh
 */
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class WordCountResponseDto {

	@JsonProperty("prefix")
	@Schema(name = "prefix", description = "Starting char (case-insensitive) to check against input strings (default=M/m). " , example = "A")
	String startPrefix;

	@JsonProperty("wordCountStartingWithInputChar")
	@Schema(name ="wordCountStartingWithInputChar", description = "No of words starting with given input char", example = "10")
	Long wordCountStartingWithInputChar;
}
