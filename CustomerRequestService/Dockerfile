FROM openjdk:11
EXPOSE 8082
ADD target/customer-request-microservice.jar customer-request-microservice.jar
ENTRYPOINT ["java","-jar","/customer-request-microservice.jar"]