package com.sample.wordcount;

import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class WordcountApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    
    @Test
    @DisplayName("getWordsWithMinSize 1 : test with input size 3 ")   
    public void getWordsWithMinSize_1() throws Exception {
        mockMvc.perform(
        			get("/wordcount/words?minSize=3")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
        		
        		)       
                .andDo(print())
                .andExpect(jsonPath("$.stringLength").value("3") )
                .andExpect(jsonPath("$.wordsWithSize", hasSize(3)))
                .andExpect(status().is2xxSuccessful());
    }
    
    @Test
    @DisplayName("getWordsWithMinSize 2 : test with default size 5 ")   
    public void getWordsWithMinSize_2() throws Exception {
        mockMvc.perform(
        			get("/wordcount/words")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
        		
        		)       
                .andDo(print())
                .andExpect(jsonPath("$.stringLength").value("5") )
                .andExpect(jsonPath("$.wordsWithSize", hasSize(1)))
                .andExpect(status().is2xxSuccessful());
    }
    
    
    @Test
    @DisplayName("getWordCountWithChar 1 : test with char A ")   
    public void getWordCountWithChar_1() throws Exception {
        mockMvc.perform(
        			get("/wordcount/numberofwords?inputchar=A")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
        		
        		)       
                .andDo(print())
                .andExpect(jsonPath("$.inputChar").value("A") )
                .andExpect(jsonPath("$.wordCountStartingWithInputChar").value("0") )
                .andExpect(status().is2xxSuccessful());
    }
    
    @Test
    @DisplayName("getWordCountWithChar 2 : test with default char M ")   
    public void getWordCountWithChar_2() throws Exception {
        mockMvc.perform(
        			get("/wordcount/numberofwords")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
        		
        		)       
                .andDo(print())
                .andExpect(jsonPath("$.inputChar").value("M") )
                .andExpect(jsonPath("$.wordCountStartingWithInputChar").value("3") )
                .andExpect(status().is2xxSuccessful());
    }
    
    @Test
    @DisplayName("getSummary 1 : test with default char=M, Len=5")   
    public void getSummary_1() throws Exception {
        mockMvc.perform(
        			get("/wordcount/summary")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content("{ \"list\" : [ \"mama momo\", \"m@123\" ] }")
        		
        		)       
                .andDo(print())
                .andExpect(jsonPath("$.inputChar").value("M") )
                .andExpect(jsonPath("$.wordCountStartingWithInputChar").value("3") )
                .andExpect(jsonPath("$.stringLength").value("5") )
                .andExpect(jsonPath("$.wordsWithSize", hasSize(1)) )
                .andExpect(status().is2xxSuccessful());
    }
    
    @Test
    @DisplayName("getSummary 2 : test with char=X, Len=2")   
    public void getSummary_2() throws Exception {
        mockMvc.perform(
        			get("/wordcount/summary?inputchar=X&length=2")
        			.contentType(MediaType.APPLICATION_JSON)
        			.content("{ \"list\" : [ \"mama momo\", \"m@123\", \"Xyz\" ] }")
        		
        		)       
                .andDo(print())
                .andExpect(jsonPath("$.inputChar").value("X") )
                .andExpect(jsonPath("$.wordCountStartingWithInputChar").value("1") )
                .andExpect(jsonPath("$.stringLength").value("2") )
                .andExpect(jsonPath("$.wordsWithSize", hasSize(4)) )
                .andExpect(status().is2xxSuccessful());
    }
    
    

}
