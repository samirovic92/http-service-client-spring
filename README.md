# Spring Boot 4 HTTP Interfaces Demo

A demonstration project showcasing the new HTTP Service Client features in Spring Framework 7 and Spring Boot 4. 
This project uses declarative HTTP interfaces to consume the [JSONPlaceholder API](https://jsonplaceholder.typicode.com/).

## What are HTTP Interfaces?

HTTP Interfaces allow you to define an HTTP service as a Java interface with annotated methods for HTTP exchanges. 
Spring Framework creates a proxy that implements the interface and performs the HTTP requests. This provides a type-safe, 
declarative approach to building HTTP clients.

```java

@HttpExchange("/posts")
public interface PostService {

    @GetExchange
    List<Post> findAll();

    @GetExchange("/{id}")
    Post findById(@PathVariable Integer id);

    @PostExchange
    Post create(@RequestBody Post todo);
}
```

## Features

- **Declarative HTTP Clients** - Define HTTP services using Java interfaces
- **Type-Safe** - Full compile-time type checking for requests and responses
- **Annotation-Based** - Use `@HttpExchange`, `@GetExchange`, `@PostExchange`, `@PutExchange`, `@DeleteExchange`
- **RestClient Integration** - Built on Spring's modern RestClient
- **Spring Boot Auto-Configuration** - Minimal configuration required

## Prerequisites

- **Java 21**
- **Spring Boot 4.0.0+**
- **Spring Framework 7.0**
- **Maven 3.9+**

## Project Structure

Typical layout for this repository (Maven + Spring Boot):

```
http-service-client-spring/
├─ pom.xml                        # Maven project descriptor
├─ README.md                       # This file
└─ src/
   ├─ main/
   │  ├─ java/
   │  │  └─ com/sei/serviceclient/
   │  │     ├─ Application.java        # Spring Boot main class
   │  │     ├─ controller/
   │  │     │  └─ PostController.java  # MVC controllers / web endpoints
   │  │     ├─ service/
   │  │     │  └─ PostService.java     # Declarative HTTP interface (HTTP client)
   │  │     ├─ model/
   │  │     │  └─ Post.java            # DTOs / domain models
   │  │     └─ config/
   │  │        └─ HttpConfig.java      # HTTP client / RestClient configuration
   │  └─ resources/
   │     ├─ application.properties     # application configuration
   │     ├─ static/                    # static web assets
   │     └─ templates/                 # server-side templates (Thymeleaf, etc.)
   └─ test/
      └─ java/
         └─ com/sei/serviceclient/
            └─ ApplicationTests.java  # unit/integration tests

target/                             # build output (ignored in VCS)
```

Short descriptions
- `Application.java` — Spring Boot entrypoint that boots the application.
- `controller/` — web controllers that expose endpoints used by the demo UI.
- `service/` — contains the declarative HTTP client (`PostService`) used to call the JSONPlaceholder API.
- `model/` — data transfer objects that map JSON responses (e.g., `Post`).
- `config/` — optional configuration for HTTP clients or message converters.

This structure follows a conventional Maven + Spring Boot layout so it's easy to navigate and extend.

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd sb4-http-interfaces
```

### 2. Build the Project

```bash
./mvnw clean install
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.
