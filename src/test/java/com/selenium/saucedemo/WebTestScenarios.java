package com.selenium.saucedemo;


import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

import static java.lang.System.*;

public class WebTestScenarios extends BaseClass {

    //ExtentTest test1 = extent.createTest("Sauce Demo Automation", "Test to validate Functionality");

    //static WebDriver driver;
    //Calling out configuration things - Starts
    private ConfigReader configReader = new ConfigReader();
    String Url1 = configReader.getBaseUrl1();
    String Url2 = configReader.getBaseUrl2();
    String Url3 = configReader.getBaseUrl3();
    String username = configReader.getUsername();
    String password = configReader.getPassword();
    String usernameInvalid = configReader.getUsernameInvalid();
    String passwordInvalid = configReader.getPasswordInvalid();
//Calling out configuration things - Ends

    //  @BeforeMethod
    //public void beforeMethod()
    //{
    //  System.out.println("I am in beforeMetod - classOne");
    //driver = new ChromeDriver();
    //}

    /*
    @Test
    public void testZero()
    {

        driver.get(Url1);

    }

     */
//Opening google and typing into search
    /*@Test
    public void testOne()
    {
        driver.get(Url1);
        driver.manage().window().minimize();
        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("Test Automation");
        driver.manage().window().maximize();
        webElement.sendKeys(Keys.ENTER);
    }

     */

    @Test(priority = 0)
    public void testTwo()
    {
        ExtentTest test1 = extent.createTest("Open Yahoo Website", "Test to validate website opening of yahoo ");
        test1.log(Status.INFO, "Starting test case testTwo");
        driver.get(Url2);
        //driver.manage().window().minimize();
        test1.pass("testTwo Passed");

    }

    @Test(priority = 1)
    public  void login1() throws InterruptedException {
        ExtentTest test2 = extent.createTest("Open SauceDemo", "Test to validate Valid Credentials");
        test2.log(Status.INFO, "Starting test case, Login Successful");
        driver.get(Url3);
        driver.manage().window().minimize();
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        WebElement productsLabel = driver.findElement(By.className("product_label"));
        Assert.assertTrue(productsLabel.isDisplayed(), "Products");
        test2.pass("login1 Passed");
    }

    @Test(priority = 2)
    public void login2() {
        driver.get(Url3);
        driver.manage().window().maximize();
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys(usernameInvalid);
        passwordInput.sendKeys(passwordInvalid);
        loginButton.click();

        WebElement errorButton = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorButton.isDisplayed(), "Error message not displayed for invalid login!");
    }




  /*  @AfterMethod
    public void afterMethod()
    {
        System.out.println("I am in afterMetod - classOne");
        driver.quit();
    }*/

}
