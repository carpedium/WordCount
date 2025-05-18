package com.sample.wordcount.dto;

import java.util.List;

import com.sample.wordcount.exception.ErrorConstants;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Input DTO required to capture User Input in RequestBody
 * 
 * @see com.sample.wordcount.controller.WordCountRestController#getWordCountWithChar(InputDto,
 *      String)
 * @see com.sample.wordcount.controller.WordCountRestController#getWordsWithMinSize(InputDto,
 *      Integer)
 * @see com.sample.wordcount.controller.WordCountRestController#getSummary(InputDto,
 *      String, Integer)
 * 
 * @author Ankit Kumar Singh
 */
@Data
@AllArgsConstructor
public class InputDto {

	@Schema(
			name = "inputList", 
			description = "List of Input words. a sentence with multiple words like \"word_3 word_4\" in example is also valid",
			example = "[ \"mama\", \"momo\", \"maka m@123\" ]")
	@NotNull(message = ErrorConstants.INPUT_LIST_NULL_MSG)
	@NotEmpty(message = ErrorConstants.INPUT_LIST_EMPTY_MSG)
	List<String> inputList;

}
