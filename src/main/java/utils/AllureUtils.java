package utils;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Path;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static java.nio.file.Files.newInputStream;

public class AllureUtils {
    // Method to clean Allure results directory
    public static void cleanAllureResults() {
        FileUtils.deleteQuietly(
                new java.io.File("test-output/allure-results")
        );
    }

    public static void attachScreenShotToAllure(String screenShotName, String screenShotPath){
        try{
            Allure.addAttachment(screenShotName, newInputStream(Path.of(screenShotPath)));
        }catch (Exception e) {
            System.out.println("Failed to attach screenshot to Allure report: " + e.getMessage());
        }
    }

    public static void setAllureEnvironmentInfo(){
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("OS", PropertyReader.getProperty("os.name"))
                        .put("JDK Version", PropertyReader.getProperty("java.runtime.version"))
                        .put("URL", "https://www.saucedemo.com/v1/inventory.html")
                        .build(),
                PropertyReader.getProperty("user.dir") + File.separator +
                "test-output/allure-results" + File.separator
        );
    }
}
