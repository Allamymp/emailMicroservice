# First step: Compilation and packaging of the application
FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .
RUN apt-get install maven -y

# Skipping tests during Maven build
RUN mvn clean install -DskipTests

# Second step: Creating the minimal image
FROM openjdk:21-jdk-slim
EXPOSE 8082
COPY --from=build /target/email-0.0.1-SNAPSHOT.jar ms-api-user.jar
CMD ["sh", "-c", "java -jar ms-api-user.jar"]