package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import utils.PropertyReader;

public class WebDriverFactory {
    private final static String browser = PropertyReader.getProperty("browserType");
    private static ThreadLocal<WebDriver> driverLocalThread = new ThreadLocal<>();

    private static WebDriver getDriver(){
//        return switch (browser.toLowerCase()) {
//            case "chrome" -> new ChromeFactory();
//            case "edge" -> new EdgeFactory();
//            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
//        };
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        AbstractDriver abstractDriver = browserType.getDriverFactory();
        return abstractDriver.createDriver();
    }

    public static WebDriver initDriver(){
        WebDriver driver = ThreadGuard.protect(getDriver());
        driverLocalThread.set(driver);
        return driverLocalThread.get();
    }

    public static WebDriver get(){
        return driverLocalThread.get();
    }

    public static void quitDriver(){
        driverLocalThread.get().quit();
    }
}
