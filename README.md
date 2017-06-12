## curly-winner
# Work Order Priority Queue

This is a priority queue to sort out a list of work orders of different types viz. normal, priority, vip, management. Work orders with ID and epoch time can be added to the queue. The order of the list depends on the type of work order (management > vip > priority > normal) and the time it has spent in the queue. This application can be deployed as a web service and its endpoints follow REST best practices.

## Getting Started

The project can be downloaded or cloned from https://github.com/raghav2008gupta/curly-winner.git

You will need JDK 8 or above, Spring Boot and a Java IDE to start working with this project.

This project is developed with Eclipse Neon.3 Release (4.6.3)

## Prerequisites

Gradle Build Tool is required to get a produciton build of the web service and JRE (Java Runtime Environment) is required to deploy it.

Depending on the platform, you can install the prerequisites by following the procedures given at-

##### JRE
	https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
	http://openjdk.java.net/install/

##### Gradle
	https://gradle.org/install

## Installation

Clone or download the repository from https://github.com/raghav2008gupta/curly-winner.git

#### Build Process
Build the web service by running the following command in the project folder-
    
    $ ./gradlew build

#### Running the tests
To execute the test cases run the following command in the project folder-
    
    $ ./gradlew test

#### Deployment
Deploy the web service using the JAR file in the `build/lib` directory-
    
    $ java -jar build/libs/WorkOrderWebService-0.1.0.jar

## Using the Web Service

Work order attributes are defined as follows-
* ID - An integer value with in the range of 1 - 9223372036854775807 both inclusive.
* Date & Time - An integer value with in the range of 0 - 9223372036854775807 both inclusive. Epoch time is the prefered input for this attribute.

This web service can be used at `http://server-ip:8080/` with the following endpoints-
##### Enqueue
	tag 	- /enqueue
	param1  - id
	param2  - datetime
	return  - 200 ok & JSON object
	        - 400 bad request
	example
		request  - http://localhost:8080/enqueue?id=10&datetime=1497202104
		response - {"status":true}
##### Dequeue
	tag 	- /dequeue
	return  - 200 ok & JSON object
	        - 400 bad request
	example
		request  - http://localhost:8080/dequeue
		response - {"WorkOrder":{"id":10,"dateTime":1497202104}}
##### List
	tag 	- /list
	return  - 200 ok & JSON object
	        - 400 bad request
	example
		request  - http://localhost:8080/list
		response - {"list":[15,12,10]}
##### Remove
	tag 	- /remove
	param1	- id
	return  - 200 ok & JSON object
	        - 400 bad request
	example
		request  - http://localhost:8080/remove?id=15
		response - {"status":true}
##### Position
	tag 	- /position
	param1	- id
	return  - 200 ok & JSON object
	        - 400 bad request
	example
		request  - http://localhost:8080/position?id=12
		response - {"position":1}

##### Average Wait
	tag 	- /avgwait
	param1  - datetime
	return  - 200 ok & JSON object
	        - 400 bad request
	example
		request  - http://localhost:8080/avgwait?datetime=1497202234
		response - {"avgwaittime":120}

*The client and server are running on the same machine for all the above examples*

## Built With

* [Spring](https://spring.io/docs) - Web Framework
* [Gradle](https://gradle.org/docs) - Build tool
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Raghav Gupta** - (https://github.com/raghav2008gupta)

## Acknowledgments

* Spring - Getting Started Guides (https://spring.io/guides)

