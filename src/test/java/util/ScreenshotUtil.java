package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String fileNameWithLocation) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File destination = new File(fileNameWithLocation);
        try {
            Files.copy(screenshot.toPath(), destination.toPath());
            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
