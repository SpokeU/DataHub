# Project - DataHub

## Overview

### Problem statement

Developers often need to execute queries on various databases, share these queries with team members, and ensure
efficient collaboration on database-related tasks. Traditional methods of sharing queries (via messaging platforms,
documentations, or verbally) are inefficient and prone to errors

### Solution

**DataHub** aims to solve these problems by providing a centralized web platform for managing database connections,
sharing queries, executing them, and presenting results in a user-friendly manner.

Another use case is that product owners and business persons are often need to view specific data as well.
For example: A number of orders for previous month, a number of users that logged in at least once in last month etc.
This results in another query that developer creates, saves it somewhere and runs against DB to provide business with
results.

## Key features

### [**Connection Management**](#connection-management)

In order to execute any queries against any datasource we need to be able to connect to it whether its Postgres DB
connection or even a file.
This part of DataHub describes managing connection and connecting to datasource itself.

- Create, update, delete, and list database connections.
- Support for multiple database types, starting with popular relational databases (e.g., PostgreSQL, MySQL).
- Secure storage of database credentials and connection details.

Use Cases
- [Create connection](doc/api-use-cases/connection-create.md)
- [Test connection](connection-test.md)


