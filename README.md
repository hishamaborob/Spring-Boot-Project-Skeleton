[![Build Status](https://travis-ci.org/hishamaborob/Spring-Boot-Project-Skeleton.svg?branch=master)](https://travis-ci.org/hishamaborob/Spring-Boot-Project-Skeleton)

# Spring Boot Project Skeleton

Microservice skeleton based on Spring Boot and Java 8. It is ready to start skeleton project that can be packaged as JAR with embedded Tomcat server and uses HTTP as a protocol for REST.

It also provides Swagger configuration and interface that documents an example Restful controller and enables easy manual testing of endpoints.

You can find some API controller, service, and repository examples, along with configured embedded database on test and run time using H2 and some sample SQL schema and data. Also some basic Integration test code for testing API endpoints and data.

It includes also a JDBC and EntityManager templates, general exception and error handling that catches most common errors and translate it to the proper restful representation using the proper response code.

### Summary

- Spring Boot, Java 8, Tomcat, HTTP.
- Embedded database H2 and sample schema and data loading.
- JDBC and EntityManager Templates.
- Service, Repository, and Entity examples.
- Restful API controller example.
- General Exception and Errors handling.
- Basic Integration Test.
- Swagger configuration and interface.

### Usage

Testing and Packaging:

```
mvn clean instal
```

Run the Application:

```
java -jar target/service-skeleton-0.1.0.jar
```

Swagger interface:

```
http://localhost:8088/swagger-ui.html
```
