# Use the Eclipse Temurin base image with JRE 17
FROM eclipse-temurin:17.0.11_9-jre-focal

# Add the JAR file from the target directory to the container
ADD target/*.jar app.jar

# Ensure the JAR file is recognized by the container's filesystem
RUN sh -c 'touch /app.jar'

# Expose port 8080 to allow external access to the application
EXPOSE 8080

# Set the entry point to run the JAR file
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]