# Wordcount Application
### Overview
**Wordcount** is a simple Java-based application that exposes REST endpoints to process a list of input strings and apply basic business rules like filtering and counting of words based on customizable criteria.

---
## Features

- Exposes REST APIs for word processing ( default Port=8080 )
- Built-in Swagger UI for API documentation
- Java 17 and Maven-based build and testing
- Supports Dockerization
- Code coverage and testing reports using JaCoCo

---

## Input Rules

   **Valid input:**
   - Input contains a list of words
   - group of words like "word1 word2" is also a valid member of input list
   - you can use both alphanumeric and non-alphanumeric characters in the input.

   ***Sample Input***
     `{ "inputList": [  "mama", "momo", "maka macha" ] }`

 **Invalid input:**
   - Nested Lists are not considered a valid input
   - only word and NOT list of word(s) 

   ***Sample Invalid Input***
    - `{ "inputList": [  "mama", "momo", ["maka macha"] ] }`
    - `{ "inputList":  "mama" }`

---
      
## Available APIs

### 1. Get words longer than a specified length

   **Endpoint:**   `POST /wordcount/words`  
   
   **optional parameters:**   `minlen=<Integer>` example `/wordcount/words?minlen=3`
   
   **Description:**
   - Returns a list of words from the input List of Strings that have length greater than the specified `minlen`.
   - default minlen=` 5 `

   ***CLI Sample 1:***       
	
	curl -X 'POST' 'http://localhost:8080/wordcount/words' \
 	-H 'accept: application/json' -H 'Content-Type: application/json' \
	-d '{ "inputList": [ "mama", "momo", "maka m@123" ] }'
	 
 ***Output***  
  
	{
	"minlen": 5,
	"wordsWithSize": []
	}

   ***CLI Sample 2:***       
	
	curl -X 'POST' 'http://localhost:8080/wordcount/words?minlen=4' \
 	-H 'accept: application/json' -H 'Content-Type: application/json' \
	-d '{ "inputList": [ "mama", "momo", "maka m@123" ] }'
	 
 ***Output***  

 	{
	"minlen": 4,
	"wordsWithSize": ["m@123"]
	}
 

 
                          
### 2. Count words starting with a specific prefix  

   **Endpoint:**   `POST /wordcount/numberofwords`  
   
   **optional parameters:**   `prefix=<Char or Starting String>` example `/wordcount/numberofwords?prefix=A`
   
   **Description:**
   - Returns the count of words from the input that start with the given string (case-sensitive).
   - prefix can be a single Char or a string as well. example : 'B' or  "AB"
   - Default start=` "M" `

 ***CLI Sample 1:***     
	
	curl -X 'POST' 'http://localhost:8080/wordcount/numberofwords' \
 	-H 'accept: application/json' -H 'Content-Type: application/json' \
	-d '{ "inputList": [ "mama", "momo", "maka m@123" ] }'
	 
 ***Output***   
  
	{
	"prefix": "M",
	"wordCountStartingWithInputChar": 4
	}

   ***CLI Sample 2:***       
	
	curl -X 'POST' 'http://localhost:8080/wordcount/numberofwords?prefix=MA' \
 	-H 'accept: application/json' -H 'Content-Type: application/json' \
	-d '{ "inputList": [ "mama", "momo", "maka m@123" ] }'
	 
 ***Output***   
  
	{
	"prefix": "MA",
	"wordCountStartingWithInputChar": 2
	}

### 3. perform operation 1( get words of min length) and operation 2 (get words of input prefix) together

   **Endpoint:**   `POST /wordcount/summary`  
   
   **optional parameters:**
   -	`prefix=<Char or Starting String>` example `/wordcount/summary?prefix=MA`
   -	`minlen=<Integer>` example `/wordcount/summary?minlen=3`
   
   **Description:**
   - performs operation of both `/wordcount/words ` and `/wordcount/numberofwords ` and sends consolidated response.
   - all rules of the respective APIs are inherited. Example : default `minlen=5` and `prefix=M`
   - optional parameters of the respective apis can be used together as well as respectively.

 ***CLI Sample 1:***     
	
	curl -X 'POST' 'http://localhost:8080/wordcount/summary' \
 	-H 'accept: application/json' -H 'Content-Type: application/json' \
	-d '{ "inputList": [ "mama", "momo", "maka m@123" ] }'
	 
 ***Output***   
  
	{
	"prefix": "M",
	"wordCountStartingWithInputChar": 4,
	"minlen": 5,
	"wordsWithSize": []
	}

   ***CLI Sample 2:***       
	
	curl -X 'POST' 'http://localhost:8080/wordcount/summary?prefix=Ma' \
 	-H 'accept: application/json' -H 'Content-Type: application/json' \
	-d '{ "inputList": [ "mama", "momo", "maka m@123" ] }'
	 
 ***Output***   
  
	{
	"prefix": "Ma",
	"wordCountStartingWithInputChar": 2,
	"minlen": 5,
	"wordsWithSize": []
	}

   ***CLI Sample 3:***       
	
	curl -X 'POST' 'http://localhost:8080/wordcount/summary?prefix=Ma&minlen=4' \
 	-H 'accept: application/json' -H 'Content-Type: application/json' \
	-d '{ "inputList": [ "mama", "momo", "maka m@123" ] }'
	 
 ***Output***   
  
	{
	"prefix": "Ma",
	"wordCountStartingWithInputChar": 2,
	"minlen": 4,
	"wordsWithSize": [
        	"m@123"
    	]
	}
   

     
-----

## Installation & Setup 
### Building Application using Maven

***Prerequisites:***
- Java 17, Maven, Git 

***create maven build***
1. `git clone https://github.com/carpedium/wordcount.git`
2. `cd wordcount`
3. `mvn clean package` 


### Building Docker image
  
**Prerequisites:**
- Java 17, Maven, Git , Docker

***Steps***
1. Repeat Step 1,2,3 of application [build using maven](https://github.com/carpedium/wordcount/edit/main/README.md#building-application-using-maven) to create jar file
2. Create Docker image
    - **Using maven cli**
    
		- `mvn package jib:dockerBuild -Ddocker_tag=<dockerrepo_tag>`
		- optional param : `-Ddocker_version`
    
    - **Using docker cli**
    
		- `docker build . -t <dockerrepo_tag>/wordcount:<image_version>`
    
### Execute application using maven
- Build application using maven steps as defined
`mvn spring-boot:run` 
- optional param to override the application port :
    `-Dspring-boot.run.arguments="--server.port=9090"`
     
       
### Execute application using existing Docker Image
- Pull the existing Docker Image `docker pull ankitkumarsingh0000/wordcount:release`
- Run the container using:  `docker run -d -p <user-port>:8080 ankitkumarsingh0000/wordcount:release`

### Execute application using Self-built docker image
- create Docker Image using [steps](https://github.com/carpedium/wordcount/edit/main/README.md#building-docker-image) defined above
- Run the container using:  `docker run -p <your-port>:<app-port> <docker_image_name>`

### Verify Test Coverage 

- `mvn clean verify -Dcoverage_ratio=<value from 0.00 to 1.00>`
- default value=`.6`

### Check Test Coverage Report
- `mvn clean test`
- navigate to `$APP_HOME/target/site/jacoco/index.html`

### Review Test Cases 
- check `$APP_HOME/src/test/resources/wordCountTestCases.json`

### Check Test Case Report
- `mvn clean test`
- navigate to `$APP_HOME/target/testreport.json`

### Check API Documentation
- Start the application
- navigate to `http://<server-name>:<port>/swagger-ui/index.html`


