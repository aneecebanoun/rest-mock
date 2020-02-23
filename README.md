#####download project dependencies#####
mvnw install
#####package to jar#####
mvnw package
#####run#####
switch to target directory then run:
java -jar rest-mock-0.0.1-SNAPSHOT.jar

access app from http://localhost:9999

