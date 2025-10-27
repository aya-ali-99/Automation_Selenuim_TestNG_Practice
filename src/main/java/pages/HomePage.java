package pages;

import bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    // Variables
    private WebDriver driver;
    private ActionsBot actionsBot;

    // Locators
    private final By addToCartButton = new By.ByCssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button");
    private final By cartIcon = new By.ByCssSelector("#shopping_cart_container > a > span");

    // Constructors
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.actionsBot = new ActionsBot(driver);
    }

    // Actions
    public HomePage addToCart(){
//        driver.findElement(addToCartButton).click();
        actionsBot.click(addToCartButton);
        return this;
    }

    // Validations
    public HomePage validateCartIcon(){
//        String cartIconText = driver.findElement(cartIcon).getText();
        String cartIconText = actionsBot.getText(cartIcon);
        Assert.assertEquals(cartIconText, "1");
        return this;
    }
}
