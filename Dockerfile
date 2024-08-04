# Use a specific version of OpenJDK
FROM openjdk:17-jdk AS build

# Set the working directory
WORKDIR /home/app

# Copy the project files
COPY src /home/app/src
COPY pom.xml /home/app

COPY target/hackathon-0.0.1-SNAPSHOT.jar /home/app/target/hackathon-0.0.1-SNAPSHOT.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/home/app/target/hackathon-0.0.1-SNAPSHOT.jar"]
