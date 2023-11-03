
# FROM openjdk:8
# EXPOSE 8082
# ADD target/kaddem-0.0.1-SNAPSHOT.jar kaddem-0.0.1.jar
# ENTRYPOINT ["java", "-jar","kaddem-0.0.1.jar"]

FROM maven:3.8.2-jdk-8

WORKDIR /kaddem
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run