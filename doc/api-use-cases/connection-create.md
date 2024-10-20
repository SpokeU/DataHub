### Create connection
1. [Connection types](#get-connection-types) - Get supported connection types (POSTGRES, MY_SQL)
2. [Connection parameters](#connection-type-parameters) - Get fields required for creating connection of selected type ([Postgres](#postgres-parameters))
3. [Create connection](#create-connection-1) - ([Postgres](#postgres-connection-creation))

### Get connection types
**GET** `/connections/types`

###### Available connection types
**Response**
```json5
[
  {
    "type": "PG",  //ConnectionTypeEnum
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

---
### Connection parameters
Returns list of input fields that needs to be filled to create a connection

**GET** `/connections/{type}/parameters`  
{type} - 'type' field returned from [Connection types](#get-connection-types)

###### Postgres connection type parameters
**Response**

```json5
[
  { //InputField
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

###### Postgres connection creation
**Request**

```json5
{
  "name": "User DB",
  "type": "PG", //ConnectionTypeEnum
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
  "type": "PG", //ConnectionTypeEnum
  "details": {
    "host": "localhost",
    "port": 15432,
    "database": "users_db",
    "username": "my_user",
    "password": "my_password"
  }
}
```