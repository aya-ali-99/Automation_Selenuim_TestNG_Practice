package tests;

import drivers.WebDriverFactory;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonReader;
import utils.PropertyReader;

public class LoginTest {
    // Variables
    WebDriver driver;
    JsonReader loginData;

    // Test methods
    @Test
    public void validLoginTest(){
//        new LoginPage(driver)
//        .login(PropertyReader.getProperty("validUsername"), PropertyReader.getProperty("validPassword"))
//        .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
        new LoginPage(driver)
                .login(loginData.getJsonData("username"), loginData.getJsonData("password"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }
/*
    @Test
    public void invalidLoginTest() {
        Pages.LoginPage loginPage = new Pages.LoginPage(driver);
        loginPage.login("yassuo", "secret_sauce");
        Assert.assertTrue(loginPage.isLoggedIn("https://www.saucedemo.com/v1/inventory.html"));
    }
*/
    // Configurations
    @BeforeMethod
    public void setup(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        driver = new ChromeDriver(options);
        loginData = new JsonReader("loginData");
        driver = WebDriverFactory.initDriver();
        driver.get(PropertyReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
//        driver.quit();
        WebDriverFactory.quitDriver();
    }
}
