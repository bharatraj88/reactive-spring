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
1. Java 1.8 or higher installed
2. Mongo DB 3.6 or higher installed (https://www.mongodb.com/)
3. Maven installed (https://maven.apache.org/install.html)

Run Application:
----
mvn install && java -jar target/reactive-spring-0.0.1-SNAPSHOT.jar

View Rest Api Documentation:
-----
Swagger is integrated to the application. To view documentation, follow the below url after running the application
http://localhost:8080/swagger-ui.html


Assumption:
------
GPS Device Id or Mobile App is capable of sending current location and speed of vehicle by invoking a rest end point.
Devices are capable of sending location between the configured/updatable from and time for the configurable frequency of pings.
Devices are authenticated with the App


Class Diagram:
------
![](https://github.com/bharatraj88/reactive-spring/blob/master/src/class-diagram.jpg)


Rest API's
-------------

 1.  URL:  /asset  <br>
     Method : PUT   <br>
     Response : {string}   identified as device Id  <br>
     Request Body :  <br>
     >{ <br>
     >   "deviceType": ["GPS_DEVICE"/"MOBILE"], <br>
     >   "driverName": "string", <br>
     >   "trackingConfig": { <br>
     >     "deviceId": "string", <br>
     >     "manufacturer": "string", <br>
     >     "phoneNumber": "string", <br>
     >     "trackFromTime": "HH:mm:ss", <br>
     >     "trackToTime": "HH:mm:ss", <br>
     >     "trackingFrequency": "HH:mm:ss", <br>
     >     "userName": "string"  <br>
     >   },  <br>
     >   "vehicleNumber": "string" <br>
     > } <br>

Creates an Asset or vehicle information. Sends request to the IOT Device / Mobile App / GPS Device  to log location \ speed information between the time specified as trackFromTime  and trackToTime  for every interval specified by trackingFrequency. <br>

Assumption: IOT Device / Mobile App / GPS device is capable of sending rest request to log information

2. URL : /asset/{id} <br>
   Method : DELETE  <br>
   
   Removes the asset identified by Id in the url path parameter
   
3.   URL:  /asset/driver/link  <br>
     Method : POST   <br>
     Request Body :  <br>
       >{ <br>
       >   "assetId": "string", <br>
       >   "deviceType?": ["GPS_DEVICE"/"MOBILE"], <br>
       >   "driverName?": "string", <br>
       >   "trackingConfig?": { <br>
       >     "deviceId?": "string", <br>
       >     "manufacturer?": "string", <br>
       >     "phoneNumber?": "string", <br>
       >     "trackFromTime?": "HH:mm:ss", <br>
       >     "trackToTime?": "HH:mm:ss", <br>
       >     "trackingFrequency?": "HH:mm:ss", <br>
       >     "userName?": "string" <br>
       >   } <br>
       > } <br>
     
  Links a Driver to the Asset\Vehicle.  Driver Mobile information can also be linked to the Asset in case the vehicle is not embeded with a GPS Device. There by allowing the driver to move within vehicle. <br>
  
  Doesn't allow to link a new driver to a asset, if its already linked with a driver. If a new driver has to be linked, you need delink the asset and then link it with new driver info
  
  4. URL : /asset/driver/delink/{id}  <br>
     Method : POST <br> 
     
     Delinks an Asset\Vehicle with the driver. Asset Id expected as part of the url path parameter
     
  5. URL : /location/log <br>
     Method : POST <br>
     Request Body :  <br>
       >{  <br>
       >   "additionalData?": "string",  <br>
       >   "assetId": "string",  <br>
       >   "location": "string",  <br>
       >   "logTime": "MM/dd/yyyy HH:mm:ss",  <br>
       >   "speed": "number"  <br>
       > }  <br>
    
    Logs the location and speed information. Rest request made from the device to the application.
      
