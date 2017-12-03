# Location Tracking

Problem:
A simple location tracker application that would receive data from IOT devices or
mobile on location of a given vehicle or person.

Tech Stack:
Java - 1.8
Spring Boot - 2.0.0
Reactive Mongo DB

Assumption:
GPS Device Id or Mobile App is capable of sending current location and speed of vehicle by invoking a rest end point.
Devices are capable of sending location between the configured/updatable from and time for the configurable frequency of pings.
Devices are authenticated with the App

Class Diagram
![](https://github.com/bharatraj88/reactive-spring/blob/master/src/class-diagram.jpg)

