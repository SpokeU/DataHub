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
