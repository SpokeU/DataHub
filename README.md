# DataHub

## Overview

### Problem statement

Developers often need to execute queries on various databases, share these queries with team members, and ensure
efficient collaboration on database-related tasks. Traditional methods of sharing queries (via messaging platforms,
documentations, or verbally) are inefficient and prone to errors

Another use case is that product owners and business persons are often need to view specific data as well.
For example: A number of orders for previous month, a number of users that logged in at least once in last month etc.
This results in another query that developer creates, saves it somewhere and runs against DB to provide business with
results.

### Solution

**DataHub** aims to solve these problems by providing a centralized web platform for managing database connections,
sharing queries, executing them, and presenting results in a user-friendly manner.

## Key features

### [**Connection Management**](#connection-management)

- Create, update, delete, and list database connections.
- Support for multiple database types, starting with popular relational databases (e.g., PostgreSQL, MySQL).
- Secure storage of database credentials and connection details.

### [**Query Management**](#query-management)

- Query editor for writing, saving, editing, deleting, list queries
- Query parametrization
- Different query languages based on the database type
- Share queries with other users or groups.

### [**Query Execution**](#query-execution)

## Connection Management

In order to execute any queries against any datasource we need to be able to connect to it whether its Postgres DB
connection or even a file.
This part of DataHub describes managing connection and connecting to datasource itself.

TODO DataModel link (OpenApi)
TODO Use Cases
_Feature це дизайн + UseCases. Тобто це міні система - часто інтегрована в середину існуючої хоча і не обовязково._

### Overview

_Intention and why. What problem does it solves in scope of a project. Describe how overall feature intention_

### Solution Overview

How each requirement will be implemented
Diagram  
**Layers**  
UI  
API  
DB

## Query management

TODO

## Query execution

TODO

# General

## Approaches

**API First**  
The project is using API First method. This is related to every aspect of application API, DB, etc.

**OpenAPI** -> generation -> Api Code  
**Business Logic**  
**DB Schema** -> generation -> JPA Code

### API

Below is the approaches and techniques for each API type

- REST API  
  **OpenAPI** spec is used with `org.openapitools.openapi-generator-maven-plugin`. Configuration should
  use `<delegatePattern>true</delegatePattern>`. Todo reasoning
- DB Schema

### Database

_Currently deciding how to have same approach as with OpenAPI when we have to define a DB in single place and JPA etc in
generated_

_The idea is to generate schema changes using Flyway or Liqbase and let ChatGPT to generate entities. This might be
separate Gpt with its configuration to properly do its job (Tool like Gpt)_

**Liquibase vs Flyway**

#### Liqbase

- New technology which is interested to use
- CustomChange - Java is custom migration. Very useful Supported by both
- Selective Deployment of a Change
- Conditional Deployment - Preconditions allow users to apply changes based on the current state of the
  database https://www.liquibase.com/blog/contexts-vs-labels
- Snapshots & Comparing Databases
    - Liquibase allows users to take a snapshot of the current state

#### Flyway

- Seems more straightforward while liqbase has more features l

-------------------------------

# Conventions

In order to maintain a consistent and understandable codebase, project follows certain conventions.
Proper naming ensures that our code is readable and understandable by anyone who might read it, now or in the future.
Here are the specific naming conventions we follow:

### Database table

### Entity

### Open API

- **Endpoints**: These are named using **plural nouns** to indicate that they handle collections of resources.\
  Example:
  ```
  Endpoint: `/users` (not `/user`)
  ```
- Consider using different models for Request and Response (or any other scenarios where models feels similar but
  actually differs. Usually its Input data VS model data which is more rich as contains calculated fields)  
  Example:  
  Connection request - note missing ID as for create we do not pass the id and for update we have it in
  URL `PUT /connections/{id}`
  ```
  {
  "name": "string",
  "type": "POSTGRES",
  "details": {
    "host": "localhost",
    "port": 15432,
    "database": "users_db",
    "username": "my_user",
    "password": "my_password"
  }
  }
  ```

  Connection response - note the id is present (it might be other calculated fields)
  ```
  {
  "id": 0,
  "name": "string",
  "type": "POSTGRES",
  "details": {
    "host": "localhost",
    "port": 15432,
    "database": "users_db",
    "username": "my_user",
    "password": "my_password"
  }
  }
  ```

### Project folder structure

#### Sources `scr/main/java`

- `api/`:
    - `endpoint/`: Contains classes that handle HTTP requests. Controllers map requests to handler functions and are
      responsible for responding to client requests. - `endpoint/`: Contains classes that handle HTTP requests.
      Controllers map requests to handler functions and are responsible for responding to client requests. Or delegate
      in case of OpenApi code generation
    - `model/`: Defines Data Transfer Objects (DTOs) that are used to structure the data sent to or received from the
      API endpoints. These models are tailored for external communication.
    - `mapper/`: Includes interfaces and classes that map or transform data between different layers, such as from
      entities to API models (DTOs) and vice versa, often utilizing mapping frameworks like MapStruct.
    - `validation/`: Holds custom validation logic, annotations, or classes used for validating API inputs, ensuring
      that data received from clients meets specific constraints before processing.
    - `exception_handling/`: Provides centralized exception handling for the API layer, using `@ControllerAdvice`
      and `@ExceptionHandler` annotations to manage exceptions and customize error responses.
- `service/`: The service layer contains business logic and service classes. This layer processes data, applies business
  rules, and handles transactions. It acts as a bridge between the API and data layers. It sould be organized as
  Domain-based Subpackaging. Split your services into subpackages based on domain or business functionality. This aligns
  with Domain-Driven Design (DDD) principles, making it easier to navigate and understand the business capabilities of
  your application.
    - Example subpackages:
        - `user/`: Contains services related to user management, authentication, and authorization.
        - `order/`: Services for order processing, tracking, and management.
        - `product/`: Product catalog management, product search, and inventory management services.
        - `payment/`: Payment processing, payment method management, and transaction history services.
- `data/`:
    - `entity/`: Represents the domain model of the application, closely aligned with the database structure. These are
      annotated JPA entities that define the schema of the database.
    - `repository/`: Data access layer consisting of interfaces that extend Spring Data JPA repositories or custom
      repository classes for accessing the database. This layer abstracts the logic of data persistence and retrieval.
- `integration/`:
    - `client/`: Contains classes that facilitate communication with third-party services, APIs, or systems,
      encapsulating the logic for external API calls.
    - `model/`: Defines models (DTOs) that are specifically used for integrating with third-party APIs, structuring the
      data exchanged in these interactions.
    - `exception/`: Custom exceptions related to third-party integration, handling errors that occur during external API
      communications.
- `messaging/`: Handles configuration and service classes for asynchronous messaging and event-driven communication,
  including integration with message brokers (like RabbitMQ, Kafka), event publishers, and listeners.
- `config/`: Configuration classes that define beans, application settings, and configurations. This could include
  database configurations, security settings, and any other Spring configurations necessary for the application.
- `util/`: Utility classes that provide common, reusable logic across the application. These might include helper
  functions, constants, and any other utilities that don't fit into the specific categories above.

#### Resources `scr/main/resources`

- `api`: Everything related to API definition (mostly api spec)
    - `open_api_spec.yaml` - Open api spec for current service

## Workflows

### Adding new endpoint

1. Modify Open API spec _//TODO define location_
2. Run generation plugin
3. Implement endpoint a