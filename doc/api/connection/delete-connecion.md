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