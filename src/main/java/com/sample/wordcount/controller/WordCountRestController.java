package com.sample.wordcount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.wordcount.dto.ErrorResponseDto;
import com.sample.wordcount.dto.InputDto;
import com.sample.wordcount.dto.ListWordResponseDto;
import com.sample.wordcount.dto.SummaryResponseDto;
import com.sample.wordcount.dto.WordCountResponseDto;
import com.sample.wordcount.service.WordCountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@Tag(name = "REST APIs for Word Operations", description = "Provides API to Counts or filter Input Words that conform to business rules like minimum size, starting chars etc.")
@RestController
@RequestMapping(path = "/wordcount", produces = { MediaType.APPLICATION_JSON_VALUE })
public class WordCountRestController {

	@Autowired
	WordCountService wService;

	
	@Operation(summary = "get words with input size", 
			description = "Returns List of words with size >= specified input value. Default size=5")
	@ApiResponses({

			@ApiResponse(responseCode = "200", description = "Returns List of words with size >= specified value.", content = @Content(schema = @Schema(implementation = ListWordResponseDto.class))),
			@ApiResponse(responseCode = "500", description = "Input Error Code and Message", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) }
	)
	@PostMapping("/words")
	public ResponseEntity<ListWordResponseDto> getWordsWithMinSize(
			@Valid @RequestBody InputDto iDto,
			@RequestParam(name = "minlen",  defaultValue = "5") Integer minSize) {

		ListWordResponseDto respDto = wService.getWordsWithMinSize(minSize, iDto);
		return new ResponseEntity<ListWordResponseDto>(respDto, HttpStatus.OK);

	}
	
	
	
	@Operation(summary = "Count no of words", description = "Counts number of input words with specified starting char(s). Default starting char=M")
	@ApiResponses({

			@ApiResponse(responseCode = "200", description = "Returns number of words with specified starting char(s)", content = @Content(schema = @Schema(implementation = WordCountResponseDto.class))),
			@ApiResponse(responseCode = "500", description = "Input Error Code and Message", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) }
	)
	@PostMapping("/numberofwords")
	public ResponseEntity<WordCountResponseDto> getWordCountWithChar( 
			@Valid @RequestBody InputDto iDto,
			@RequestParam(name = "prefix", defaultValue = "M", required = false) String startingChar) {

		WordCountResponseDto respDto = wService.getWordCount(startingChar, iDto);
		return new ResponseEntity<WordCountResponseDto>(respDto, HttpStatus.OK);
	}

	

	@Operation(summary = "Summary operation", description = "This operation is a consolidation of /words and /numberofwords api. Please refer to respective endpoint Documentation for more details")
	@ApiResponses({

			@ApiResponse(responseCode = "200", description = "Returns result of both /words and /numberofwords operations", content = @Content(schema = @Schema(implementation = SummaryResponseDto.class))),
			@ApiResponse(responseCode = "500", description = "Input Error Code and Message", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) }
	)
	@PostMapping("/summary")
	public ResponseEntity<SummaryResponseDto> getSummary(
			@Valid @RequestBody InputDto iDto,
			@RequestParam(name = "prefix", defaultValue = "M", required = false) String inputchar,
			@RequestParam(name = "minlen",  defaultValue = "5", required = false) Integer length) {

		SummaryResponseDto respDto = wService.getSummary(iDto, inputchar, length);
		return new ResponseEntity<SummaryResponseDto>(respDto, HttpStatus.OK);
	}

}
