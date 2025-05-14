package com.sample.wordcount.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@Data @AllArgsConstructor
@JsonInclude(Include.NON_NULL)
	
public class ResponseDto {

	String inputChar;
	Long wordCountStartingWithInputChar;
	
	String stringLength;
	List<String> wordsWithSize;
	
	public ResponseDto() {
		super();		
	}
	
	
	public ResponseDto(String inputChar, Long wordCountStartingWithInputChar, String stringLength,
			List<String> wordsWithSize) {
		super();
		this.inputChar = inputChar;
		this.wordCountStartingWithInputChar = wordCountStartingWithInputChar;
		this.stringLength = stringLength;
		this.wordsWithSize = wordsWithSize;
	}


	public String getInputChar() {
		return inputChar;
	}


	public void setInputChar(String inputChar) {
		this.inputChar = inputChar;
	}


	public Long getWordCountStartingWithInputChar() {
		return wordCountStartingWithInputChar;
	}


	public void setWordCountStartingWithInputChar(Long wordCountStartingWithInputChar) {
		this.wordCountStartingWithInputChar = wordCountStartingWithInputChar;
	}


	public String getStringLength() {
		return stringLength;
	}


	public void setStringLength(String stringLength) {
		this.stringLength = stringLength;
	}


	public List<String> getWordsWithSize() {
		return wordsWithSize;
	}


	public void setWordsWithSize(List<String> wordsWithSize) {
		this.wordsWithSize = wordsWithSize;
	}
	
	
	
}
