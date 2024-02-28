# Start with a base image containing Java runtime and Maven
FROM maven:3.9.6-eclipse-temurin-11-alpine

# Make source folder
RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

# Unset MAVEN_CONFIG
ENV MAVEN_CONFIG=""

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the POM
COPY pom.xml .

# Fetch all dependencies
RUN ./mvnw dependency:go-offline -B

# Copy other source files
COPY src src

# Build application
RUN ./mvnw package

# Specifies port to expose
EXPOSE 8080

# Add the application's .jar to the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the .jar file 
ENTRYPOINT ["java","-jar","/app.jar"]
