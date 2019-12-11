#!/bin/bash

./mvnw clean install -DskipTests  
java -jar target/parkingLotAssignment-0.0.1-SNAPSHOT.jar

