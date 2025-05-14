package com.sample.wordcount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.wordcount.dto.InputDto;
import com.sample.wordcount.dto.ResponseDto;
import com.sample.wordcount.service.WordCountService;

@RestController
@RequestMapping(path = "/wordcount", produces = {MediaType.APPLICATION_JSON_VALUE})
public class WordCountRestController {

	@Autowired
	WordCountService  wService;

	@GetMapping("/numberofwords")
	public ResponseEntity<ResponseDto> getWordCountWithChar(
						@RequestBody InputDto iDto, 		
						@RequestParam (defaultValue = "M", required = false) String inputchar){
		
		Long wordCount=wService.getWordCount( inputchar, iDto);
		
		ResponseDto respDto = new ResponseDto(inputchar, wordCount, null, null );
		return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
	}
	
	@GetMapping("/words" )
	public ResponseEntity<ResponseDto> getWordsWithMinSize(
						@RequestBody InputDto iDto, 		
						@RequestParam (defaultValue = "5") String minSize){
		
		List<String> words=wService.getWordsWithMinSize( minSize, iDto);
		ResponseDto respDto = new ResponseDto(null, null, minSize, words );
		
		return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/summary")
	public ResponseEntity<ResponseDto> getSummary(
						@RequestBody InputDto iDto, 
						@RequestParam (defaultValue = "M", required = false) String inputchar,
						@RequestParam (defaultValue = "5", required = false) String length){
		
		String inputLength = length.isEmpty() ? "5" : length;
		String startingChar = inputchar.isEmpty() ? "M" : inputchar;
		
		System.out.println("Input Lem "+inputLength+" inpuChar="+inputchar);
		
		List<String> words=wService.getWordsWithMinSize( length, iDto);
		
		Long wordCount=wService.getWordCount( inputchar, iDto);

		ResponseDto respDto = new ResponseDto(startingChar, wordCount, inputLength, words );
		
		return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
	}
	
	
}
