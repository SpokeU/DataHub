## Update connection

Does not do partial update. This will replace all fields with provided ones

### Prerequisites
- [Create connection](#create-connection)

**PUT** `/connections/{id}`  
{id} - Id of connection

###### Update postgres connection
**Request**
```json5
{
  "name": "Admin DB",
  "details": {
    "host": "localhost",
    "port": 15432,
    "database": "admin_db",
    "username": "admin_user",
    "password": "admin_password"
  }
}
```

**Response**

```json
{
  "id": 1,
  "name": "Admin DB",
  "type": "PG",
  "details": {
    "host": "localhost",
    "port": 15432,
    "database": "admin_db",
    "username": "admin_user",
    "password": "admin_password"
  }
}
```