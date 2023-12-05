package pages;

import base.BaseClass;
import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    By Username = By.id("user-name");
    By Password = By.id("password");
    By LoginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(Username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(Password).sendKeys(password);
    }
    //Method to click on Login button
    public void clickLogin() {
        driver.findElement(LoginBtn).click();
    }

    // Login method
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

}
