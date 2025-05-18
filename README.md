# Wordcount Application
### Overview
**Wordcount** is a simple Java-based application that exposes REST endpoints to process a list of input strings and apply basic business rules like filtering and counting of words based on customizable criteria.

---
## Features and Prerequisites

- Exposes REST APIs for word processing ( Port=8080 )
- Built-in Swagger UI for API documentation
- Supports Docker and Maven-based installation
- Java 17 and Maven-based build and testing
- Code coverage and testing reports using JaCoCo

---
## Business Rules

### 1. Get words longer than a specified length



   **Endpoint:**   `POST /wordcount/words`  
   
   **optional parameters:**   `minlen=<Integer>` example `?minlen=3`
   
   **Description:**
   - Returns a list of words from the input List of Strings that have length greater than the specified `minlen`.
   - default minlen=` 5 `

                          
### 2. Count words starting with a specific prefix**  

   **Endpoint:**   `POST /wordcount/numberofwords`  
   
   **optional parameters:**   `prefix=<Char or Starting String>` example `?prefix=A`
   
   **Description:**
   - Returns the count of words from the input that start with the given string (case-sensitive).
   - prefix can be a single Char or a string as well. example : 'B' or  "AB"
   - Default start=` "M" `

-----

## Installation & Setup 
### Building Application using Maven

***Prerequisites:***
- Java 17, Maven, Git 

***create maven build***
1. `git clone https://github.com/carpedium/wordcount`
2. `cd wordcount`
3. `mvn clean package` 


### Building Docker image
  
**Prerequisites:**
- Java 17, Maven, Git , Docker

***Steps***
1. Repeat Step 1,2,3 of application [build using maven](https://github.com/carpedium/wordcount/edit/main/README.md#building-application-using-maven) to create jar file
2. Create Docker image
    - **Using maven cli**
    
		- `mvn package jib:dockerBuild -Ddocker_tag=<docker_tag>`
		- optional param : `-Ddocker_version`
    
    - **Using docker cli**
    
		- `docker build . -t <docker_tag>/wordcount:<image_version>`
    
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
- navigate to `target/site/jacoco/index.html`

### Check Test Case Report
- `mvn clean test`
- navigate to `target/testreport.json`

### Check API Documentation
- Start the application
- navigate to `http://<server-name>:<port>/swagger-ui/index.html`


