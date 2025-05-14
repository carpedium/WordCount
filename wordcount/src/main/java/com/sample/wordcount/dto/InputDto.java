package com.sample.wordcount.dto;

import java.util.List;

public class InputDto {

	List<String> list;

	public InputDto() {
		super();
	}

	public InputDto(List<String> list) {
		super();
		this.list = list;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	

}
