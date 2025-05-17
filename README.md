# Wordcount Application
### Overview
**Wordcount** is a simple Java-based application that exposes REST endpoints to process a list of input strings and apply basic business rules like filtering and counting of words based on customizable criteria.

---
### Features and Prerequisites

- Exposes REST APIs for word processing ( Port=8080 )
- Built-in Swagger UI for API documentation
- Supports Docker and Maven-based installation
- Java 17 and Maven-based build and testing
- Code coverage and testing reports using JaCoCo

---
### Business Rules

1. **Get words longer than a specified length**  

   *Endpoint:* `POST /wordcount/words`  

   *optional parameters:* `minlen=<Integer>` example `?minlen=3`

   *Description:* 
    - Returns a list of words from the input List of Strings that have length greater than the specified `minlen`. 
    - default minlen=5

                      
<br></br>      
                          
2. **Count words starting with a specific prefix**  

   *Endpoint:* `POST /wordcount/numberofwords`  

   *optional parameters:* `start=<Char or Starting String>` example `?start=A`

   *Description:* 
    - Returns the count of words from the input that start with the given string (case-sensitive).
    - prefix can be a single Char or a string as well. example : 'B' or  "AB"
    - Default start="M" 

-----

### Installation & Setup 
##### Using maven

***Prerequisites:***
- Java 17, Maven, Git 

****Steps:****
1. `git clone https://github.com/carpedium/wordcount`
2. `cd wordcount`
3. `mvn clean package` 
4. `mvn spring-boot:run` 

 
##### Using Docker
  
**Prerequisites:**
- Docker must be installed on your system.

***Using existing Docker Image***
**Steps:**
1. Pull the existing Docker Image from <docker_image_url>
2. Run the container using:`docker run -p <your-port>:8080 <docker_image_name>`

***Generate your own Docker Image from code***
**Steps:**
1. Repeat Step 1,2,3 of build using maven [Link](#Using maven) 
2. Run the container using:`docker run -p <your-port>:8080 <docker_image_name>`
