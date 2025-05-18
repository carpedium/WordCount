package com.sample.wordcount.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sample.wordcount.dto.InputDto;
import com.sample.wordcount.dto.ListWordResponseDto;
import com.sample.wordcount.dto.SummaryResponseDto;
import com.sample.wordcount.dto.WordCountResponseDto;
import com.sample.wordcount.exception.ErrorConstants;
import com.sample.wordcount.exception.types.InvalidInputException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WordCountService {

	private static final String REQUEST_BODY_EMPTY_MSG = ErrorConstants.REQUEST_BODY_EMPTY_MSG;
	private static final String REQUEST_BODY_EMPTY_CODE = ErrorConstants.REQUEST_BODY_EMPTY_CODE;

	public WordCountResponseDto getWordCount(String inputChar, InputDto iDto) {

		Long count = getWordCount(inputChar, iDto.getInputList());
		return new WordCountResponseDto(inputChar, count);		 
	}

	public Long getWordCount(String inputChar, List<String> list) {

		
		log.info("Input inputChar  : " + inputChar);
		
		Long output = list.stream().flatMap(x -> Arrays.stream(x.split("\\s")))
				.filter(x -> x.startsWith(inputChar) || x.startsWith(inputChar.toLowerCase())).count();
		
		log.info("Output wordcount : " + output);
		
		return output;
	}

	public ListWordResponseDto getWordsWithMinSize(Integer length, InputDto iDto) {
		
		return new ListWordResponseDto(length, getWordsWithMinSize(length, iDto.getInputList()));
		
	}

	public List<String> getWordsWithMinSize(Integer length, List<String> list) {

		log.info ("Input length : " + length);
		log.debug("Input list   : " + list);

		int len = length.intValue(); 
		LinkedList<String> outputList = list.stream().flatMap(x -> Arrays.stream(x.split("\\s"))).filter(x -> x.length() > len)
				.collect(Collectors.toCollection(LinkedList::new));
		
		log.debug("Output outputList : " + outputList);

		return outputList;

	}

	public SummaryResponseDto getSummary(InputDto iDto, String inputchar, Integer length) {

		if (iDto == null) {
			throw new InvalidInputException(REQUEST_BODY_EMPTY_CODE, REQUEST_BODY_EMPTY_MSG);
		}

		ListWordResponseDto words = getWordsWithMinSize(length, iDto);
		WordCountResponseDto wordCount = getWordCount(inputchar, iDto);

		return new SummaryResponseDto(words, wordCount);
	}

}
