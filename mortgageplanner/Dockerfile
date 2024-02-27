# Use a base image with Maven and a JDK installed
FROM maven:3.8.4-openjdk-21-slim AS build

# Set the working directory in the Docker image
WORKDIR /app

# Copy the pom.xml file into the Docker image
COPY pom.xml .

# Download dependencies as specified in pom.xml
RUN mvn dependency:go-offline

# Copy the rest of the application source code
COPY src /app/src

# Build the application
RUN mvn package

# Use a base image with a JRE installed for running the application
FROM openjdk:17-jre-slim

# Copy the built application from the build stage
COPY --from=build /app/target/*.jar /app.jar

# Run the application
CMD ["java", "-jar", "/app.jar"]