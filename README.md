# saleskin-test
It is a sample todo app, it can read,save,update and filter todolist. H2 runtime is used to persist data and JPA is used to retrieve and persist data.

•	H2 console accessible at http://localhost:8080/h2-console

•	Custom exception will be thrown if no data is found for requested id with proper message. curl -X GET http://localhost:8080/todo/34 -v

•	Separation of concern is addressed

      a) Datasource can be configured for other db. example oracle,sql
      b) Controller,Service and Repository are created.
      c) Global exception handler will handle exception, no code is written inside controller to throw exception and HTTP status in case of error.
      
•	Code is self readable, Interfaces are created, it can handle changes for ex. by configuring datasource in application.properties new database can be configured.


## Installation
Download or clone this repo. and import it as a maven project, run maven update to install dependencies.


## Usage
Run SaleskinMainApp.java file as java application.

## curl instruction

```python
GET

   Request:  curl -X GET http://localhost:8080/todos  # returns list of all todos either active or inactive
   
   Response: [{"id":1,"title":"Tea","desc":"prepare a cup of Tea","active":true},{"id":2,"title":"Newspaper","desc":"Read Newspaper daily","active":true},{"id":3,"title":"Call MOM","desc":"say hi to MOM","active":true},{"id":4,"title":"Inactive todo","desc":"Description for Inactive todo","active":false}]
   
   
   Request:  curl -X GET http://localhost:8080/todo/1  
   # return todo by id
   
   Response: {"id":1,"title":"Tea","desc":"prepare a cup of Tea","active":true}
   
   Request: curl -X GET http://localhost:8080/todos/active 
   # returns list of only active todos
   
   Response: [{"id":1,"title":"Tea","desc":"prepare a cup of Tea","active":true},{"id":2,"title":"Newspaper","desc":"Read Newspaper daily","active":true},{"id":3,"title":"Call MOM","desc":"say hi to MOM","active":true}]
   
   ```
  ```python 
POST  (Save todo/todos)

    Request: curl -X POST http://localhost:8080/todo  -H "cache-control: no-cache" -H "Content-Type: application/json" -d "{\"title\":\"Read book\",\"desc\":\"Read book daily at 8PM\"}" -v     
    #return 201 created with verbose response
    
    Request: curl -X POST http://localhost:8080/todos  -H "cache-control: no-cache" -H "Content-Type: application/json" -d "[{\"title\":\"Tea\",\"desc\":\"prepare a cup of Tea\"},{\"title\":\"Newspaper\",\"desc\":\"Read Newspaper daily\"},{\"title\":\"Call MOM\",\"desc\":\"say hi to MOM\"}]"           
    #retrun 201 create for bulk insertion 
 ```
 
```python
PUT   (Update todo)

    Request: curl -X PUT http://localhost:8080/todo  -H "cache-control: no-cache" -H "Content-Type: application/json" -d "{\"title\":\"Read book\",\"desc\":\"Read book daily at 8PM\",\"active\":false}" -v    
    #return 200, update todo and inactive it. 
  ```

```python
DELETE  (Delete todo)

    Request: curl -X DELETE http://localhost:8080/todo/1
    #return 200 on sucessful delete
```    
