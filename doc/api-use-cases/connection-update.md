## Update connection

Updates connection details

### Prerequisites
- [Create connection](#create-connection)


**POST** `/connections/{id}/test`

###### Connection test result successful
**Response**

```json
{
  "success": true,
  "message": "Connected successfully"
}

```

###### Connection test result failure
**Response**
```json
{
  "success": false,
  "message": "Invalid user name or password"
}
```