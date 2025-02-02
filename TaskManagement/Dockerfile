# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose port 8081
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]