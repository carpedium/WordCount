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
 * @see com.sample.wordcount.controller.WordCountRestController#getWordsWithMinSize(InputDto,
 *      Integer)
 * 
 * @author Ankit Kumar Singh
 */

@JsonInclude(Include.NON_NULL)

@Data
@AllArgsConstructor
public class ListWordResponseDto {

	@Schema(
			name = "minLength", 
			description = "Input min length of String that would be used to get result set. if not provided, default value 5 would be used",
			example = "5")
	Integer minLength;

	@Schema(
			name = "wordsWithSize", 
			description = "Result list of words with min length as specified in input (default=5)",
			example = "[ \"word_1\" , \"word_2\" ]")
	List<String> wordsWithSize;

}
