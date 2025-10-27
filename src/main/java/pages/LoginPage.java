package pages;

import bots.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    // Variables
    private WebDriver driver;
    private ActionsBot actionsBot;

    // Locators
    private final By usernameField = new By.ById("user-name");
    private final By passwordField = new By.ById("password");
    private final By loginButton = new By.ById("login-button");

    // Constructors
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);
    }

    // Actions
    @Step("Login to web portal with username: {username} and password: {password}")
    public LoginPage login(String username, String password){
//        driver.findElement(usernameField).sendKeys(username);
//        driver.findElement(passwordField).sendKeys(password);
//        driver.findElement(loginButton).click();
        actionsBot.type(usernameField, username);
        actionsBot.type(passwordField, password);
        actionsBot.click(loginButton);
        return this;
    }

    @Step("Verify that the user is logged in by checking the current URL: {expectedURL}")
    public HomePage isLoggedIn(String expectedURL){
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        return new HomePage(driver);
    }
}
