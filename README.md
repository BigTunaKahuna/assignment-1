### Introduction

The project is pretty simple, and to give a short overview of the technologies used:
* Spring-Boot with Kotlin
* Maven
* SQLite
* Liquibase
* Basic authentication

Regarding functionalities, there is the DrugSafetyReportController that has the main endpoints for interacting with the
endpoints mentioned in the document.

For authentication, it uses Basic Auth. For creating users, use UserController. Behind the scenes, when a user is
 created, it is using bcrypt for the password.

### Running the project
To start the project, run the below command. It will automatically create and use a local SQLite DB.
```shell
./mvnw spring-boot:run
```

To create a docker image, use:
```shell
./mvnw clean spring-boot:build-image
```
This will automatically create an image; no need for Docker files.

### Folder structure
It is a classic folder structure using:
* Configuration:
  * Handling bean creation
  * Handling security
* Controller
  * Endpoints
  * Controller errors
* DTO
  * Different models
* Exception
* Mapper
* Repository
  * Converter for converting the ReportStatus enum
  * Models aka entities
  * Repository interfaces and custom sorting/filtering
* Service
* Liquibase

For most of the stuff, this folder architecture should do.

### SQL Indexes
All the indexes for now are under [v2_add_indexes_reports.sql](src/main/resources/db/changelog/sql/v2_add_indexes_reports.sql),
which should cover most filtering and sorting needs based on productName, timestamp, statusReport, and the composite
ts_status_id_product_name.

Mentions: the indexes cover what I think would be fitting, and not a real-life use case, but adding or removing indexes 
is the easy part. Understanding how your data is used is where the gold is. Depending on the needs, we could take this
one even further and make use of ElasticSearch to have a performant solution for searching, but even that has pros and cons
i.e. having an up-to-date version of the Relational DB Instance in regard to data.

### Improvements
1. For a toy application, using basic authentication is fine, but for a proper one, I would recommend using OAuth2.
2. Authorized controllers, depending on permissions.
3. Using ElasticSearch for filtering and sorting.
4. Optimistic locking for running multiple instances of the same app.
5. Adding Swagger/OpenAI.
6. Using TestContainers for integration testing.
7. If this were a serverless application, I would go with Quarkus for GraalVM.
8. Add metrics and tracing.
9. Add a circuit breaker.
10. Consider a rate limiter if not already limited by upstream.
11. Add caching to endpoints

Regarding design decisions, I can't say there is anything too complicated about this.
