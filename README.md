# news-reader

Demo web application for browsing news. 
It allows to browse top headlines which can be filtered by language and category.

## Technical description

*news-reader* consumes the REST API provided by [newsapi.org](https://newsapi.org/docs/endpoints/top-headlines) 
and provides similar REST endpoint.

### Software stack

List of languages, frameworks etc. used in this project:
* Java
* Kotlin
* Spring Boot
* Gradle
* JUnit
* Bootstrap
* JQuery

On the backend side, *news-reader* uses Java and Kotlin languages. 
Although mixing these two may not be the best option for new projects (you could go all-Kotlin ;), 
this project presents how existing Java applications may benefit from using Kotlin. 

As of the frontend, this project uses JQuery and Bootstrap. 

### REST API specification

*news-reader* provides one simple endpoint: 

**GET /news/{lang}/{category}/**

which returns following response:
```js
{
  country: string?,
  category: string?,
  articles: {
    author: string,
    title: string,
    description: string,
    date: string(yyyy-MM-dd),
    sourceName: string,
    articleUrl: string,
    imageUrl: string
  }[]
}
```

## Building and running 

This application uses Gradle build system. You can run this app from an IDE like IntelliJ IDEA or Eclipse - 
just start the *Application* class. 

To start *news-reader* from console, it is recommended to use Gradle Wrapper (provided with sources). 
Use this command to run the application directly:
````
./gradlew bootRun
````

Then you can open <http://localhost:8080/> in the browser or use provided REST API


To create executable JAR and run it, use following commands:
````
./gradlew build
java -jar build/libs/news-reader-0.1.0.jar
````
