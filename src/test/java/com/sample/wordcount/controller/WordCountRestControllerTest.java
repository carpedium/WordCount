package com.sample.wordcount.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.sample.wordcount.exception.ErrorConstants;
import com.sample.wordcount.service.WordCountService;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
public class WordCountRestControllerTest {
	/*
	 * 
	 * @Autowired private MockMvc mockMvc;
	 * 
	 * @Mock WordCountService wService;
	 * 
	 * @InjectMocks WordCountRestController wController;
	 * 
	 * @Test
	 * 
	 * @DisplayName("getWordsWithMinSize 1 : test with default size 5 ") public void
	 * getWordsWithMinSize_1() throws Exception {
	 * mockMvc.perform(get("/wordcount/words").contentType(MediaType.
	 * APPLICATION_JSON) .content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
	 * 
	 * ) // .andDo(print())
	 * .andExpect(jsonPath("$.minLength").value("5")).andExpect(jsonPath(
	 * "$.wordsWithSize", hasSize(1))) .andExpect(status().is2xxSuccessful()); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("getWordsWithMinSize 2 : test with input size 3 ") public void
	 * getWordsWithMinSize_2() throws Exception {
	 * mockMvc.perform(get("/wordcount/words?minlen=3").contentType(MediaType.
	 * APPLICATION_JSON) .content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
	 * 
	 * ).andDo(print()).andExpect(jsonPath("$.minLength").value("3"))
	 * .andExpect(jsonPath("$.wordsWithSize",
	 * hasSize(3))).andExpect(status().is2xxSuccessful()); }
	 * 
	 * 
	 * 
	 * @Test
	 * 
	 * @DisplayName("getWordCountWithChar 1 : test with char A ") public void
	 * getWordCountWithChar_1() throws Exception {
	 * mockMvc.perform(get("/wordcount/numberofwords?startingchar=A").contentType(
	 * MediaType.APPLICATION_JSON)
	 * .content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
	 * 
	 * ) // .andDo(print()) .andExpect(jsonPath("$.startingChar").value("A"))
	 * .andExpect(jsonPath("$.wordCountStartingWithInputChar").value("0"))
	 * .andExpect(status().is2xxSuccessful()); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("getWordCountWithChar 2 : test with default char M ") public
	 * void getWordCountWithChar_2() throws Exception {
	 * mockMvc.perform(get("/wordcount/numberofwords").contentType(MediaType.
	 * APPLICATION_JSON) .content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
	 * 
	 * ) // .andDo(print()) .andExpect(jsonPath("$.startingChar").value("M"))
	 * .andExpect(jsonPath("$.wordCountStartingWithInputChar").value("3"))
	 * .andExpect(status().is2xxSuccessful()); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("getSummary 1 : test with default char=M, Len=5") public void
	 * getSummary_1() throws Exception {
	 * mockMvc.perform(get("/wordcount/summary").contentType(MediaType.
	 * APPLICATION_JSON) .content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
	 * 
	 * ) // .andDo(print()) .andExpect(jsonPath("$.startingChar").value("M"))
	 * .andExpect(jsonPath("$.wordCountStartingWithInputChar").value("3"))
	 * .andExpect(jsonPath("$.minLength").value("5")).andExpect(jsonPath(
	 * "$.wordsWithSize", hasSize(1))) .andExpect(status().is2xxSuccessful()); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("getSummary 2 : test with char=X, Len=2") public void
	 * getSummary_2() throws Exception {
	 * mockMvc.perform(get("/wordcount/summary?startingchar=X&minlen=2").contentType
	 * (MediaType.APPLICATION_JSON)
	 * .content("{ \"list\" : [ \"mama momo\", \"m@123\", \"Xyz\" ] }")
	 * 
	 * ) // .andDo(print()) .andExpect(jsonPath("$.startingChar").value("X"))
	 * .andExpect(jsonPath("$.wordCountStartingWithInputChar").value("1"))
	 * .andExpect(jsonPath("$.minLength").value("2")).andExpect(jsonPath(
	 * "$.wordsWithSize", hasSize(4))) .andExpect(status().is2xxSuccessful()); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("getSummary 3 : test with empty input list") public void
	 * getSummary_3() throws Exception {
	 * mockMvc.perform(get("/wordcount/summary?startingchar=X&minlen=2").contentType
	 * (MediaType.APPLICATION_JSON) .content("{ \"list\" : [ ] }")
	 * 
	 * ).andDo(print()).andExpect(jsonPath("$.list").value(ErrorConstants.
	 * INPUT_LIST_EMPTY_MSG)) .andExpect(status().is4xxClientError()); }
	 * 
	 */}
