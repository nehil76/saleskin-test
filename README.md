# saleskin-test
It is a sample todo app, it can read,save,update and filter todolist.

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
