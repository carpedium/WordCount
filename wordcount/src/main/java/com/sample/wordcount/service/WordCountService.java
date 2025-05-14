package com.sample.wordcount.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sample.wordcount.dto.InputDto;

@Service
public class WordCountService {

	
	public Long getWordCount(String inputChar, List<String> list) {

		
		System.out.println("Input "+inputChar);
		return list.stream()
				.flatMap( x -> Arrays.stream(x.split("\\s")) )
				.filter(x->x.startsWith(inputChar) || x.startsWith(inputChar.toLowerCase())).count();
		
	}
	
	
	public Long getWordCount(String inputChar, InputDto iDto) {
		return getWordCount(inputChar, iDto.getList());
	}

	
	public List<String> getWordsWithMinSize(String length, InputDto iDto) {
		return getWordsWithMinSize(length,iDto.getList());
	}

	
	public List<String> getWordsWithMinSize(String length, List<String> list) {
		
		int len = Integer.parseInt(length);
		return list.stream()
		.flatMap( x -> Arrays.stream(x.split("\\s")) )
		.filter ( x->x.length() >= len)
		.collect( Collectors.toCollection(LinkedList::new) );
		
	}

}
