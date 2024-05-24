##
### Reusing schemas
```yaml
paths:
  /pets/{petId}:
    get:
      summary: Info for a specific pet
      operationId: showPetById
      parameters:
        - name: petId
          in: path
          required: true
          description: The id of the pet to retrieve
          schema:
            type: string
      responses:
        '200':
          description: Expected response to a valid request
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Pet"
components:
  schemas:
    Pet:
      type: object
      required:
        - id
        - name
      properties:
        id:
          type: integer
          format: int64
        name:
          type: string
        tag:
          type: string
```

### Reusing parameters
```yaml
paths:
  /pets/{petId}:
    get:
      summary: Info for a specific pet
      operationId: showPetById
      parameters:
        - $ref: '#/components/parameters/petId'

components:
  parameters:
    petId:
        name: petId
        in: path
        required: true
        description: The id of the pet to retrieve
        schema:
            type: string
```

### Importing definitions from a separate file
For example  
Create a new file named schemas/Pet.yaml for the Pet schema. Then, move the definition to the new file. Here's how the resulting file should look like:
```yaml
type: object
required:
- id
- name
properties:
id:
  type: integer
  format: int64
name:
  type: string
tag:
  type: string
```
Now, point $ref to the new file's location

```yaml
$ref: "./schemas/Pet.yaml"
```

## Open API Conventions

### Compose a clear and concise API title
`title:` 

**Bad examples**: 
- some-service-name
- auto-generated-api-name

**Good examples**:
- Bookstore Inventory
- Account Profile Management
- Image Conversion
- Inventory Threshold Management

### Write a comprehensive API description
`description:`
Describes what the API does, what was the intention of creating it and use cases of its usage


#### Bad examples:

- \<empty>
- \<the API title>
- Manages account profiles
- Account service
- An eCommerce API

#### Good example:

description: |
The Bookstore eCommerce API supports the shopping experience of an online bookstore. The API includes the following capabilities and operations:

__List Recent Books:__

  * List recently added books
  * Filtered list of books
  * View book details

__Use cases__:  

Place an Order:
  * [Create cart](#create-cart-operation)
  * [Add book to a cart](#put-to-cart-operation)
  * Remove book from a cart
  * Modify book already in a cart
  * View cart (including total price)
  * Create an order from cart

The following resource collections are offered by this API:

  * Books - represents the inventory available by the bookstore
  * Carts - supports shopping for books until ready for converting to an order
  * Cart Items - tracks the book + quantity added to a cart
  * Orders - a cart that has been converted to an order that may be tracked to delivery
  * Order Payments - tracks credit card payments applied to an order

### Take advantage of clear and useful operation identifiers

For example:

```yaml
paths:
  /books:
    get:
      operationId: ListBooks
```

```yaml
links:
  bookList:
    operationId: ListBooks
```

### Write a concise and complete operation summary

#### Bad examples:

- Get books
- Update the account
- Integrates with the DND system
- This endpoint/operation …

#### Good example:
```yaml
paths:
  /books:
    get:
      operationId: ListBooks
      summary: List books available in the book store for browsing, with filtering support to narrow the results
```