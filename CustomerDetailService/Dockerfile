FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer-detail-microservice.jar
ENTRYPOINT ["java","-jar","/customer-detail-microservice.jar"]
EXPOSE 8081


