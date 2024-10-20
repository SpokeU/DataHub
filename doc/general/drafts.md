_Feature це дизайн + UseCases. Тобто це міні система - часто інтегрована в середину існуючої хоча і не обовязково._

### [**Query Management**](#query-management)

- Query editor for writing, saving, editing, deleting, list queries
- Query parametrization
- Different query languages based on the database type
- Share queries with other users or groups.

### [**Query Execution**](#query-execution)


### Overview

_Intention and why. What problem does it solves in scope of a project. Describe how overall feature intention_

### Solution Overview

How each requirement will be implemented
Diagram  
**Layers**  
UI  
API  
DB

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

### [Conventions](doc/general/conventions.md)