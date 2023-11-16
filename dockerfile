FROM openjdk:11-jre-slim

WORKDIR /app

# Copy the JAR file from your local filesystem into the container
COPY target/kaddem-0.0.1-SNAPSHOT.jar /app/kaddem.jar

# Expose the port your application listens on (if applicable)
EXPOSE 8089

# Define the command to run your application
CMD ["java", "-jar", "kaddem.jar"]
