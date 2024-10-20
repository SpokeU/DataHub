## Use cases

1. ####  [Create connection](connection-create.md)
2. #### [Test connection](connection-test.md)


### Edit connection
Prerequisites - [Create connection](#create-connection)
1. [Update connection](#update-connection)

### Delete connection
Prerequisites - [Create connection](#create-connection)

---
## Operations

### Update connection
Does not do partial update. This will replace all fields with provided ones

**PUT** `/connections/{id}`

###### Update postgres connection
**Request**
```json
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

### Delete connection
Deletes a connection with specified id

**DELETE** `/connections/{id}` 

###### Delete connection success
**Response**  
200 OK

###### Delete connection failure
**Response**
500 Error
```json
{
  "code": "CN24",
  "msg": "Cannot delete connection which is currently in use"
}
```