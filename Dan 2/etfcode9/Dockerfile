# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot application JAR file to the container
COPY ./target/etfcode9-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080
EXPOSE 3306

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
