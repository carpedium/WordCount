FROM openjdk:17-jdk-slim

MAINTAINER ankitkumarsingh

COPY target/wordcount-0.0.1-SNAPSHOT.jar wordcount-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "wordcount-0.0.1-SNAPSHOT.jar"]