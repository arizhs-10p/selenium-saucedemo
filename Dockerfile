FROM openjdk:17
EXPOSE 8082
ADD target/selenium-saucedemo.jar selenium-saucedemo.jar
ENTRYPOINT ["java","-jar","/selenium-saucedemo.jar"]