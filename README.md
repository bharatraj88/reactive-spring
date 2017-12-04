# Location Tracking

Problem:
A simple location tracker application that would receive data from IOT devices or
mobile on location of a given vehicle or person.

Tech Stack:
1. Java - 1.8
2. Spring Boot - 2.0.0
3. Mongo DB - 3.6

Setup Instructions
------
Prerequisite:
------
1. Java 1.8 or higher installed
2. Mongo DB 3.6 or higher installed
3. Maven installed

Run Application:
----
mvn install && java -jar target/reactive-spring-0.0.1-SNAPSHOT.jar

View Controller Documentation:
-----
Swagger is integrated to the application. To view documentation, follow the below url after running the application
http://localhost:8080/swagger-ui.html


Assumption:
GPS Device Id or Mobile App is capable of sending current location and speed of vehicle by invoking a rest end point.
Devices are capable of sending location between the configured/updatable from and time for the configurable frequency of pings.
Devices are authenticated with the App

Class Diagram
![](https://github.com/bharatraj88/reactive-spring/blob/master/src/class-diagram.jpg)

