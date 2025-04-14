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

## Installation and Setup
**Clone the Repository**

```bash
git clone https://github.com/tssde61/FlexibleCalculatorProject.git

cd FlexibleCalculatorProject
```

**Build the Project**

```bash
mvn clean install
```

**Run the Application**

```bash
mvn spring-boot:run
```

**API Endpoints**
Basic Calculation
http://localhost:8000/api/calculator/calculate 

Chain Operations
http://localhost:8000/api/calculator/chain


## Results
Basic Calculation

![Image](https://github.com/user-attachments/assets/e2baba5e-5736-413a-991d-da2c600dad53)

Chain Operations
 
![Image](https://github.com/user-attachments/assets/adb6c1d3-6926-451d-ba3e-6169bd3e2577)


## Testing
**To Test**

```bash
mvn test
```
![Image](https://github.com/user-attachments/assets/e62fc0a3-174b-4c3d-ae98-e4ddb3cfce2a)

## Other Test Cases and Exception Handling
Subtract
![Image](https://github.com/user-attachments/assets/8791cc42-97d8-416d-a9ee-a56e06aa68e4)

Multiply
![Image](https://github.com/user-attachments/assets/15380499-725e-4efb-b5c2-839610fb520a)

Divide
![Image](https://github.com/user-attachments/assets/39a9b24b-f963-4667-907e-1386bb522f17)

Divide by 0
![Image](https://github.com/user-attachments/assets/c2bef5dc-9e22-4ded-9330-f54e4c6587c3)

Null Operand
![Image](https://github.com/user-attachments/assets/84abbe56-089d-405a-b79a-8b3903c5994c)

Invalid Operation
![Image](https://github.com/user-attachments/assets/5693a617-182c-480b-aafe-5d22267bab2c)

Chain Divide by 0
![Image](https://github.com/user-attachments/assets/0885736c-0c90-488f-b18c-490d3316c8a2)

Chain Null Operand
![Image](https://github.com/user-attachments/assets/cc2f5855-4d66-487e-b370-70d033d3c668)

Chain Invalid Operation
![Image](https://github.com/user-attachments/assets/60e8ea12-ce1e-4277-b86a-64fe8e4a0e99)

Negative NUmber Addition
![Image](https://github.com/user-attachments/assets/72f49d0d-6f2a-4de6-9a4c-da5dd28c64f6)

Floating Number Multiplication
![Image](https://github.com/user-attachments/assets/bd9ae8b9-71e4-40f7-88c5-759680449896)

## Assumptions & Design Decisions
- Numeric Input Only: The calculator accepts only valid numeric input (e.g., integers or floating-point numbers). Non-numeric or malformed values are considered invalid.

- Division by Zero: Division by zero is treated as an invalid operation and results in a custom exception (UnsupportedOperationException).

- Operation Enum: All supported operations (ADD, SUBTRACT, MULTIPLY, DIVIDE) are defined in an enum, promoting type safety and validation.

- Open-Closed Design: Operation logic is implemented using the Strategy pattern, allowing new operations to be added without modifying the core CalculatorService.

- Chained Operations: Chaining assumes sequential execution from an initial value, applying each operation in order. Any invalid step (e.g., null value or unsupported operation) stops processing and raises an exception.

- REST Interface: The application is designed as a RESTful API, assuming it will be used programmatically (e.g., by front-end clients or other services).

- Error Handling: Common errors (e.g., null input, division by zero, invalid JSON) are handled using @ControllerAdvice to ensure consistent and clear API responses.

- Input Validation: Validation is performed at both the controller and service levels to ensure robustness and maintainability.
