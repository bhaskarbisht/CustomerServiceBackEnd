
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-request-microservice.jar
ENTRYPOINT ["java","-jar","/customer-request-microservice.jar"]
EXPOSE 8082


