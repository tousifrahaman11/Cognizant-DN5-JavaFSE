# Week 3: Spring Core and Maven — Library Management System

## Scenario (Cognizant DN5.0 Handbook)
Developing a web application backend for managing a library using
the Spring Framework.

## Mandatory Exercises Completed
- [x] Exercise 1: Configuring a Basic Spring Application
      (ApplicationContext + beans in XML)
- [x] Exercise 2: Implementing Dependency Injection
      (setter injection of BookRepository into BookService)
- [x] Exercise 4: Creating and Configuring a Maven Project
      (Spring Context, AOP, WebMVC dependencies + Compiler Plugin)

## How to Run
```cmd
cd Week3/LibraryManagement
mvn clean compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
```

## Key Concepts Demonstrated
- Spring IoC Container (ApplicationContext)
- XML-based bean configuration (applicationContext.xml)
- Setter Dependency Injection
- Maven project setup with Spring dependencies