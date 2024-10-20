### Get connection types

Returns list of supported [connection types](../../general/vocabulary.md#connection-type)

**GET** `/connections/types`

###### All connection types
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