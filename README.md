# News Portal


## Built With
*   [Angular 11](https://angular.io)
*   [Angular CLI](https://cli.angular.io)
* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[H2](https://https://www.h2database.com/) - Relational Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system

## External Tools Used

* 	[Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.News_portal.NewsPortalApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Angular - Build 

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Database configuration

* 	In its default configuration, aplication uses an in-memory database (H2) which gets populated at startup with data. The h2 console is automatically exposed at http://localhost:8080/h2-console and it is possible to inspect the content of the database using the jdbc:h2:mem:~/test url. User name is: sa

### Security


~~Default username is `admin` and password is `admin1234`~~


### URLs

|  URL |  Method | Description |
|----------|--------------|--------------|
|`http://localhost:8080/login`  | POST | Log in for admins |
|                       |  |  |


### URLs - Admin

|  URL |  Method | Description |
|----------|--------------|--------------|
|`http://localhost:8080/api/admin/{username}` | GET | List of all news created by specific admin |
|`http://localhost:8080/api/admin/create`    | POST | Create an article|
|`http://localhost:8080/api/admin/{id}` | PUT | Update an article |
|`http://localhost:8080/api/admin/{id}` | DELETE | Delete an article |

### URLs - News

|  URL |  Method | Description |
|----------|--------------|--------------|
|`http://localhost:8080/api/news` | GET | List of all news |
|`http://localhost:8080/api/news/{id}`  | GET | Get article by id|
|`http://localhost:8080/api/news/{title}` | GET | Get article by title |



## packages

* 	`models` — to hold our entities;
* 	`repositories` — to communicate with the database;
* 	`services` — to hold our business logic;
* 	`security` — security configuration;
* 	`controllers` — to listen to the client;

* 	`resources/` - Contains files to populate database.
* 	`resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

* 	`test/` - contains unit and integration tests

* 	`pom.xml` - contains all the project dependencies
