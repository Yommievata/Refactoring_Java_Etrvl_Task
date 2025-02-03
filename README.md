# Movie Rental Refactor

A modern, well-structured Java application for managing movie rentals. This project demonstrates clean architecture principles, SOLID design patterns, and best practices in Java development.

## Project Overview

The Movie Rental System is a refactored solution that transforms a basic movie rental slip generator into a robust, maintainable, and extensible application. The system handles movie rentals, customer management, pricing calculations, and statement generation.

### Key Features

- Clean architecture with clear separation of concerns
- Type-safe implementations with proper error handling
- Comprehensive test coverage
- Flexible pricing strategies
- In-memory repository implementations

## Prerequisites

- Java JDK 17 or higher
- Maven 3.6 or higher

## Setup and Installation

1. Clone the repository:
```bash
git clone https://github.com/Yommievata/Refactoring_Java_Etrvl_Task
cd Refactoring_Java_Etrvl_Task
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn exec:java -Dexec.mainClass=com.rental.Main -X
```

## Design Decisions and Improvements

### 1. Architecture
- Implemented a layered architecture (Model, Repository, Service)
- Clear separation of concerns for better maintainability
- Interface-based design for flexibility and testability

### 2. Domain Model
- Created proper domain entities (Movie, Customer, Rental)
- Used enums for type-safe categorization (MovieCategory)
- Implemented immutable objects where appropriate

### 3. Repository Layer
- Generic repository interfaces for data access
- In-memory implementations for simplicity
- Easy to extend with database implementations

### 4. Service Layer
- Separated pricing logic from statement generation
- Clean, single-responsibility services
- Easy to modify or extend pricing rules

### 5. Testing
- Comprehensive unit tests for core business logic
- Clear test naming and organization
- Good test coverage for pricing calculations

### 6. Code Quality
- Consistent naming conventions
- Comprehensive JavaDoc documentation
- Clean code principles applied throughout
- Type safety and proper error handling

## Running Tests

Execute the test suite using Maven:
```bash
mvn test
```

## Future Improvements

1. **Database Integration**
    - Implement JPA/Hibernate repositories
    - Add transaction management
    - Implement data persistence

2. **API Layer**
    - Add REST controllers
    - Implement API documentation with Swagger
    - Add input validation

3. **Additional Features**
    - User authentication and authorization
    - Rental history tracking
    - Advanced pricing rules
    - Customer loyalty program
    - Email notifications

4. **Infrastructure**
    - Add logging framework
    - Implement monitoring
    - Add containerization
    - CI/CD pipeline setup

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## Author

Michael A. Olusanya

---

## Original Requirements and Response

### Assignment Overview
The original assignment required refactoring a movie rental system that generates rental slips. The main goals were to:
- Improve code structure and organization
- Apply best practices and design patterns
- Maintain existing functionality while improving maintainability
- Create a solution that demonstrates professional software development standards

### Implementation Response
The solution addresses these requirements by:
- Implementing a clean, layered architecture
- Following SOLID principles and design patterns
- Adding comprehensive testing
- Providing clear documentation
- Creating an extensible foundation for future improvements

The code is now more maintainable, testable, and ready for future enhancements while maintaining the original functionality.
