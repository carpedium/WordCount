package com.sample.wordcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(title = "Count Words Service API Documentation", description = "Application for application/validation of business rules against words", version = "v1", contact = @Contact(name = "Ankit Kumar Singh", email = "ankitkumarsingh.monty@gmail.com")),

		externalDocs = @ExternalDocumentation(description = "Additional Documentation", url = "https://github.com/carpedium/wordcount/blob/main/README.md")

)

public class WordcountApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordcountApplication.class, args);
	}


}
