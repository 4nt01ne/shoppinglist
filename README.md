# shoppinglist
this application if for playing with Spring Boot and ES6.
    
The idea is to run:
* a backend serving a proposed shopping list and endpoints to keep you own custom list and list states
* webpages ES6 javascript based.

It is using frontend-maven-plugin to translate ES6 into ES5:
* by installing node.js and npm
* running Webpack
* putting all your javascripts in a jar available for you backend.

It is using spring-boot run the backend.

## Compile
In shoppinglist-package directory: mvn clean install

## Run
In shoppinglist-be: java -jar target/shoppinglist-be-1.0-SNAPSHOT.jar

## Test it running
In a browser, 
* if ES6 javascript works from you Spring MVC then you will read 'Hello World!' from http://localhost:8080/index.html
* if you backend is serving the default shopping list then you'll get it in JSON format from http://localhost:8080/proposedItems
