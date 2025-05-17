package com.sample.wordcount.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sample.wordcount.dto.InputDto;
import com.sample.wordcount.dto.ListWordResponseDto;
import com.sample.wordcount.dto.SummaryResponseDto;
import com.sample.wordcount.dto.WordCountResponseDto;
import com.sample.wordcount.exception.ErrorConstants;
import com.sample.wordcount.exception.types.InvalidInputException;

@Service
public class WordCountService {

	private static final String INPUT_LIST_EMPTY_MSG = ErrorConstants.INPUT_LIST_EMPTY_MSG;
	private static final String INPUT_LIST_EMPTY_CODE = ErrorConstants.INPUT_LIST_EMPTY_CODE;
	private static final String REQUEST_BODY_EMPTY_MSG = ErrorConstants.REQUEST_BODY_EMPTY_MSG;
	private static final String REQUEST_BODY_EMPTY_CODE = ErrorConstants.REQUEST_BODY_EMPTY_CODE;


	public WordCountResponseDto getWordCount(String inputChar, InputDto iDto) {

		Long count=getWordCount(inputChar, iDto.getInputList()) ;
		WordCountResponseDto respDto = new WordCountResponseDto(inputChar, count);
		return respDto;
	}
	
	public Long getWordCount(String inputChar, List<String> list) {

		System.out.println("Input "+inputChar);
		return list.stream()
				.flatMap( x -> Arrays.stream(x.split("\\s")) )
				.filter(x->x.startsWith(inputChar) || x.startsWith(inputChar.toLowerCase())).count();
		
	}
	
	public ListWordResponseDto getWordsWithMinSize(Integer length, InputDto iDto) {
		
		ListWordResponseDto respDto = new ListWordResponseDto(length, getWordsWithMinSize(length,iDto.getInputList()));
		return respDto;
	}

	
	public List<String> getWordsWithMinSize(Integer length, List<String> list) {

		int len = length.intValue() ; // Integer.parseInt(length);
		return list.stream()
		.flatMap( x -> Arrays.stream(x.split("\\s")) )
		.filter ( x->x.length() >= len)
		.collect( Collectors.toCollection(LinkedList::new) );
		
	}
	
	
	public SummaryResponseDto getSummary(InputDto iDto, String inputchar, Integer length) {
		
		if(iDto==null) {
			throw new InvalidInputException( REQUEST_BODY_EMPTY_CODE , REQUEST_BODY_EMPTY_MSG);
		}
		
		ListWordResponseDto words = getWordsWithMinSize(length, iDto);
		WordCountResponseDto wordCount = getWordCount(inputchar, iDto);

		SummaryResponseDto respDto = new SummaryResponseDto(words, wordCount);
		return respDto;
	}

}
