## Test connection

Check if connection can be established and returns status

#### Prerequisites
- [Create connection](#create-connection)


**POST** `/connections/{id}/test`
{id} - Connection id from [create connection response](create-connection.md)  

###### Success
**Response**

```json
{
  "success": true,
  "message": "Connected successfully"
}

```

###### Failure
**Response**
```json
{
  "success": false,
  "message": "Invalid user name or password"
}
```