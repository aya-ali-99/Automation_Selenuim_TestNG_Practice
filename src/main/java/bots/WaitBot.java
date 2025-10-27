package bots;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class WaitBot {
    private WebDriver driver;

    public WaitBot(WebDriver driver){
        this.driver = driver;
    }

    public FluentWait<WebDriver> fluentWait(){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoreAll(getExceptions());
    }

    private ArrayList <Class<? extends Exception>> getExceptions(){
        ArrayList <Class<? extends Exception>> execptions = new ArrayList<>();
        execptions.add(NoSuchElementException.class);
        execptions.add(StaleElementReferenceException.class);
        execptions.add(ElementNotInteractableException.class);
        execptions.add(ElementClickInterceptedException.class);
        return execptions;
    }

}
