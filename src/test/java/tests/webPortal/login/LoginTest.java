package tests.webPortal.login;

import drivers.WebDriverFactory;
import io.qameta.allure.*;
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
    @Description("Verify that the user is redirected to home page after providing valid credentials")
    //@Tags("Valid Login")
    @Owner("Aya")
    @Severity(SeverityLevel.CRITICAL)
    //@Links("Link to anything useful")
    @TmsLink("Link to test case in test management tool")
    //@Issue("Link to related issue in issue tracking system")
    public void validLoginTest(){
//        new LoginPage(driver)
//        .login(PropertyReader.getProperty("validUsername"), PropertyReader.getProperty("validPassword"))
//        .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");

        // Change the test case name in the Allure report
        Allure.getLifecycle()
                .updateTestCase(testResult ->{
                                testResult.setName("Valid Login");
                                } );

        new LoginPage(driver)
                .login(loginData.getJsonData("username"), loginData.getJsonData("password"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }

    // Behavioral-based hierarchy
    @Epic("Web Portal")
    @Feature("Login Feature")
    @Story("Invalid Login Scenario")
    @Test
    public void invalidLoginTest() {
        /*
        Pages.LoginPage loginPage = new Pages.LoginPage(driver);
        loginPage.login("yassuo", "secret_sauce");
        Assert.assertTrue(loginPage.isLoggedIn("https://www.saucedemo.com/v1/inventory.html"));
         */
        Allure.getLifecycle()
                .updateTestCase(testResult ->{
                    testResult.setName("Invalid Login");
                } );

        new LoginPage(driver)
                .login(loginData.getJsonData("invalidUsername"), loginData.getJsonData("password"))
                .isLoggedIn("https://www.saucedemo.com/v1/inventory.html");
    }

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
