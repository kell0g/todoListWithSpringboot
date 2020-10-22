# todoListWithSpringboot

## Task Object

- Task
  - (Long) id
  - (String) descrytion

## CRUD Example

- API

| Method | URLS       | Actions                      |
| ------ | ---------- | ---------------------------- |
| GET    | /tasks     | 모든 작업 리스트를 가져오기  |
| GET    | /tasks/:id | 해당 id를 가진 작업 가져오기 |
| DELETE | /tasks/:id | 해당 id를 가진 작업 삭제하기 |
| POST   | /tasks     | 작업 추가하기                |

## Postgres Configuration

- postgresSQL

```property
server.port=3000

spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
spring.datasource.username=todolist
spring.datasource.password=1234

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=create
```
