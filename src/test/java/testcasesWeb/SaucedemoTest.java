package testcasesWeb;

import base.BaseClass;
import config.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class SaucedemoTest extends BaseClass {

    private ConfigReader configReader = new ConfigReader();
    String Url1 = configReader.getBaseUrl1();
    String Url2 = configReader.getBaseUrl2();
    String Url3 = configReader.getBaseUrl3();
    String username = configReader.getUsername();
    String password = configReader.getPassword();
    String usernameInvalid = configReader.getUsernameInvalid();
    String passwordInvalid = configReader.getPasswordInvalid();


    @Test
    public void loginTest() {
        // Create an instance of the LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Open the website
        driver.get(Url3);

        // Perform login
        loginPage.login(username, password);

        // Add assertions or further verifications as needed
        // For example, you can verify that the login was successful by checking the presence of a dashboard element.
    }
    @Test
    public void productSelect()
    {
        //loginTest();
        ProductPage productPage = new ProductPage(driver);
        productPage.setProductSelect();

    }


}


