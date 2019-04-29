# README #

### What is this repository for? ###
Demo to show how to use Jet Cache with Redis in a Spring Boot application.

### How do I get set up? ###

* Build with maven
mvn package

* Run the jar in **dev** mode
java  -Dspring.profiles.active=dev  -jar target/cirrus-up-cloud-demo-jet-cache-1.0-SNAPSHOT.jar


### Curl Requests ###

curl -X PUT http://localhost:8080/put/myid/AnnaKarenina

curl -X GET http://localhost:8080/get?id=myid
Title: AnnaKarenina

curl -X GET http://localhost:8080/get?id=myid
Item not found