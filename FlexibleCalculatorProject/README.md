# Flexible Calculator

The Flexible Calculator is a Java Spring Boot application that provides a RESTful API for basic arithmetic operations. It supports chaining multiple operations in a single request. Designed with object-oriented principles, it allows easy extension without modifying existing logic.


## Features

- Basic Operations: Supports addition, subtraction, multiplication, and division.
- Chaining Support: Allows multiple operations to be chained in a single request, starting from an initial value.
- RESTful API: Exposes all calculator functionalities through a clean and easy-to-use REST API.
- Extensibility: New operations can be added without modifying existing logic, adhering to the Open-Closed Principle.
- IoC Compatibility: Built with Inversion of Control (IoC) in mind, making it easy to inject dependencies and write tests.
- Error Handling: Gracefully handles unsupported operations, null inputs, and invalid arithmetic like division by zero.

## Technologies

- Java
- Spring Boot
- Maven
- Postman
- JUnit and Mockito for testing

## Arch of Project
![image](https://github.com/user-attachments/assets/973d7ac9-33c2-413c-ba52-015d9fdba828)


## Finished Results
 1. Calculate by String

![image](https://github.com/user-attachments/assets/edb57c73-4951-49bb-80e2-1d29c0ba3c18)

 2. Calculate by param
 
 ![image](https://github.com/user-attachments/assets/a6721f05-51b5-4cc0-af76-2fe03d34536e)


## Extra Implementation

1. Calculate by String, basically input a string and my programming will scan and anaylsis.

2. Open-Closed Principle
   In this project, once user wants to add new operation, it only need to add in Operation.class and set the priority and character like follows. And then register under the config.class.
   
![image](https://github.com/user-attachments/assets/e104fd73-6c26-4edd-acee-98ac19385a30)
   
![image](https://github.com/user-attachments/assets/e1a95f10-71a4-4bcb-8368-dc39487304b8)

![image](https://github.com/user-attachments/assets/e72f3a35-5264-4c9f-82ca-dd49154f99e9)


## Testing
- controller test

![image](https://github.com/user-attachments/assets/15839e0b-6c92-476e-ae9f-f41e1a9799d6)

![image](https://github.com/user-attachments/assets/60954b89-193b-43bb-92bd-4669506ed856)

- service test

![image](https://github.com/user-attachments/assets/6316408d-2b4f-4754-acb5-c12716e2d29a)

![image](https://github.com/user-attachments/assets/996f22f8-828f-4727-be58-5b61615a5a12)
