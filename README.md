================================

Still in development. Very simple concept to try out using Spring Boot, Data JPA, in-memory (hibernate) db with persistent SQL option.
Application Requires/Java Dependencies:
Java JDK 1.8
Maven 3.5.0
Spring Boot (spring-boot-starter-parent - 1.4.7.RELEASE)
Spring Security
Spring Data JPA
Other libraries:
Bootstrap 3.3.7
jQuery 2.2.4
Build + Run:
$ mvn install
$ mvn clean spring-boot:run


API :

Spring Web
Spring Security
JPA
PostgreSQL
Spring Test

How To Build And Run : spring-angular-registration (backend)
Open file : spring-angular-registration/src/main/resources/application.yml
Suppose you are running on local environment, change property spring.profiles.active : into local
Open file spring-angular-registration/src/main/resources/application-local.yml
Change property log.file.path : depend on your local storage
Change property db.name, db.host, db.port, db.username, db.password depend on your local configuration
Compile :
    $ mvn clean package
or directly Run :
    $ mvn spring-boot:run
