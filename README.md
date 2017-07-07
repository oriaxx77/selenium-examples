# Selenium java project
This is an example project that shows how to use selenium in a java project to test browswer based applications.
It contains one test that uses the Google search engine's web interface (http://www.google.com) where it search for 
a keyword and checks the result. 

## Architecture
The project is built with **gradle** and the **src/test** folder
contains the java classes.

The [GoogleSearchTests.java](./src/test/java/com/oriaxx77/seleniumplay/GoogleSearchTests.java)
contains the selenium tests. It contains one test method that searches for the _keywords imdb star wars_, then checks 
the number of links that Google returns.
 
The application uses Spring as a IOC container and the JUnit framework. The Spring configuration can be found in 
[GoogleTestsConfig.java](./src/test/java/com/oriaxx77/seleniumplay/GoogleTestsConfig.java).

The application uses two drivers, the **Chrome web driver** and the **PhantomJs** web driver for 
headless browser testing. The drivers can be found in the [drivers](./drivers) folder.
The [GoogleSearchTests.java](./src/test/java/com/oriaxx77/seleniumplay/GoogleSearchTests.java) is annotated with the 
ActiveProfiles annotation that can be used to switch the active spring profiles.
You can use either _chrome_ or _headless_ as it's value.
 
## Building
Run **gradle clean build**.

## Running the tests
Run **gradle test**.
 