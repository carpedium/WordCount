package com.sample.wordcount;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sample.wordcount.service.WordCountService;

@SpringBootApplication
public class WordcountApplication implements CommandLineRunner{

	@Autowired
	WordCountService wService;
	
	public static void main(String[] args) {
		SpringApplication.run(WordcountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<String> input=Arrays.asList(new String []{ "m@123", "mama moon" });
		
		System.out.println(">>>  "+wService.getWordCount("M", input));
	}

}
