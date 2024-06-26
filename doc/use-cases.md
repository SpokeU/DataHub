## Use cases

### Create connection
Some description
- [Connection types](#get-connection-types) - Get supported connection types (POSTGRES, MONGO)
- [Connection parameters](#connection-type-parameters) - Get fields required for creating connection of selected type (
  for example POSTGRES)
- [Create connection](#create-connection-1)
- [Test connection](#connection-test-result-successful) - Check if connection can be established




## Operations

### Get connection types

<span style="color:blue; font-weight:700; font-size:16px">GET</span> `/connections/types`

```json5
[
  {
    "type": "PG",
    "name": "Postgres",
    "description": "Standard postgres connection",
    "logoUrl": "/logos/posgres_icon.url"
  },
  {
    "type": "MY_SQL",
    "name": "MySQL",
    "description": "Standard MySql connection",
    "logoUrl": "/logos/posgres_icon.url"
  }
]
```

### Connection type parameters
Returns list of input fields that needs to be filled to create a connection

**GET** `/connections/{type}/parameters`

**Response**

###### Postgres parameters

```json5
[
  {
    "name": "host",
    "type": "text",
    "required": true
  },
  {
    "name": "port",
    "type": "number",
    "required": true
  },
  {
    "name": "database",
    "type": "text",
    "required": true
  },
  {
    "name": "username",
    "type": "text",
    "required": true
  },
  {
    "name": "password",
    "type": "password",
    "required": true
  }
]
```

---

### Create connection
Creates new connection, so later it can be used to run queries

**POST** `/connections`

**Request**

###### Postgres connection

```json5
{
  "name": "User DB",
  "type": "PG",
  "details": {
    "host": "localhost",
    "port": 15432,
    "database": "users_db",
    "username": "my_user",
    "password": "my_password"
  }
}
```

**Response**

```json5
{
  "id": 1,
  "name": "User DB",
  "type": "PG",
  "details": {
    "host": "localhost",
    "port": 15432,
    "database": "users_db",
    "username": "my_user",
    "password": "my_password"
  }
}
```

### Test connection
Tests the connectivity and return status

**POST** `/connections/{id}/test`

**Request**
``

**Response**

###### Connection test result successful
```json
{
  "success": true,
  "message": "Connected successfully"
}

```

###### Connection test result failure
```json
{
  "success": false,
  "message": "Invalid user name or password"
}
```

