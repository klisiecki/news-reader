# news-reader

Demo web application for browsing news. It allows to browse top headlines which can be filtered by language and category.

## Technical description

*news-reader* consumes the REST API provided by [newsapi.org](https://newsapi.org/docs/endpoints/top-headlines) 
and provides similiar REST endpoint.

### Software stack

List of languages, frameworks etc. used in this project:
* Java
* Kotlin
* Spring Boot
* Gradle
* JUnit
* TODO

On the backend side, *news-reader* uses Java and Kotlin languages. Altough mixing these two may not be the best option for new projects
(you could go all-Kotlin ;), this project presents how existing Java applications may benefit from using Kotlin. 

### REST API specification

TODO

## Building and running 

This application uses Gradle build system. You can run this app from an IDE like IntelliJ IDEA or Eclipse - 
just start the *Application* class. 

To start *news-reader* from console, it is recommended to use Gradle Wrapper (provided with sources). 
Use this command to run the application directly:
````
./gradlew bootRun
````
