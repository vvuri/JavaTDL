# JavaTDL
Java Test-Driven Learning

Open API for test: 
https://reqres.in/

Add Gradle
```
$ gradle init
$ gradle build
  BUILD SUCCESSFUL in 8s
  4 actionable tasks: 2 executed, 2 up-to-date
```
run my task:
```
$ gradle -q version
```
### Allure run server
```
$ gradle clean build
$ gradle allureServe
```
- html in JavaTDL/build/reports/tests/test/index.html
- server run browser page automate
- Doc https://docs.qameta.io/allure/#_gradle_3
