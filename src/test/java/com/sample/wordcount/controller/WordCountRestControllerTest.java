package com.sample.wordcount.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WordCountRestController.class)
@AutoConfigureMockMvc
public class WordCountRestControllerTest {}
