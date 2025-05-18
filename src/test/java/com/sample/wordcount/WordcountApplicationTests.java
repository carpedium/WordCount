package com.sample.wordcount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = WordcountApplication.class)
@AutoConfigureMockMvc
@Slf4j
class WordcountApplicationTests {

	private static final String TARGET_TESTREPORT_JSON = "target/testreport.json";
	private static final String SUCCESS_STATUS = "SUCCESS";
	private static final String FAIL_STATUS = "FAIL";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private JsonNode loadTestCase(String filePath) throws Exception {
		Path path = new ClassPathResource(filePath).getFile().toPath();
		String json = Files.readString(path);
		return objectMapper.readTree(json);
		 
	}

	@Test
	void testUsingRequestResponseFile() throws Exception {
		JsonNode testCases = loadTestCase("wordCountTestCases.json");

		List<JsonNode> resultSet = new LinkedList<>();
		List<String> failSet = new LinkedList<>();

		for (JsonNode testCase : testCases) {

			ObjectNode resultNode = objectMapper.createObjectNode();
			String testCaseName = testCase.get("name").asText();
			resultNode.put("name", testCaseName);

			try {
				JsonNode request = testCase.get("request");
				String method = request.get("method").asText();
				String url = request.get("url").asText();
				String requestBody = objectMapper.writeValueAsString(request.get("body"));

				MockHttpServletRequestBuilder requestBuilder = getRequestBuilder(method, url);
				MvcResult mvcResult = mockMvc
						.perform(requestBuilder.contentType("application/json").content(requestBody)).andDo(print())
						.andReturn();

				int actualResponseStatus = mvcResult.getResponse().getStatus();
				JsonNode expectedResponse = testCase.get("expectedResponse");

				String body = mvcResult.getResponse().getContentAsString();
				JsonNode actualResponse = objectMapper.readTree(body);
				log.debug("TestCase Name : "+testCaseName);
				log.debug("Actual Status : "+actualResponseStatus+" expectedStatus="+expectedResponse.get("status").asInt());
				log.debug("Actual Response : "+actualResponse+", expectedResponse="+expectedResponse.get("body"));


				assertEquals(actualResponseStatus, expectedResponse.get("status").asInt());
				assertEquals(actualResponse, expectedResponse.get("body"));

				resultNode.put("status", SUCCESS_STATUS);

			} catch (AssertionError | Exception ex) {
				ex.printStackTrace();
				resultNode.put("status", FAIL_STATUS);
				resultNode.put("errorMsg", ex.getMessage());
				failSet.add(testCaseName);
			}

			resultSet.add(resultNode);
		}

		File file = new File(TARGET_TESTREPORT_JSON);
		try (FileWriter writer = new FileWriter(file, false)) {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, resultSet);
		}
		
		if(!failSet.isEmpty()) {
			String msg= failSet.stream().collect(Collectors.joining(", "))
					+ " have failed, please see Test Report at $APP_HOME/TARGET_TESTREPORT_JSON";
			throw new AssertionError(msg);
		}
	}

	public MockHttpServletRequestBuilder getRequestBuilder(String method, String url) {
		MockHttpServletRequestBuilder requestBuilder = null;

		switch (method.toUpperCase()) {
		case "POST":
			requestBuilder = post(url);
			break;

		case "PUT":
			requestBuilder = put(url);
			break;

		case "PATCH":
			requestBuilder = patch(url);
			break;

		case "DELETE":
			requestBuilder = delete(url);
			break;

		case "GET":
			requestBuilder = get(url);
			break;

		default:
			throw new IllegalArgumentException("Unsupported HTTP method: " + method);
		}
	
		return requestBuilder;
	}
}
