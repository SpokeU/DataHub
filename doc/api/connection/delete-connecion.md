#### Meta info
Environment: PROD


<head>
    <div style="display: flex; justify-content: right;">
        <div style="background-color: green; padding: 5px">PROD</div>
    </div>    
</head>

### Delete connection
Deletes a connection with specified id

#### Prerequisites
- [Create connection](create-connection.md)

**DELETE** `/connections/{id}`  
{id} - Id of connection

###### Success
**Response**  
200 OK

###### Failure
**Response**  
500 Error
```json
{
  "code": "CN24",
  "msg": "Cannot delete connection which is currently in use"
}
```