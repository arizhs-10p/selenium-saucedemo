FROM openjdk:8
EXPOSE 8080
ADD target/selenium-saucedemo.jar selenium-saucedemo.jar
ENTRYPOINT ["java","-jar","/selenium-saucedemo.jar"]