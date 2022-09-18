# MC Beers Cucumber with REst Assured

## Dependency

* [Project MC-Beers](https://github.com/andrelsf/mc-beers)
* Java 11
* Maven 5.8
* Allure CLI

```shell
npm install -g allure-commandline
```
 
## Running

```shell
mvn clean install
mvn clean test
allure serve target/allure-results
```