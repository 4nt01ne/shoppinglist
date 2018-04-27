# shoppinglist
this application to play with Spring Boot and ES6.
    
The idea is to run:
* a backend serving shopping lists and endpoints to keep you own custom lists
* a frontend serving webpages ES6 javascript based.

It is using frontend-maven-plugin to translate ES6 into ES5:
* by installing node.js and npm
* running Webpack
* putting all your javascripts in a jar available for your backend.

It is using spring-boot to run the backend.

## Compile
From the root directory: mvn clean install

## Debug Javascript
From the shopping-fe directory run: ./node_modules/.bin/webpack-dev-server --inline --hot
It will start a webpack-dev-server. Modifications to your javascripts will automatically be reloaded in the browser.
You can access a dummy html page on http://localhost:8080/tmp/index.html.

## Run
In shoppinglist-be: java -jar target/shoppinglist-be-1.0-SNAPSHOT.jar

## Test it running
In a browser, 
* if ES6 javascript is successfully server by your Spring MVC then you will read 'Hello World!' from http://localhost:8090/index.html
* the default shopping list should be retrieved in JSON format from http://localhost:8090/proposedItems

Setting up the project for ES6 with Webpack is done using well documented article on <http://justincalleja.com/2016/04/17/serving-a-webpack-bundle-in-spring-boot>
